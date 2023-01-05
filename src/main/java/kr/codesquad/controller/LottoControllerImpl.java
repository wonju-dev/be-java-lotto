package kr.codesquad.controller;

import kr.codesquad.console.Input;
import kr.codesquad.console.Output;
import kr.codesquad.generator.message.MessageGenerator;
import kr.codesquad.domain.Result;
import kr.codesquad.domain.lotto.AnswerLotto;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.PurchaseRecord;
import kr.codesquad.service.LottoService;

import java.util.ArrayList;
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
        PurchaseRecord purchaseRecord = purchaseLotto();

        List<Lotto> lottos = getLottos(purchaseRecord);

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
        List<Integer> answerNumbers = input.readLottoNumbers();
        output.print(messageGenerator.getBonusNumberMessage());
        Integer bonusNumber = input.readInteger();
        return lottoService.getAnswerLotto(answerNumbers, bonusNumber);
    }

    private List<Lotto> getLottos(PurchaseRecord purchaseRecord) {
        output.print(messageGenerator.getManualLottoNumberMessage());
        List<Lotto> lottos = lottoService.getLottos(purchaseRecord, getManualNumbers(purchaseRecord));
        output.print(messageGenerator.getLottoDetailMessage(purchaseRecord, lottos));
        return lottos;
    }

    private List<List<Integer>> getManualNumbers(PurchaseRecord purchaseRecord) {
        List<List<Integer>> manualNumbers = new ArrayList<>();
        for (int count = 0; count < purchaseRecord.getNumOfManualLotto(); count++) {
            manualNumbers.add(input.readLottoNumbers());
        }
        return manualNumbers;
    }

    private PurchaseRecord purchaseLotto() {
        output.print(messageGenerator.getMoneyMessage());
        Integer money = input.readInteger();
        output.print(messageGenerator.getManualLottoCountMessage());
        Integer numOfManualLotto = input.readInteger();
        PurchaseRecord purchaseRecord = lottoService.getPurchaseRecord(money, numOfManualLotto);
        return purchaseRecord;
    }
}
