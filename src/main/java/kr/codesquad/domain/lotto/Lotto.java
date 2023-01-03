package kr.codesquad.domain.lotto;

import kr.codesquad.enums.Accuracy;
import kr.codesquad.domain.RandomNumberGenerator;

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
        Optional<Accuracy> accuracy = Accuracy.findByAttribute(getMatchNumber(answerLotto), answerLotto.hasBonusNumber(numbers));
        if (accuracy.isEmpty()) {
            return Accuracy.NOT_MATCH;
        }
        return accuracy.get();
    }

    private Integer getMatchNumber(Lotto answerLotto) {
        return (int) numbers.stream().filter(number -> answerLotto.numbers.contains(number)).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
