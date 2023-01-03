package kr.codesquad.controller;

import kr.codesquad.console.Input;
import kr.codesquad.console.Output;
import kr.codesquad.domain.*;
import kr.codesquad.domain.lotto.AnswerLotto;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.lottomachine.LottoMachine;
import kr.codesquad.message.MessageGenerator;

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
        PurchaseRecord purchaseRecord = getPurchaseRecord();
        List<Lotto> lottos = lottoMachine.getRandomLottos(purchaseRecord.getCount());
        output.print(messageGenerator.getLottoMessage(lottos));

        AnswerLotto answerLotto = getAnswerLotto();
        Result results = lottoMachine.getResult(lottos, answerLotto);

        printResultMessage(results, purchaseRecord);
    }

    private void printResultMessage(Result results, PurchaseRecord purchaseRecord) {
        output.print(messageGenerator.getResultMessage(results));
        output.print(messageGenerator.getProfitMessage(Calculator.calculateProfit(results, purchaseRecord.getUsedMoney())));
    }

    private AnswerLotto getAnswerLotto() {
        output.print(messageGenerator.getAnswerNumberMessage());
        List<Integer> answerNumbers = input.readAnswerNumbers();
        output.print(messageGenerator.getBonusNumberMessage());
        Integer bonusNumber = input.readInteger();
        return new AnswerLotto(answerNumbers, bonusNumber);
    }

    private PurchaseRecord getPurchaseRecord() {
        output.print(messageGenerator.getInputMessage());
        Integer money = input.readInteger();
        PurchaseRecord purchaseRecord = PurchaseRecord.getNew(money);
        output.print(messageGenerator.getLottoCountMessage(purchaseRecord.getCount()));
        return purchaseRecord;
    }
}
