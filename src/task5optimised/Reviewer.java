package task5optimised;

public class Reviewer {
    private final String name;
    private final int score;

    public Reviewer(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void assignReview(String submissionId) {
        System.out.println("ReviewerAssignmentService -> Reviewer: assignReview(submissionId)");
        System.out.println(name + " assigned to review submission " + submissionId);
    }

    public int submitScore(String submissionId) {
        System.out.println("Reviewer -> EvaluationService: submitScore(score)");
        System.out.println(name + " submits score " + score + " for " + submissionId);
        return score;
    }
}