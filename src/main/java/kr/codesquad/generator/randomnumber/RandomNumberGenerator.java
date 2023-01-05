package kr.codesquad.generator.randomnumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static kr.codesquad.util.Constants.*;

public class RandomNumberGenerator {

    private static final List<Integer> randomNumbers = IntStream.range(RANGE_LOWER_BOUND, RANGE_UPPER_BOUND).boxed().collect(Collectors.toList());

    public static List<Integer> generate() {
        Collections.shuffle(randomNumbers);
        return List.copyOf(randomNumbers.subList(COUNT_LOWER_BOUND, COUNT_UPPER_BOUND));
    }
}
