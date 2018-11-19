/**
 * @(#) Boundary.java
 */

package his.sequence.diagrams;

import com.google.common.collect.Lists;
import his.DateTime;
import his.ImagingTest;
import his.implementation.Roles;
import his.implementation.UserSettings;
import his.implementation.Action;
import his.implementation.actions.AddMedicine;
import his.implementation.actions.AddNewDoctorAction;
import his.implementation.actions.AddTherapy;
import his.implementation.actions.AssignOncologist;
import his.implementation.actions.BookSurgery;
import his.implementation.actions.BookTest;
import his.implementation.actions.CopyAndAddTests;
import his.implementation.actions.CreateUser;
import his.implementation.actions.GetPatientData;
import his.implementation.actions.LoginAction;
import his.implementation.actions.OpenPatientFolder;
import his.implementation.actions.PrescribeVisit;
import his.implementation.actions.PrintResults;
import his.implementation.actions.SeeAllDoctors;
import his.implementation.actions.SeeMedicines;
import his.implementation.actions.SpecifyTeam;
import his.implementation.actions.WriteAnamnesis;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
            List<Action> actions;
            if (settings == null) {
                actions = Lists.newArrayList(
                        new LoginAction(),
                        new CreateUser()
                );
            } else {
                String role = settings.getRole();
                System.out.println(String.format("Active role: %s", role));
                if (Roles.ROLE_ADMIN.equals(role)) {
                    actions = Lists.newArrayList(
                            new AddNewDoctorAction(),
                            new SeeAllDoctors()
                    );
                } else if (Roles.ROLE_ONCOLOGIST.equals(role)) {
                    actions = Lists.newArrayList(
                            new BookTest(),
                            new WriteAnamnesis(),
                            new CopyAndAddTests(),
                            new AddTherapy(),
                            new PrintResults(),
                            new AddMedicine(),
                            new SeeMedicines(),
                            new GetPatientData(),
                            new BookSurgery()
                    );
                } else if (Roles.ROLE_PRIV_DOC.equals(role)) {
                    actions = Lists.newArrayList(
                            new PrescribeVisit(),
                            new BookTest(),
                            new WriteAnamnesis(),
                            new CopyAndAddTests(),
                            new AddTherapy(),
                            new PrintResults(),
                            new AddMedicine(),
                            new SeeMedicines(),
                            new GetPatientData(),
                            new BookSurgery()
                    );
                } else if (Roles.ROLE_RECEPTIONIST.equals(role)) {
                    actions = Lists.newArrayList(
                            new OpenPatientFolder()
                    );
                } else if (Roles.ROLE_SURGEON.equals(role)) {
                    actions = Lists.newArrayList(
                            new SpecifyTeam()
                    );
                } else {
                    throw new RuntimeException(String.format("Unknown role: %s", role));
                }
            }

            System.out.println("List of available actions: ");
            for (int i = 0; i < actions.size(); i++) {
                Action action = actions.get(i);
                System.out.println(String.format("%d. %s", i, action.description()));
                context.put(i, action);
            }

            Integer choice = intOrExit();
            if (choice == null) {
                break;
            }

            Action action = context.get(choice);
            if (action == null) {
                continue;
            }

            action.setContext();
            try {
                action.execute();
            } catch (RuntimeException e) {
                System.out.println(String.format("Action invocation ended with an error: %s", e.getMessage()));
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
