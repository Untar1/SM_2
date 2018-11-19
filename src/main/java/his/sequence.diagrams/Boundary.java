/**
 * @(#) Boundary.java
 */

package his.sequence.diagrams;

import his.DateTime;
import his.ImagingTest;
import his.implementation.Roles;
import his.implementation.UserSettings;
import his.implementation.Action;
import his.implementation.actions.CreateUser;
import his.implementation.actions.LoginAction;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boundary {
    private static UserSettings settings;

    public String getCurrentUserRole() {
        return settings.getRole();
    }

    public void error(String message) {
        throw new RuntimeException(message);
    }

    public Collection getMedicines() {
        return null;
    }

    public ImagingTest getSubTestType() {
        return null;
    }

    public String getPatientName() {
        return null;
    }

    public String getPatientSurname() {
        return null;
    }

    public String getPatientIdCode() {
        return null;
    }

    public String getPatientInsuranceCode() {
        return null;
    }

    public DateTime getCurrentDate() {
        return null;
    }

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("    HOSPITAL INFORMATION SYSTEM ");
        System.out.println("==================================");
        System.out.println("type 'exit' to exit the program");

        while (true) {
            System.out.println("==================================");

            Map<Integer, Action> context = new HashMap<>();
            System.out.println("List of available actions: ");
            if (settings == null) {
                context.put(0, new LoginAction());
                context.put(1, new CreateUser());
            } else {
                String role = settings.getRole();
                if (Roles.ROLE_ADMIN.equals(role)) {

                } else if (Roles.ROLE_ONCOLOGIST.equals(role)) {

                } else if (Roles.ROLE_PRIV_DOC.equals(role)) {

                } else if (Roles.ROLE_RECEPTIONIST.equals(role)) {

                } else if (Roles.ROLE_SURGEON.equals(role)) {

                } else {
                    throw new RuntimeException(String.format("Unknown role: %s", role));
                }
            }

            Integer choice = intOrExit();
            if (choice == null) {
                break;
            }
        }
    }

    private static Integer intOrExit() {
        String line = sc.next();
        try {
            return Integer.parseInt(line);
        } catch (Exception e) {
            System.err.println("Stop it");
            if ("exit".equalsIgnoreCase(line)) {
                return null;
            } else {
                return intOrExit();
            }
        }
    }
}
