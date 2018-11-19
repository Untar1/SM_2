package his.implementation.actions;

import com.google.common.base.Strings;
import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.UserController;
import his.sequence.diagrams.UserDAO;

import java.util.Scanner;

public class LoginAction implements Action {
    private Boundary boundary;
    private Scanner sc = systemIn();

    private String username;
    private String password;

    @Override
    public void setContext() {
        username = getNotBlankLine(sc, "Enter username: ");
        password = getNotBlankLine(sc,  "Enter password: ");
    }

    @Override
    public void execute() {
        UserController controller = new UserController();
        controller.setBoundary(boundary);
        boolean success = controller.login(username, password);
        if (!success) {
            return;
        }

        String role = UserDAO.getUserRole(username);
        Boundary.getSettings().setRole(role);
    }

    @Override
    public String description() {
        return "Login to the System";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
