package task5optimised;

import java.util.ArrayList;
import java.util.List;

public class EvaluationService {
    private final ReviewRepository reviewRepository;
    private final DecisionRuleEngine decisionRuleEngine;

    public EvaluationService(
            ReviewRepository reviewRepository,
            DecisionRuleEngine decisionRuleEngine) {

        this.reviewRepository = reviewRepository;
        this.decisionRuleEngine = decisionRuleEngine;
    }

    public Outcome evaluateSubmission(String submissionId, List<Reviewer> reviewers) {
        List<Integer> scores = new ArrayList<>();

        System.out.println("loop [each reviewer]");
        for (Reviewer reviewer : reviewers) {
            System.out.println("EvaluationService -> Reviewer: requestScore(submissionId)");
            int score = reviewer.submitScore(submissionId);

            System.out.println("EvaluationService -> ReviewRepository: saveScore(submissionId, score)");
            reviewRepository.saveScore(submissionId, score);

            scores.add(score);
        }

        System.out.println("EvaluationService -> DecisionRuleEngine: determineOutcome(scores)");
        Outcome outcome = decisionRuleEngine.determineOutcome(scores);

        System.out.println("DecisionRuleEngine --> EvaluationService: " + outcome);

        return outcome;
    }
}