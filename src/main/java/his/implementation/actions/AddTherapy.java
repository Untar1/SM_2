package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.FolderController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddTherapy implements Action {
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
        String therapyId = new FolderController().addTherapy(patientId, start, end);
        System.out.println(String.format("Added therapy with id => %s", therapyId));
    }

    @Override
    public String description() {
        return "Add Therapy to the Patient Folder";
    }
}
