package kr.codesquad.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> numbers;

    private static List<Integer> randomNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());

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

    private void init() {
        Collections.shuffle(randomNumbers);
        numbers = List.copyOf(randomNumbers.subList(0, 6));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public Accuracy compare(List<Integer> answerNumbers) {
        return result.get(getNumberOfCommons(answerNumbers));
    }

    private Integer getNumberOfCommons(List<Integer> answerNumbers) {
        int count = 0;
        count += answerNumbers.stream().filter((Integer answerNumber) -> numbers.contains(answerNumber)).count();
        return count;
    }
}
