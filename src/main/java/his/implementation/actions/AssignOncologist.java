package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.FolderController;

import java.util.Scanner;

public class AssignOncologist implements Action {
    private Boundary boundary;

    private String patientId;
    private String oncologistId;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        oncologistId = getNotBlankLine(sc, "Enter oncologist id: ");
    }

    @Override
    public void execute() {
        FolderController controller = new FolderController();
        controller.setBoundary(boundary);
        controller.addOncologistToFolder(patientId, oncologistId);
        System.out.println(String.format("Added oncologist %s to patient folder %s", oncologistId, patientId));
    }

    @Override
    public String description() {
        return "Assign an Oncologist";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getOncologistId() {
        return oncologistId;
    }
}
