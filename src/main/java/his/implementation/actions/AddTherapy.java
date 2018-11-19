package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.FolderController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddTherapy implements Action {
    private Boundary boundary;
    private DateTimeFormatter format = getFormat();

    private String patientId;
    private LocalDateTime start;
    private LocalDateTime end;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        patientId = getNotBlankLine(sc, "Enter patient id: ");
        start = getDate(sc, "Enter start date (dd.MM.yyyy HH:mm): ", format);
        end = getDate(sc, "Enter end date (dd.MM.yyyy HH:mm): ", format);
    }

    @Override
    public void execute() {
        FolderController controller = new FolderController();
        controller.setBoundary(boundary);
        String therapyId = controller.addTherapy(patientId, start, end);
        System.out.println(String.format("Added therapy with id => %s", therapyId));
    }

    @Override
    public String description() {
        return "Add Therapy to the Patient Folder";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
