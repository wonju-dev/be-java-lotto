package kr.codesquad.domain;

import kr.codesquad.domain.lotto.AnswerLotto;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.enums.Accuracy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Result {

    private Map<Accuracy, Integer> scoreBoard;
    private Double returnRate;

    private Result() {
        scoreBoard = new LinkedHashMap<>();
    }

    public static Result getNew(List<Lotto> lottos, AnswerLotto answerLotto, PurchaseRecord purchaseRecord) {
        Result result = new Result();

        result.buildScoreBoard(lottos, answerLotto);
        result.calculateReturnRate(purchaseRecord.getUsedMoney());

        return result;
    }

    private void calculateReturnRate(Integer usedMoney) {
        returnRate = (double) (getNetProfit() - usedMoney) / usedMoney * 100;
    }

    private void buildScoreBoard(List<Lotto> lottos, AnswerLotto answerLotto) {
        this.scoreBoard = initScoreBoard();
        for (Lotto lotto : lottos) {
            markAccuracy(lotto.compare(answerLotto));
        }
    }

    private Map<Accuracy, Integer> initScoreBoard() {
        Map<Accuracy, Integer> scoreBoard = new LinkedHashMap<>();

        Accuracy[] values = Accuracy.values();
        for (Accuracy value : values) {
            scoreBoard.put(value, 0);
        }

        return scoreBoard;
    }

    private void markAccuracy(Accuracy accuracy) {
        scoreBoard.put(accuracy, scoreBoard.get(accuracy) + 1);
    }

    private Long getNetProfit() {
        Set<Map.Entry<Accuracy, Integer>> entries = scoreBoard.entrySet();
        return entries.stream()
                .map((Map.Entry<Accuracy, Integer> entry) -> (long) entry.getKey().getPrize() * entry.getValue())
                .reduce(0l, Long::sum);
    }

    public Map<Accuracy, Integer> getScoreBoard() {
        return Map.copyOf(scoreBoard);
    }

    public Double getReturnRate() {
        return returnRate;
    }
}
