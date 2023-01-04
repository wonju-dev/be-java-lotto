package kr.codesquad.service;

import kr.codesquad.domain.Result;
import kr.codesquad.domain.lotto.AnswerLotto;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.lottomachine.LottoMachine;
import kr.codesquad.dto.PurchaseRecord;

import java.util.List;

public class LottoServiceImpl implements LottoService {

    private final LottoMachine lottoMachine;

    public LottoServiceImpl(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    @Override
    public PurchaseRecord getPurchaseRecord(Integer money) {
        return PurchaseRecord.getNew(money);
    }

    @Override
    public List<Lotto> getRandomLottos(PurchaseRecord purchaseRecord) {
        return lottoMachine.getRandomLottos(purchaseRecord.getNumberOfLottery());
    }

    @Override
    public AnswerLotto getAnswerLotto(List<Integer> answerNumbers, Integer bonusNumber) {
        return new AnswerLotto(answerNumbers, bonusNumber);
    }

    @Override
    public Result getResult(List<Lotto> lottos, AnswerLotto answerLotto, PurchaseRecord purchaseRecord) {
        return lottoMachine.getResult(lottos, answerLotto, purchaseRecord);
    }
}
