package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.ExternalSystemIntegration;

import java.util.Scanner;

public class CopyAndAddTests implements Action {
    private Boundary boundary;
    private String patientId;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        patientId = getNotBlankLine(sc, "Enter patient ID: ");
    }

    @Override
    public void execute() {
        ExternalSystemIntegration.getInstance().copyTestResults(patientId);
        System.out.println(String.format("Started result copying for patient => %s", patientId));
    }

    @Override
    public String description() {
        return "Copy and Add the Tests to the Folder";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
