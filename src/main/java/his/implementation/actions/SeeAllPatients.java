package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.UserController;

import java.util.Collection;

public class SeeAllPatients implements Action {
    private Boundary boundary;

    @Override
    public void setContext() {

    }

    @Override
    public void execute() {
        UserController controller = new UserController();
        controller.setBoundary(boundary);
        Collection allPatients = controller.getAllPatients();
        System.out.println(String.format("Found %d patients", allPatients.size()));
        allPatients.forEach(System.out::println);
    }

    @Override
    public String description() {
        return "See All Patients";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
