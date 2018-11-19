package his.implementation.actions;

import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.UserController;

import java.util.Scanner;

public class CreateUser implements Action {
    private Boundary boundary;

    private Scanner sc = systemIn();

    private String username;
    private String password;
    private String role;

    @Override
    public void setContext() {
        username = getNotBlankLine(sc, "Enter username: ");
        password = getNotBlankLine(sc, "Enter password: ");
        role = getNotBlankLine(sc, "Enter role: ");
    }

    @Override
    public void execute() {
        boolean result = new UserController().registerUser(username, password, role);
        System.out.println(String.format("User created successfully: %b", result));
    }

    @Override
    public String description() {
        return "Register to the system";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
