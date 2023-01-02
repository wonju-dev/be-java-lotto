package kr.codesquad.controller;

import kr.codesquad.console.Input;
import kr.codesquad.console.Output;

public class LottoControllerImpl implements LottoController {

    private static Input consoleIn;
    private static Output consoleOut;


    public LottoControllerImpl(Input consoleIn, Output consoleOut) {
        this.consoleIn = consoleIn;
        this.consoleOut = consoleOut;
    }

    @Override
    public Integer getPurchasePrice() {
        return consoleIn.readInteger();
    }
}
