package his.implementation.actions;

import his.Oncologist;
import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.SurgeryController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpecifyTeam implements Action {
    private Boundary boundary;
    private String surgeonId;
    private LocalDateTime dateTime;
    private List<Oncologist> team = new ArrayList<>();

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        surgeonId = getNotBlankLine(sc, "Enter surgeon id: ");
        dateTime = getDate(sc, "Enter surgery date(dd.MM.yyyy HH:mm): ", getFormat());

        while (team.size() < 5) {
            System.out.println(String.format("Team size: %d", team.size()));
            String oncId = getNotBlankLine(sc, "Enter team mate id: ");
            Oncologist oncologist = new Oncologist();
            oncologist.setProfessionalID(oncId);
            team.add(oncologist);
        }
    }

    @Override
    public void execute() {
        SurgeryController controller = new SurgeryController();
        controller.setBoundary(boundary);
        controller.setSurgeonTeam(surgeonId, dateTime, team);
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
