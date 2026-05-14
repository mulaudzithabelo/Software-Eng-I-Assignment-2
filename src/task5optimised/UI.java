package task5optimised;

public class UI {
    private final SubmissionController controller;

    public UI(SubmissionController controller) {
        this.controller = controller;
    }

    public void submitResearchOutput(SubmissionData data) {
        System.out.println("UI -> SubmissionController: submit(data)");
        controller.submit(data);
    }

    public void displayValidationError(String message) {
        System.out.println("SubmissionController -> UI: displayValidationError()");
        System.out.println("UI displays error: " + message);
    }
}
