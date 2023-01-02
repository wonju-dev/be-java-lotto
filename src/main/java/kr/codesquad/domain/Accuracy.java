package kr.codesquad.domain;

public enum Accuracy {
    SIX_MATCH(6, 5000),
    FIVE_MATCH(5, 50000),
    FOUR_MATCH(4, 1500000),
    THREE_MATCH(3, 2000000000);
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
        return prize;
    }
}
