package kr.codesquad.domain;

public enum Accuracy {
    SIX(6, 2000000000),
    FIVE(5, 1500000),
    FOUR(4, 50000),
    THREE(3, 5000),
    TWO(2, -1),
    ONE(1, -1),
    ZERO(0, -1);
    private Integer match;
    private Integer prize;

    Accuracy(Integer match, Integer prize) {
        this.match = match;
        this.prize = prize;
    }

    public Integer getMatch() {
        return this.match;
    }

    public Integer getPrize() {
        return this.prize;
    }
}
