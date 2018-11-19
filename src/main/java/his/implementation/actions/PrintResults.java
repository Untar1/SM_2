package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;

public class PrintResults implements Action {
    private Boundary boundary;

    @Override
    public void setContext() {

    }

    @Override
    public void execute() {

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
