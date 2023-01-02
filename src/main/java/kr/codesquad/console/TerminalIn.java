package kr.codesquad.console;

import java.util.Scanner;

public class TerminalIn implements Input {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public Integer readInteger() {
        return scanner.nextInt();
    }
}
