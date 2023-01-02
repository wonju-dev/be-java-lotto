package kr.codesquad.lottomachine;

import kr.codesquad.controller.LottoController;
import kr.codesquad.service.LottoService;

public class LottoMachineImpl implements LottoMachine {

    private static LottoController lottoController;
    private static LottoService lottoService;

    public LottoMachineImpl(LottoController lottoController, LottoService lottoService) {
        this.lottoController = lottoController;
        this.lottoService = lottoService;
    }


    @Override
    public void start() {

    }
}
