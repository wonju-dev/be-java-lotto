package kr.codesquad.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator {
    private static final Integer RANGE_LOWER_BOUND = 1;
    private static final Integer RANGE_UPPER_BOUND = 46;

    private static final Integer COUNT_LOWER_BOUND = 0;
    private static final Integer COUNT_UPPER_BOUND = 6;

    private static final List<Integer> randomNumbers = IntStream.range(RANGE_LOWER_BOUND, RANGE_UPPER_BOUND).boxed().collect(Collectors.toList());

    public static List<Integer> generate() {
        Collections.shuffle(randomNumbers);
        return List.copyOf(randomNumbers.subList(COUNT_LOWER_BOUND, COUNT_UPPER_BOUND));
    }
}
