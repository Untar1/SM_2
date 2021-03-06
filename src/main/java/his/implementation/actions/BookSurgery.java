package his.implementation.actions;

import his.Surgeon;
import his.implementation.Action;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.SurgeryController;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BookSurgery implements Action {
    private Boundary boundary;

    private String patientId;
    private LocalDateTime start;
    private String surgeonId;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        patientId = getNotBlankLine(sc, "Enter patient id: ");
        start = getDate(sc, "Enter date (dd.MM.yyyy HH:mm)", getFormat());
        surgeonId = getNotBlankLine(sc, "Enter surgeon professional ID");
    }

    @Override
    public void execute() {
        Surgeon surgeon = new Surgeon();
        surgeon.setProfessionalID(surgeonId);

        SurgeryController controller = new SurgeryController();
        controller.setBoundary(boundary);
        String surgery = controller.bookSurgery(patientId, start, surgeon);
        System.out.println(String.format("Booked a surgery with id => %s", surgery));
    }

    @Override
    public String description() {
        return "Book a Surgery";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
