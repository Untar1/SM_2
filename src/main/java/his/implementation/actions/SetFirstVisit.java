package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.FolderController;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SetFirstVisit implements Action {
    private Boundary boundary;

    private String patientId;
    private String oncologistId;
    private LocalDateTime date;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        date = getDate(sc, "Enter date (dd.MM.yyyy HH:mm): ", getFormat());
    }

    @Override
    public void execute() {
        FolderController c = new FolderController();
        c.setBoundary(boundary);
        c.setFirstVisitDate(patientId, oncologistId, date);
        System.out.println(String.format("Set first visit for patient %s and oncologist %s to be %s", patientId, oncologistId, date));
    }

    @Override
    public String description() {
        return "Set date of the First Visit";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setOncologistId(String oncologistId) {
        this.oncologistId = oncologistId;
    }
}
