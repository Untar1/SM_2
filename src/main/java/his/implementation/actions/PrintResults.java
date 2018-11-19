package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.ExternalSystemIntegration;

import java.util.Scanner;

public class PrintResults implements Action {
    private Boundary boundary;
    private String patientId;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        patientId = getNotBlankLine(sc, "Enter patient ID: ");
    }

    @Override
    public void execute() {
        ExternalSystemIntegration.getInstance().printTestResults(patientId);
        System.out.println(String.format("Launched printing process to external system for patient => %s", patientId));
    }

    @Override
    public String description() {
        return "Print the Results of the Tests";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
