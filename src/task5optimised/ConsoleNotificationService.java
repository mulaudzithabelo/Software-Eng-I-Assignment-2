package task5optimised;

public class ConsoleNotificationService implements NotificationService {

    @Override
    public void notifyResearcher(Outcome outcome) {
        System.out.println("NotificationService prepares notification based on outcome.");

        String message;

        switch (outcome) {
            case ACCEPTED:
                message = "Submission accepted.";
                break;

            case REJECTED:
                message = "Submission rejected.";
                break;

            case REVISION_REQUIRED:
                message = "Submission requires revision.";
                break;

            default:
                message = "Unknown submission outcome.";
        }

        System.out.println("NotificationService -> Researcher: sendNotification(outcome)");
        System.out.println("Notification sent to researcher: " + message);
    }
}