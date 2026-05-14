package task1baseline;

public class BenchmarkApp {
    public static void main(String[] args) {

        // Disable interaction-flow printing during benchmarking
        Logger.ENABLED = false;

        Database database = new Database();
        Validator validator = new Validator();
        NotificationService notificationService = new NotificationService();

        EvaluationManager evaluationManager =
                new EvaluationManager(database, notificationService);

        ReviewerManager reviewerManager =
                new ReviewerManager(database);

        SubmissionController submissionController =
                new SubmissionController(
                        validator,
                        database,
                        reviewerManager,
                        evaluationManager
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
        System.out.println("BASELINE BENCHMARK RESULTS");
        System.out.println("====================================================\n");
        System.out.println();
        System.out.println("Number of runs: " + runs);
        System.out.println("Total execution time: " + milliseconds + " ms");
        System.out.println("Average time per run: " + (milliseconds / runs) + " ms");
    }
}