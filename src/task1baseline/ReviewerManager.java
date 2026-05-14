package task1baseline;

import java.util.List;

public class ReviewerManager {
    private Database database;

    public ReviewerManager(Database database) {
        this.database = database;
    }

    public List<Reviewer> getAvailableReviewers() {
        System.out.println("ReviewerManager -> Database: fetchReviewers()");

        List<Reviewer> reviewerList = database.fetchReviewers();

        System.out.println("Database --> ReviewerManager: reviewerList");

        System.out.println("ReviewerManager -> ReviewerManager: filterConflicts(reviewerList)");
        List<Reviewer> conflictFilteredReviewers = filterConflicts(reviewerList);

        System.out.println("ReviewerManager -> ReviewerManager: checkWorkload(reviewerList)");
        List<Reviewer> workloadFilteredReviewers = checkWorkload(conflictFilteredReviewers);

        return workloadFilteredReviewers;
    }

    public List<Reviewer> filterConflicts(List<Reviewer> reviewerList) {
        System.out.println("ReviewerManager filters conflicts.");

        return reviewerList;
    }

    public List<Reviewer> checkWorkload(List<Reviewer> reviewerList) {
        System.out.println("ReviewerManager checks reviewer workload.");

        return reviewerList;
    }
}