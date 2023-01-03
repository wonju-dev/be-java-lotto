package kr.codesquad.console;

public class TerminalOut implements Output {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
