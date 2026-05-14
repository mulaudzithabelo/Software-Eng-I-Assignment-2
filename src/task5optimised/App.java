package task5optimised;

public class App {
    public static void main(String[] args) {
        Logger.ENABLED = true;

        System.out.println();
        System.out.println();
        System.out.println("====================================================");
        System.out.println("OPTIMISED IMPLEMENTATION: VALID SUBMISSION FLOW");
        System.out.println("====================================================\n");
        System.out.println();
        SubmissionValidator validator = new FormatSubmissionValidator();
        SubmissionRepository submissionRepository = new InMemorySubmissionRepository();
        ReviewRepository reviewRepository = new InMemoryReviewRepository();
        ReviewerAssignmentService reviewerAssignmentService = new DefaultReviewerAssignmentService();
        DecisionRuleEngine decisionRuleEngine = new TableDecisionRuleEngine();
        NotificationService notificationService = new ConsoleNotificationService();

        EvaluationService evaluationService =
                new EvaluationService(reviewRepository, decisionRuleEngine);

        SubmissionController controller =
                new SubmissionController(
                        validator,
                        submissionRepository,
                        reviewerAssignmentService,
                        evaluationService,
                        notificationService
                );

        UI ui = new UI(controller);
        Researcher researcher = new Researcher(ui);

        SubmissionData validSubmission = new SubmissionData("Research Paper", true);
        researcher.submitResearchOutput(validSubmission);


        System.out.println();
        System.out.println();
        System.out.println("====================================================");
        System.out.println("OPTIMISED IMPLEMENTATION: INVALID SUBMISSION FLOW");
        System.out.println("====================================================\n");
        SubmissionData invalidSubmission = new SubmissionData("Incomplete Research Paper", false);
        researcher.submitResearchOutput(invalidSubmission);
    }
}