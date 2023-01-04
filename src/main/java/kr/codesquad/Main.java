package kr.codesquad;

import kr.codesquad.console.Input;
import kr.codesquad.console.Output;
import kr.codesquad.console.TerminalIn;
import kr.codesquad.console.TerminalOut;
import kr.codesquad.controller.LottoController;
import kr.codesquad.controller.LottoControllerImpl;
import kr.codesquad.domain.MessageGenerator;
import kr.codesquad.service.LottoService;
import kr.codesquad.service.LottoServiceImpl;

public class Main {
    public static void main(String[] args) {
        lottoController().start();
    }

    private static LottoController lottoController() {
        return new LottoControllerImpl(input(), output(), lottoService(), messageGenerator());
    }


    private static Input input() {
        return new TerminalIn();
    }

    private static Output output() {
        return new TerminalOut();
    }

    private static LottoService lottoService() {
        return new LottoServiceImpl();
    }

    private static MessageGenerator messageGenerator() {
        return new MessageGenerator();
    }

}