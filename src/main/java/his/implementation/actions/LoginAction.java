package his.implementation.actions;

import com.google.common.base.Strings;
import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.UserController;
import his.sequence.diagrams.UserDAO;

import java.util.Scanner;

public class LoginAction implements Action {
    private Scanner sc = new Scanner(System.in);

    private String username;
    private String password;

    @Override
    public void setContext() {
        username = getNotBlankLine();
        password = getNotBlankLine();
    }

    @Override
    public void execute() {
        boolean success = new UserController().login(username, password);
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

    private String getNotBlankLine() {
        while (true) {
            String line = sc.next();
            if (!Strings.isNullOrEmpty(line)) {
                return line;
            }
        }
    }
}
