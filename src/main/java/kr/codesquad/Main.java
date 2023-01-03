package kr.codesquad;

import kr.codesquad.console.Input;
import kr.codesquad.console.Output;
import kr.codesquad.console.TerminalIn;
import kr.codesquad.console.TerminalOut;
import kr.codesquad.controller.LottoController;
import kr.codesquad.controller.LottoControllerImpl;
import kr.codesquad.domain.LottoMachine;
import kr.codesquad.message.MessageGenerator;

public class Main {
    public static void main(String[] args) {
        lottoController().start();
    }

    private static LottoController lottoController() {
        return new LottoControllerImpl(lottomachine(), input(), output(), messageGenerator());
    }

    private static LottoMachine lottomachine() {
        return new LottoMachine();
    }

    private static Input input() {
        return new TerminalIn();
    }

    private static Output output() {
        return new TerminalOut();
    }

    private static MessageGenerator messageGenerator() {
        return new MessageGenerator();
    }

}