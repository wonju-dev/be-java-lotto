package kr.codesquad.controller;

import kr.codesquad.console.Input;
import kr.codesquad.console.Output;
import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.LottoMachine;
import kr.codesquad.domain.Result;
import kr.codesquad.messageGenerator.MessageGenerator;

import java.util.List;

public class LottoControllerImpl implements LottoController {

    private static LottoMachine lottoMachine;
    private static Input input;
    private static Output output;
    private static MessageGenerator messageGenerator;

    public LottoControllerImpl(LottoMachine lottoMachine, Input input, Output output, MessageGenerator messageGenerator) {
        this.lottoMachine = lottoMachine;
        this.input = input;
        this.output = output;
        this.messageGenerator = messageGenerator;
    }

    @Override
    public void start() {
        Integer lottoCount = getLottoCount();
        List<Lotto> lottos = lottoMachine.getRandomLottos(lottoCount);
        output.printLottos(lottos);
        List<Integer> answerNumbers = input.getAnswerNumbers();
        Result results = lottoMachine.getResult(answerNumbers);
        output.printResult(results);
    }

    private Integer getLottoCount() {
        output.print(messageGenerator.getInputMessage());
        Integer count = input.readInteger() / 1000;
        output.print(messageGenerator.getLottoCountMessage(count));
        return count;
    }

}
