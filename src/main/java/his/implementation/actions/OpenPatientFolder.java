package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.FolderController;

import java.time.LocalDateTime;
import java.util.Scanner;

public class OpenPatientFolder implements Action {
    private Boundary boundary;
    private String name;
    private String surname;
    private String patientId;
    private LocalDateTime dob;
    private String insuranceCode;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        patientId = getNotBlankLine(sc, "Enter patient ID: ");
        name = getNotBlankLine(sc, "Enter patient name: ");
        surname = getNotBlankLine(sc, "Enter patient surname: ");
        dob = getDate(sc, "Enter date of birth (dd.MM.yyyy HH:mm): ", getFormat());
        insuranceCode = getNotBlankLine(sc, "Enter insurance code (This should be provided by UI but hey we have CLI app)");
    }

    @Override
    public void execute() {
        FolderController controller = new FolderController();
        controller.setBoundary(boundary);
        controller.openFolder(name, surname, patientId, dob, insuranceCode);

        AssignOncologist assign = new AssignOncologist();
        assign.setPatientId(patientId);
        assign.setBoundary(boundary);
        assign.setContext();
        assign.execute();

        SetFirstVisit setFirstVisit = new SetFirstVisit();
        setFirstVisit.setPatientId(patientId);
        setFirstVisit.setOncologistId(assign.getOncologistId());
        setFirstVisit.setBoundary(boundary);
        setFirstVisit.setContext();
        setFirstVisit.execute();

        System.out.println(String.format("Folder created for patient => %s", patientId));
    }

    @Override
    public String description() {
        return "Open a Patient Folder";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
