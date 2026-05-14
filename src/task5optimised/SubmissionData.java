package task5optimised;

public class SubmissionData {
    private final String title;
    private final boolean validFormat;

    public SubmissionData(String title, boolean validFormat) {
        this.title = title;
        this.validFormat = validFormat;
    }

    public String getTitle() {
        return title;
    }

    public boolean isValidFormat() {
        return validFormat;
    }
}