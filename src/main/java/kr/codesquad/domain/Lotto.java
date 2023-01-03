package kr.codesquad.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> numbers;
    private static final Integer RANGE_LOWER_BOUND = 1;
    private static final Integer RANGE_UPPER_BOUND = 46;
    private static final Integer COUNT_LOWER_BOUND = 0;
    private static final Integer COUNT_UPPER_BOUND = 6;

    private static List<Integer> randomNumbers = IntStream.range(RANGE_LOWER_BOUND, RANGE_UPPER_BOUND).boxed().collect(Collectors.toList());

    private static final Map<Integer, Accuracy> result = new HashMap<>();

    static {
        Accuracy[] values = Accuracy.values();
        for (Accuracy accuracy : values) {
            result.put(accuracy.getMatch(), accuracy);
        }
    }

    private Lotto() {
    }

    public static Lotto getNewLotto() {
        Lotto lotto = new Lotto();
        lotto.init();
        return lotto;
    }

    public static Lotto getNewLotto(List<Integer> numbers) {
        Lotto lotto = getNewLotto();
        lotto.init(numbers);
        return lotto;
    }

    public Accuracy compare(Lotto answerLotto) {
        return result.get(getNumberOfCommons(answerLotto));
    }

    private Integer getNumberOfCommons(Lotto answerLotto) {
        return (int) numbers.stream()
                .filter(number -> answerLotto.numbers.contains(number))
                .count();
    }

    private void init() {
        Collections.shuffle(randomNumbers);
        numbers = List.copyOf(randomNumbers.subList(COUNT_LOWER_BOUND, COUNT_UPPER_BOUND));
    }

    private void init(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
