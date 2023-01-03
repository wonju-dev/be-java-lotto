package kr.codesquad.domain;

public class PurchaseRecord {
    private Integer money;
    private Integer count;

    public PurchaseRecord(Integer money, Integer count) {
        this.money = money;
        this.count = count;
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getCount() {
        return count;
    }
}
