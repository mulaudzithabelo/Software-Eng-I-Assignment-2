package task1baseline;

public class Researcher {
    private UI ui;

    public Researcher(UI ui) {
        this.ui = ui;
    }

    public void submitResearchOutput(SubmissionData data) {
        System.out.println("Researcher -> UI: submitResearchOutput(data)");
        ui.submitResearchOutput(data);
    }

    public void receiveNotification(String message) {
        System.out.println("Researcher receives notification: " + message);
    }
}
