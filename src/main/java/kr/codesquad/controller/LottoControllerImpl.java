package kr.codesquad.controller;

import kr.codesquad.console.Input;
import kr.codesquad.console.Output;
import kr.codesquad.domain.MessageGenerator;
import kr.codesquad.domain.Result;
import kr.codesquad.domain.lotto.AnswerLotto;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.dto.PurchaseRecord;
import kr.codesquad.service.LottoService;


import java.util.List;

public class LottoControllerImpl implements LottoController {

    private final Input input;
    private final Output output;
    private final LottoService lottoService;
    private final MessageGenerator messageGenerator;

    public LottoControllerImpl(Input input, Output output, LottoService lottoService, MessageGenerator messageGenerator) {
        this.input = input;
        this.output = output;
        this.lottoService = lottoService;
        this.messageGenerator = messageGenerator;
    }

    @Override
    public void start() {
        PurchaseRecord purchaseRecord = makePurchaseRecord();

        List<Lotto> lottos = makeRandomLottos(purchaseRecord);

        AnswerLotto answerLotto = makeAnswerLotto();

        calculateResult(purchaseRecord, lottos, answerLotto);
    }

    private void calculateResult(PurchaseRecord purchaseRecord, List<Lotto> lottos, AnswerLotto answerLotto) {
        Result results = lottoService.getResult(lottos, answerLotto, purchaseRecord);
        output.print(messageGenerator.getResultMessage(results));
        output.print(messageGenerator.getProfitMessage(results.getReturnRate()));
    }

    private AnswerLotto makeAnswerLotto() {
        output.print(messageGenerator.getAnswerNumberMessage());
        List<Integer> answerNumbers = input.readAnswerNumbers();
        output.print(messageGenerator.getBonusNumberMessage());
        Integer bonusNumber = input.readInteger();
        return lottoService.getAnswerLotto(answerNumbers, bonusNumber);
    }

    private List<Lotto> makeRandomLottos(PurchaseRecord purchaseRecord) {
        List<Lotto> lottos = lottoService.getRandomLottos(purchaseRecord);
        output.print(messageGenerator.getLottoMessage(lottos));
        return lottos;
    }

    private PurchaseRecord makePurchaseRecord() {
        output.print(messageGenerator.getInputMessage());
        Integer money = input.readInteger();
        PurchaseRecord purchaseRecord = lottoService.getPurchaseRecord(money);
        output.print(messageGenerator.getLottoCountMessage(purchaseRecord.getNumberOfLottery()));

        return purchaseRecord;
    }
}
