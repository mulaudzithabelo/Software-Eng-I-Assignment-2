package task5optimised;

public class InMemorySubmissionRepository implements SubmissionRepository {
    private int counter = 1;

    @Override
    public String save(SubmissionData data) {
        String submissionId = "SUB-" + counter++;
        System.out.println("SubmissionRepository saves submission: " + data.getTitle());
        System.out.println("Generated submission ID: " + submissionId);
        return submissionId;
    }
}