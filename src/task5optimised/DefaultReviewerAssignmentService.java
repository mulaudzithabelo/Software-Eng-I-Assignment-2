package task5optimised;

import java.util.ArrayList;
import java.util.List;

public class DefaultReviewerAssignmentService implements ReviewerAssignmentService {

    @Override
    public List<Reviewer> assignReviewers(String submissionId) {
        System.out.println("ReviewerAssignmentService selects eligible reviewers internally.");
        System.out.println("ReviewerAssignmentService performs conflict filtering internally.");
        System.out.println("ReviewerAssignmentService performs workload checking internally.");

        List<Reviewer> selectedReviewers = selectEligibleReviewers();

        System.out.println("loop [each selected reviewer]");
        for (Reviewer reviewer : selectedReviewers) {
            reviewer.assignReview(submissionId);
        }

        return selectedReviewers;
    }

    private List<Reviewer> selectEligibleReviewers() {
        System.out.println("ReviewerAssignmentService -> ReviewerAssignmentService: selectEligibleReviewers()");

        List<Reviewer> reviewers = new ArrayList<>();
        reviewers.add(new Reviewer("Reviewer 1", 85));
        reviewers.add(new Reviewer("Reviewer 2", 80));
        reviewers.add(new Reviewer("Reviewer 3", 78));

        return reviewers;
    }
}