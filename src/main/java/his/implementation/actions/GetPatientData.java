package his.implementation.actions;

import his.Folder;
import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.FolderController;

import java.util.Scanner;

public class GetPatientData implements Action {
    private Boundary boundary;
    private String patientId;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        patientId = getNotBlankLine(sc, "Enter patient id: ");
    }

    @Override
    public void execute() {
        FolderController controller = new FolderController();
        controller.setBoundary(boundary);
        Folder folder = controller.getPatientFolder(patientId);
        System.out.println(String.format("Retrieved patient folder %s", folder));
    }

    @Override
    public String description() {
        return "Retrieve All Information From the Patient Folder";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
