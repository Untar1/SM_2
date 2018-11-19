package his.implementation.actions;

import his.Medicine;
import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.MedicineController;

import java.util.Collection;

public class SeeMedicines implements Action {
    private Boundary boundary;

    @Override
    public void setContext() {

    }

    @Override
    public void execute() {
        MedicineController controller = new MedicineController();
        controller.setBoundary(boundary);
        Collection<Medicine> allMedicines = controller.getAllMedicines();
        System.out.println(String.format("Found %d medicines", allMedicines.size()));
        allMedicines.forEach(System.out::println);
    }

    @Override
    public String description() {
        return "See All Medicines";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
