package task5optimised;

public class Researcher {
    private final UI ui;

    public Researcher(UI ui) {
        this.ui = ui;
    }

    public void submitResearchOutput(SubmissionData data) {
        System.out.println("Researcher -> UI: submitResearchOutput(data)");
        ui.submitResearchOutput(data);
    }
}