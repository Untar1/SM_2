package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.UserController;

import java.util.Collection;
import java.util.Scanner;

public class SeeAllDoctors implements Action {
    private Boundary boundary;
    private String doctorType;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        doctorType = getNotBlankLine(sc, String.format("Enter doctor type (%s / %s): ", Doctors.ONCOLOGIST, Doctors.SURGEON),
                line -> Doctors.ONCOLOGIST.equals(line) || Doctors.SURGEON.equals(line));
    }

    @Override
    public void execute() {
        UserController controller = new UserController();
        controller.setBoundary(boundary);
        Collection doctors = controller.getAllDoctors(doctorType);
        System.out.println(String.format("Fetched %d doctors", doctors.size()));
        doctors.forEach(System.out::println);
    }

    @Override
    public String description() {
        return "See All Doctors";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
