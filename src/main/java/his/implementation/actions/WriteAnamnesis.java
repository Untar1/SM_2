package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.AnamnesisController;
import his.sequence.diagrams.Boundary;

import java.util.Scanner;

public class WriteAnamnesis implements Action {
    private Boundary boundary;
    private String patientId;
    private String text;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        patientId = getNotBlankLine(sc, "Enter patient ID: ");
        text = getNotBlankLine(sc, "Enter patient anamnesis: ");
    }

    @Override
    public void execute() {
        AnamnesisController controller = new AnamnesisController();
        controller.setBoundary(boundary);
        controller.addAnamnesis(patientId, text);
        System.out.println(String.format("Added anamenesis to patient => %s", patientId));
    }

    @Override
    public String description() {
        return "Write Patient Anamnesis";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
