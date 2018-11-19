package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;

public class GetPatientData implements Action {
    private Boundary boundary;

    @Override
    public void setContext() {

    }

    @Override
    public void execute() {

    }

    @Override
    public String description() {
        return "Retrieve All Information From the Patient Folder";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
