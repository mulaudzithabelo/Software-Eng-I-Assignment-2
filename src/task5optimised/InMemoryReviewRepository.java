package task5optimised;

public class InMemoryReviewRepository implements ReviewRepository {

    @Override
    public void saveScore(String submissionId, int score) {
        System.out.println("ReviewRepository saves score " + score + " for " + submissionId);
    }
}