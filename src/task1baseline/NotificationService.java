package task1baseline;

public class NotificationService {
    private String message;

    public void notifyAcceptance() {
        message = "Submission accepted.";
        System.out.println("NotificationService prepares acceptance notification.");
    }

    public void notifyRejection() {
        message = "Submission rejected.";
        System.out.println("NotificationService prepares rejection notification.");
    }

    public void notifyRevision() {
        message = "Submission requires revision.";
        System.out.println("NotificationService prepares revision notification.");
    }

    public void sendNotification() {
        System.out.println("NotificationService sends notification: " + message);
    }
}
