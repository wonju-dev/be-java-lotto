package kr.codesquad.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Accuracy {

    SIX(6, false, 2000000000, "%d개 일치 (%d원)-%d개"),
    FIVE_BONUS(5, true, 30000000, "%d개 일치, 보너스 볼 일치(%d원)-%d개"),
    FIVE(5, false, 1500000, "%d개 일치 (%d원)-%d개"),
    FOUR(4, false, 50000, "%d개 일치 (%d원)-%d개"),
    THREE(3, false, 5000, "%d개 일치 (%d원)-%d개"),
    TWO(2, false, -1, "%d개 일치 (%d원)-%d개"),
    ONE(1, false, -1, "%d개 일치 (%d원)-%d개"),
    ZERO(0, false, -1, "%d개 일치 (%d원)-%d개");

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

    public static Optional<Accuracy> getByMatchNumber(Integer numberOfCommons) {
        return Arrays.asList(Accuracy.values()).stream()
                .filter(accuracy -> accuracy.getMatch() == numberOfCommons)
                .findFirst();
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
