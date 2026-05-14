package task5optimised;

import java.util.List;

public class TableDecisionRuleEngine implements DecisionRuleEngine {

    @Override
    public Outcome determineOutcome(List<Integer> scores) {
        double average = calculateAverage(scores);
        boolean consensusReached = checkConsensus(scores, average);

        System.out.println("DecisionRuleEngine calculates average score: " + average);
        System.out.println("DecisionRuleEngine checks consensus: " + consensusReached);
        System.out.println("DecisionRuleEngine applies centralized decision table rules.");

        if (average >= 75 && consensusReached) {
            return Outcome.ACCEPTED;
        }

        if (average < 50) {
            return Outcome.REJECTED;
        }

        return Outcome.REVISION_REQUIRED;
    }

    private double calculateAverage(List<Integer> scores) {
        if (scores.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (int score : scores) {
            total += score;
        }

        return (double) total / scores.size();
    }

    private boolean checkConsensus(List<Integer> scores, double average) {
        for (int score : scores) {
            if (Math.abs(score - average) > 20) {
                return false;
            }
        }

        return true;
    }
}