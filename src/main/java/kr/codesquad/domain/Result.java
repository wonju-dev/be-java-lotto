package kr.codesquad.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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
        scoreBoard.remove(Accuracy.ZERO);
        scoreBoard.remove(Accuracy.ONE);
        scoreBoard.remove(Accuracy.TWO);
    }

    public Integer getNetProfit() {
        Set<Map.Entry<Accuracy, Integer>> entries = scoreBoard.entrySet();
        return entries.stream()
                .map((Map.Entry<Accuracy, Integer> score) -> score.getKey().getPrize() * score.getValue())
                .reduce(0, Integer::sum);
    }

    public Map<Accuracy, Integer> getScoreBoard() {
        return scoreBoard;
    }
}
