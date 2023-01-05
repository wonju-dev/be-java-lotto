package kr.codesquad.domain;

import static kr.codesquad.domain.lotto.Lotto.*;

public class PurchaseRecord {
    private Integer usedMoney;
    private Integer numberOfLottery;

    private PurchaseRecord(Integer money) {
        this.numberOfLottery = money / LOTTO_PRICE;
        this.usedMoney = numberOfLottery * LOTTO_PRICE;
    }

    public static PurchaseRecord getNew(Integer money) {
        return new PurchaseRecord(money);
    }

    public Integer getNumberOfLottery() {
        return numberOfLottery;
    }

    public Integer getUsedMoney() {
        return usedMoney;
    }
}
