package kr.codesquad.domain.lotto;

import kr.codesquad.enums.Accuracy;
import kr.codesquad.generator.randomnumber.RandomNumberGenerator;

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

    public Accuracy compare(AnswerLotto answerLotto) {
        return Accuracy.findByAttribute(getMatchNumber(answerLotto), answerLotto.hasBonusNumber(numbers));
    }

    private Integer getMatchNumber(Lotto answerLotto) {
        return (int) numbers.stream().filter(number -> answerLotto.numbers.contains(number)).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
