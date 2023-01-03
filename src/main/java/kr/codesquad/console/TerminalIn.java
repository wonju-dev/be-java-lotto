package kr.codesquad.console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TerminalIn implements Input {

    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    @Override
    public Integer readInteger() {
        return scanner.nextInt();
    }

    @Override
    public List<Integer> readAnswerNumbers() {
        return Arrays.asList(scanner.next().split(",")).stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
