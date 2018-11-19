package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;

public class SpecifyTeam implements Action {
    private Boundary boundary;

    @Override
    public void setContext() {

    }

    @Override
    public void execute() {

    }

    @Override
    public String description() {
        return "Specify the Team";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
