package task5optimised;

public class FormatSubmissionValidator implements SubmissionValidator {

    @Override
    public boolean validate(SubmissionData data) {
        System.out.println("SubmissionValidator validates submission format.");
        return data.isValidFormat();
    }
}