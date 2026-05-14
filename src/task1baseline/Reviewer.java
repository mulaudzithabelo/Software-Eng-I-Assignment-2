package task1baseline;

public class Reviewer {
    private String name;
    private int score;

    public Reviewer(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void assignReview() {
        System.out.println(name + " receives review assignment.");
    }

    public int submitScore() {
        System.out.println("Reviewer -> EvaluationManager: submitScore(score)");
        System.out.println(name + " submits score: " + score);

        return score;
    }
}

