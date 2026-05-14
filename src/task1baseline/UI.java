package task1baseline;

public class UI {
    private SubmissionController submissionController;

    public UI(SubmissionController submissionController) {
        this.submissionController = submissionController;
    }

    public void submitResearchOutput(SubmissionData data) {
        System.out.println("UI -> SubmissionController: submit(data)");
        submissionController.submit(data);
    }

    public void returnError(String message) {
        System.out.println("SubmissionController -> UI: return error");
        System.out.println("UI displays error: " + message);
    }
}