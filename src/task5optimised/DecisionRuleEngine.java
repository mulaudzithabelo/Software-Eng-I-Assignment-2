package task5optimised;

import java.util.List;

public interface DecisionRuleEngine {
    Outcome determineOutcome(List<Integer> scores);
}
