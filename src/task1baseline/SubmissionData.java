package task1baseline;

public class SubmissionData {
    private String title;
    private boolean validFormat;

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