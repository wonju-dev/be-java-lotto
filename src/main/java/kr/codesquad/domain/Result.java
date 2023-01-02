package kr.codesquad.domain;

import java.util.Map;

public class Result {

    private Map<Accuracy, Integer> scoreBoard;

    private Result() {
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

    public Map<Accuracy, Integer> getScoreBoard() {
        return scoreBoard;
    }
}
