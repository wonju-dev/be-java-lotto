package kr.codesquad;

import kr.codesquad.controller.LottoController;
import kr.codesquad.controller.LottoControllerImpl;
import kr.codesquad.lottomachine.LottoMachine;
import kr.codesquad.lottomachine.LottoMachineImpl;
import kr.codesquad.service.LottoService;
import kr.codesquad.service.LottoServiceImpl;

public class Main {
    public static void main(String[] args) {
        lottomachine().start();
    }

    private static LottoMachine lottomachine() {
        return new LottoMachineImpl(lottoController(), lottoService());
    }

    private static LottoService lottoService() {
        return new LottoServiceImpl();
    }

    private static LottoController lottoController() {
        return new LottoControllerImpl();
    }
}