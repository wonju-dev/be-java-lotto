package kr.codesquad.domain;

import kr.codesquad.enums.Accuracy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static kr.codesquad.enums.Accuracy.REMOVE_LIST;

public class Result {

    private Map<Accuracy, Integer> scoreBoard;
    private Result() {
        scoreBoard = new LinkedHashMap<>();
    }

    public static Result initResult() {
        Result result = new Result();
        result.init();

        return result;
    }

    private void init() {
        Accuracy[] values = Accuracy.values();
        for (Accuracy value : values) {
            scoreBoard.put(value, 0);
        }
    }

    public void record(Accuracy accuracy) {
        scoreBoard.put(accuracy, scoreBoard.get(accuracy) + 1);
    }

    public void removeUnnecessaryAccuracy() {
        REMOVE_LIST.forEach(accuracy -> scoreBoard.remove(accuracy));
    }

    public Long getNetProfit() {
        Set<Map.Entry<Accuracy, Integer>> entries = scoreBoard.entrySet();
        return entries.stream()
                .map((Map.Entry<Accuracy, Integer> entry) -> (long) entry.getKey().getPrize() * entry.getValue())
                .reduce(0l, Long::sum);
    }

    public Map<Accuracy, Integer> getScoreBoard() {
        return scoreBoard;
    }
}
