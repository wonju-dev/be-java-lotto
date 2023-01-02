package kr.codesquad;

import kr.codesquad.controller.LottoControllerImpl;
import kr.codesquad.lottomachine.LottoMachine;
import kr.codesquad.lottomachine.LottoMachineImpl;
import kr.codesquad.service.LottoServiceImpl;

public class Main {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachineImpl(new LottoControllerImpl(), new LottoServiceImpl());
        lottoMachine.start();
    }
}