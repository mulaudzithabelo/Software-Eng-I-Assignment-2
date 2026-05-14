package task1baseline;

import java.util.List;

public class SubmissionController {
    private Validator validator;
    private Database database;
    private ReviewerManager reviewerManager;
    private EvaluationManager evaluationManager;

    public SubmissionController(
            Validator validator,
            Database database,
            ReviewerManager reviewerManager,
            EvaluationManager evaluationManager) {

        this.validator = validator;
        this.database = database;
        this.reviewerManager = reviewerManager;
        this.evaluationManager = evaluationManager;
    }

    public void submit(SubmissionData data) {
        System.out.println("SubmissionController -> Validator: validateFormat(data)");

        boolean isValid = validator.validateFormat(data);

        if (!isValid) {
            System.out.println("Validator --> SubmissionController: invalid");
            System.out.println("alt [invalid]");
            System.out.println("SubmissionController -> UI: return error");
            System.out.println("Error: Submission format is invalid.");
            return;
        }

        System.out.println("Validator --> SubmissionController: valid");
        System.out.println("alt [valid]");

        System.out.println("SubmissionController -> Database: saveSubmission(data)");
        database.saveSubmission(data);

        System.out.println("Database --> SubmissionController: confirmation");

        System.out.println("SubmissionController -> ReviewerManager: getAvailableReviewers()");
        List<Reviewer> filteredReviewers = reviewerManager.getAvailableReviewers();

        System.out.println("ReviewerManager --> SubmissionController: filteredReviewers");

        System.out.println("loop [assign reviews]");
        for (Reviewer reviewer : filteredReviewers) {
            System.out.println("SubmissionController -> Reviewer: assignReview()");
            reviewer.assignReview();
        }

        System.out.println("SubmissionController -> EvaluationManager: startEvaluation()");
        evaluationManager.startEvaluation(filteredReviewers);
    }
}