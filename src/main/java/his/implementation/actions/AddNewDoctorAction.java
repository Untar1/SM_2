package his.implementation.actions;

import com.google.common.base.Enums;
import his.OncologistType;
import his.SurgeonType;
import his.implementation.Action;
import his.implementation.Roles;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.UserController;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddNewDoctorAction implements Action {
    private Boundary boundary;

    private String profId;
    private String name;
    private String surname;
    private String type;
    private String subType;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        profId = getNotBlankLine(sc, "Enter professional ID: ");
        name = getNotBlankLine(sc, "Enter name: ");
        surname = getNotBlankLine(sc, "Enter surname: ");
        type = getNotBlankLine(sc, "Enter doctor type (Surgeon / Oncologist)", line -> Roles.ROLE_SURGEON.equals(line) || Roles.ROLE_ONCOLOGIST.equals(line));
        subType = getNotBlankLine(sc,
                String.format("Enter doctor sub type (Available values: %s): ", Roles.ROLE_ONCOLOGIST.equals(type)
                        ? String.join("\n", Arrays.stream(OncologistType.values()).map(Object::toString).collect(Collectors.toList()))
                        : String.join("\n", Arrays.stream(SurgeonType.values()).map(Object::toString).collect(Collectors.toList())))
                ,
                line -> line != null && (Roles.ROLE_SURGEON.equals(type)
                        ? Enums.getIfPresent(SurgeonType.class, line).isPresent()
                        : Enums.getIfPresent(OncologistType.class, line).isPresent())
        );
    }

    @Override
    public void execute() {
        UserController controller = new UserController();
        controller.setBoundary(boundary);
        String doctor = controller.addNewDoctor(profId, name, surname, type, subType);
        System.out.println(String.format("Added doctor with id: %s", doctor));
    }

    @Override
    public String description() {
        return "Add New Doctor to the System";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
