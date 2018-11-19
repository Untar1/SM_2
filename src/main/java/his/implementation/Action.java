package his.implementation;

import his.sequence.diagrams.Boundary;

public interface Action {

    void setContext();

    void execute();

    String description();
}
