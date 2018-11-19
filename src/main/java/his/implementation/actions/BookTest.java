package his.implementation.actions;

import com.google.common.base.Enums;
import his.TestType;
import his.implementation.Action;
import his.implementation.Tests;
import his.sequence.diagrams.Boundary;
import his.sequence.diagrams.VisitController;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BookTest implements Action {
    private Boundary boundary;
    private String patientId;
    private LocalDateTime date;
    private String testType;

    @Override
    public void setContext() {
        Scanner sc = systemIn();
        patientId = getNotBlankLine(sc, "Enter patient id: ");
        date = getDate(sc, "Enter date(dd.MM.yyyy HH:mm)", getFormat());
        testType = getNotBlankLine(sc, String.format("Enter test type (%s / %s): ", Tests.TEST_BLOOD, Tests.TEST_IMAGING),
                line -> Tests.TEST_BLOOD.equals(line) || Tests.TEST_IMAGING.equals(line));

        if (Tests.TEST_IMAGING.equals(testType)) {
            String subTestType = getNotBlankLine(sc, "Enter sub test type (choices: %s): ", line -> line != null && Enums.getIfPresent(TestType.class, line).isPresent());
            boundary.setSubTestType(TestType.valueOf(subTestType));
        }
    }

    @Override
    public void execute() {
        VisitController visitController = new VisitController();
        visitController.setBoundary(boundary);
        String bookingId = visitController.bookTest(patientId, date, testType);
        System.out.println(String.format("Created test booking with id => %s", bookingId));
    }

    @Override
    public String description() {
        return "Book a Test";
    }

    @Override
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
