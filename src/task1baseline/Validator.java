package task1baseline;

public class Validator {

    public boolean validateFormat(SubmissionData data) {
        System.out.println("Validator validates the submission format.");

        return data.isValidFormat();
    }
}