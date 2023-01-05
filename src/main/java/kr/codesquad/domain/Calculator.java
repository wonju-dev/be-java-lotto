package kr.codesquad.domain;

public class Calculator {
    public static Double calculateProfit(Result results, Integer usedMoney) {
        return (results.getNetProfit() - usedMoney) * 100 / 100.0 / usedMoney * 100;
    }
}
