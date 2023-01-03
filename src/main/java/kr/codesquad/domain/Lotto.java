package kr.codesquad.domain;

import java.util.*;

public class Lotto {

    private List<Integer> numbers;
    public static final Integer LOTTO_PRICE = 1000;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = RandomNumberGenerator.generate();
    }

    public Accuracy compare(Lotto answerLotto) {
        return Accuracy.getByMatchNumber(getNumberOfCommons(answerLotto)).get();
    }

    private Integer getNumberOfCommons(Lotto answerLotto) {
        return (int) numbers.stream()
                .filter(number -> answerLotto.numbers.contains(number))
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
