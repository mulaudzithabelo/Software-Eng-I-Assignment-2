package task1baseline;

import java.util.ArrayList;
import java.util.List;

public class EvaluationManager {
    private Database database;
    private NotificationService notificationService;
    private List<Integer> scores;
    private double averageScore;
    private boolean consensusReached;

    public EvaluationManager(Database database, NotificationService notificationService) {
        this.database = database;
        this.notificationService = notificationService;
        this.scores = new ArrayList<>();
    }

    public void startEvaluation(List<Reviewer> reviewers) {
        System.out.println("EvaluationManager starts evaluation.");

        System.out.println("loop [each reviewer]");
        for (Reviewer reviewer : reviewers) {
            int score = reviewer.submitScore();

            System.out.println("EvaluationManager -> Database: saveScore(score)");
            database.saveScore(score);

            scores.add(score);
        }

        System.out.println("EvaluationManager -> EvaluationManager: calculateAverage()");
        calculateAverage();

        System.out.println("EvaluationManager -> EvaluationManager: checkConsensus()");
        checkConsensus();

        System.out.println("EvaluationManager -> EvaluationManager: applyRules()");
        String outcome = applyRules();

        if (outcome.equals("accepted")) {
            System.out.println("alt [accepted]");
            System.out.println("EvaluationManager -> NotificationService: notifyAcceptance()");
            notificationService.notifyAcceptance();
        } else if (outcome.equals("rejected")) {
            System.out.println("alt [rejected]");
            System.out.println("EvaluationManager -> NotificationService: notifyRejection()");
            notificationService.notifyRejection();
        } else {
            System.out.println("alt [revision]");
            System.out.println("EvaluationManager -> NotificationService: notifyRevision()");
            notificationService.notifyRevision();
        }

        System.out.println("NotificationService -> Researcher: sendNotification()");
        notificationService.sendNotification();
    }

    public void calculateAverage() {
        int total = 0;

        for (int score : scores) {
            total += score;
        }

        if (!scores.isEmpty()) {
            averageScore = (double) total / scores.size();
        } else {
            averageScore = 0;
        }

        System.out.println("Average score calculated: " + averageScore);
    }

    public void checkConsensus() {
        consensusReached = true;

        for (int score : scores) {
            if (Math.abs(score - averageScore) > 20) {
                consensusReached = false;
                break;
            }
        }

        System.out.println("Consensus checked: " + consensusReached);
    }

    public String applyRules() {
        System.out.println("Evaluation rules applied.");

        if (averageScore >= 75 && consensusReached) {
            return "accepted";
        } else if (averageScore < 50) {
            return "rejected";
        } else {
            return "revision";
        }
    }
}
