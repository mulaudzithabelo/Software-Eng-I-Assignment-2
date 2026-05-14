package task5optimised;

public class BenchmarkApp {
    public static void main(String[] args) {

        // Disable interaction-flow printing during benchmarking
        Logger.ENABLED = false;

        SubmissionValidator validator =
                new FormatSubmissionValidator();

        SubmissionRepository submissionRepository =
                new InMemorySubmissionRepository();

        ReviewRepository reviewRepository =
                new InMemoryReviewRepository();

        ReviewerAssignmentService reviewerAssignmentService =
                new DefaultReviewerAssignmentService();

        DecisionRuleEngine decisionRuleEngine =
                new TableDecisionRuleEngine();

        NotificationService notificationService =
                new ConsoleNotificationService();

        EvaluationService evaluationService =
                new EvaluationService(
                        reviewRepository,
                        decisionRuleEngine
                );

        SubmissionController submissionController =
                new SubmissionController(
                        validator,
                        submissionRepository,
                        reviewerAssignmentService,
                        evaluationService,
                        notificationService
                );

        UI ui = new UI(submissionController);
        Researcher researcher = new Researcher(ui);

        SubmissionData validSubmission =
                new SubmissionData("Research Paper", true);

        int runs = 10000;

        long startTime = System.nanoTime();

        for (int i = 0; i < runs; i++) {
            researcher.submitResearchOutput(validSubmission);
        }

        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        double milliseconds = duration / 1_000_000.0;
        System.out.println();
        System.out.println("====================================================");
        System.out.println("OPTIMISED BENCHMARK RESULTS");
        System.out.println("====================================================\n");
        System.out.println();
        System.out.println("Number of runs: " + runs);
        System.out.println("Total execution time: " + milliseconds + " ms");
        System.out.println("Average time per run: " + (milliseconds / runs) + " ms");
    }
}