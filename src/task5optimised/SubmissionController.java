package task5optimised;

import java.util.List;

public class SubmissionController {
    private final SubmissionValidator validator;
    private final SubmissionRepository submissionRepository;
    private final ReviewerAssignmentService reviewerAssignmentService;
    private final EvaluationService evaluationService;
    private final NotificationService notificationService;

    public SubmissionController(
            SubmissionValidator validator,
            SubmissionRepository submissionRepository,
            ReviewerAssignmentService reviewerAssignmentService,
            EvaluationService evaluationService,
            NotificationService notificationService) {

        this.validator = validator;
        this.submissionRepository = submissionRepository;
        this.reviewerAssignmentService = reviewerAssignmentService;
        this.evaluationService = evaluationService;
        this.notificationService = notificationService;
    }

    public void submit(SubmissionData data) {
        System.out.println("SubmissionController -> SubmissionValidator: validate(data)");

        boolean valid = validator.validate(data);

        if (!valid) {
            System.out.println("SubmissionValidator --> SubmissionController: invalid");
            System.out.println("alt [invalid submission]");
            displayValidationError("Submission format is invalid.");
            return;
        }

        System.out.println("SubmissionValidator --> SubmissionController: valid");
        System.out.println("alt [valid submission]");

        System.out.println("SubmissionController -> SubmissionRepository: save(data)");
        String submissionId = submissionRepository.save(data);

        System.out.println("SubmissionRepository --> SubmissionController: submissionId");

        System.out.println("SubmissionController -> ReviewerAssignmentService: assignReviewers(submissionId)");
        List<Reviewer> assignedReviewers = reviewerAssignmentService.assignReviewers(submissionId);

        System.out.println("ReviewerAssignmentService --> SubmissionController: assignedReviewers");

        System.out.println("SubmissionController -> EvaluationService: evaluateSubmission(submissionId, assignedReviewers)");
        Outcome outcome = evaluationService.evaluateSubmission(submissionId, assignedReviewers);

        System.out.println("EvaluationService --> SubmissionController: outcome");

        System.out.println("SubmissionController -> NotificationService: notifyResearcher(outcome)");
        notificationService.notifyResearcher(outcome);
    }

    private void displayValidationError(String message) {
        System.out.println("SubmissionController handles invalid submission.");
        System.out.println("Error: " + message);
    }
}