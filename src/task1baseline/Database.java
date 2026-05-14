package task1baseline;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public void saveSubmission(SubmissionData data) {
        System.out.println("Database saves submission: " + data.getTitle());
    }

    public List<Reviewer> fetchReviewers() {
        System.out.println("Database fetches reviewer list.");

        List<Reviewer> reviewerList = new ArrayList<>();
        reviewerList.add(new Reviewer("Reviewer 1", 85));
        reviewerList.add(new Reviewer("Reviewer 2", 80));
        reviewerList.add(new Reviewer("Reviewer 3", 78));

        return reviewerList;
    }

    public void saveScore(int score) {
        System.out.println("Database saves score: " + score);
    }
}

