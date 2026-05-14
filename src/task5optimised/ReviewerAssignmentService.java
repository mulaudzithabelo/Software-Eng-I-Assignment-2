package task5optimised;

import java.util.List;

public interface ReviewerAssignmentService {
    List<Reviewer> assignReviewers(String submissionId);
}