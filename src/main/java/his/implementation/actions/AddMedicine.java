package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.MedicineController;

import java.util.Scanner;

public class AddMedicine implements Action {
    private Boundary boundary;

    private String medicineName;
    private String companyName;

    @Override
    public void setContext() {
        Scanner scanner = systemIn();
        medicineName = getNotBlankLine(scanner, "Enter medicine name: ");
        companyName = getNotBlankLine(scanner, "Enter company name: ");
    }

    @Override
    public void execute() {
        String res = new MedicineController().addMedicine(medicineName, companyName);
        System.out.println(String.format("Created medicine with medicine ID: %s", res));
    }

    @Override
    public String description() {
        return "Add medicine to the hospital system list";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
