package kr.codesquad.domain;

import static kr.codesquad.domain.lotto.Lotto.*;

public class PurchaseRecord {
    private Integer numOfLotto;
    private Integer numOfManualLotto;
    private Integer usedMoney;

    private PurchaseRecord(Integer money, Integer numOfManualLotto) {
        this.numOfLotto = money / LOTTO_PRICE;
        this.numOfManualLotto = numOfManualLotto;
        this.usedMoney = numOfLotto * LOTTO_PRICE;
    }

    public static PurchaseRecord getNew(Integer money, Integer numOfManualLotto) {
        return new PurchaseRecord(money, numOfManualLotto);
    }

    public Integer getNumOfLotto() {
        return numOfLotto;
    }

    public Integer getNumOfManualLotto() {
        return numOfManualLotto;
    }

    public Integer getUsedMoney() {
        return usedMoney;
    }
}
