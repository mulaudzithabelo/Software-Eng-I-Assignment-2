package task1baseline;

public class App {
    public static void main(String[] args) {
        Logger.ENABLED = true;
     
      System.out.println();
      System.out.println();
      System.out.println("=================================================");
      System.out.println("BASELINE IMPLEMENTATION: VALID SUBMISSION FLOW");
      System.out.println("=================================================\n");
      System.out.println();
        Database database = new Database();
        Validator validator = new Validator();
        NotificationService notificationService = new NotificationService();
        EvaluationManager evaluationManager = new EvaluationManager(database, notificationService);
        ReviewerManager reviewerManager = new ReviewerManager(database);
        SubmissionController submissionController =
                new SubmissionController(validator, database, reviewerManager, evaluationManager);
        UI ui = new UI(submissionController);
        Researcher researcher = new Researcher(ui);

        SubmissionData validData = new SubmissionData("Research Paper", true);

        researcher.submitResearchOutput(validData);

        System.out.println();
        System.out.println();
        System.out.println("====================================================");
        System.out.println("BASELINE IMPLEMENTATION: INVALID SUBMISSION FLOW");
        System.out.println("====================================================\n");
        

        SubmissionData invalidData = new SubmissionData("Incomplete Research Paper", false);

        researcher.submitResearchOutput(invalidData);
    }
}