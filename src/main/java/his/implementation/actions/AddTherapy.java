package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.FolderController;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddTherapy implements Action {
    private String patientId;
    private LocalDateTime start;
    private LocalDateTime end;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        patientId = getNotBlankLine(sc, "Enter patient id: ");
        start = getNotBlankLine(sc, "Enter start date (dd.mm.yy HH:MM:ss): ", line -> {

        });

        end = getNotBlankLine(sc, "Enter end date (dd.mm.yy HH:MM:ss): ", line -> {

        });
    }

    @Override
    public void execute() {
        String therapyId = new FolderController().addTherapy(patientId, start, end);
        System.out.println(String.format("Added therapy with id => %s", therapyId));
    }

    @Override
    public String description() {
        return "Add Therapy to the Patient Folder";
    }
}
