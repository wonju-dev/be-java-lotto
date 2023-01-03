package kr.codesquad.domain;

import static kr.codesquad.domain.Lotto.*;

public class PurchaseRecord {
    private Integer usedMoney;
    private Integer count;

    private PurchaseRecord(Integer money) {
        this.count = money / LOTTO_PRICE;
        this.usedMoney = money - count * LOTTO_PRICE;
    }

    public static PurchaseRecord getNew(Integer money) {
        return new PurchaseRecord(money);
    }

    public Integer getCount() {
        return count;
    }

    public Integer getUsedMoney() {
        return usedMoney;
    }
}
