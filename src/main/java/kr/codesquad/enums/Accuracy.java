package kr.codesquad.enums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

import static kr.codesquad.domain.MessageGenerator.BONUS_MATCH_RESULT_MSG_TEMPLATE;
import static kr.codesquad.domain.MessageGenerator.MATCH_RESULT_MSG_TEMPLATE;

public enum Accuracy {
    NO_MATCH(0, false, 0, MATCH_RESULT_MSG_TEMPLATE),
    THREE(3, false, 5000, MATCH_RESULT_MSG_TEMPLATE),
    FOUR(4, false, 50000, MATCH_RESULT_MSG_TEMPLATE),
    FIVE(5, false, 1500000, MATCH_RESULT_MSG_TEMPLATE),
    FIVE_BONUS(5, true, 30000000, BONUS_MATCH_RESULT_MSG_TEMPLATE),
    SIX(6, false, 2000000000, MATCH_RESULT_MSG_TEMPLATE);

    private Integer match;
    private Boolean needBonus;
    private Integer prize;
    private String resultMessage;

    Accuracy(Integer match, Boolean needBonus, Integer prize, String resultMessage) {
        this.match = match;
        this.needBonus = needBonus;
        this.prize = prize;
        this.resultMessage = resultMessage;
    }

    public static Accuracy findByAttribute(Integer matchNumber, Boolean hasBonusNumber) {
        return Arrays.asList(Accuracy.values()).stream()
                .filter(accuracy -> accuracy.match == matchNumber && (
                        (accuracy.needBonus && hasBonusNumber) || (!accuracy.needBonus && !hasBonusNumber)
                ))
                .findFirst()
                .orElse(Accuracy.NO_MATCH);
    }

    public static Comparator<? super Map.Entry<Accuracy, Integer>> getComparator() {
        return new Comparator<Map.Entry<Accuracy, Integer>>() {
            @Override
            public int compare(Map.Entry<Accuracy, Integer> o1, Map.Entry<Accuracy, Integer> o2) {
                return o1.getKey().getMatch() - o2.getKey().getMatch();
            }
        };
    }

    public Integer getMatch() {
        return match;
    }

    public Integer getPrize() {
        return prize;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
