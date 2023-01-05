package kr.codesquad.service;

import kr.codesquad.domain.Result;
import kr.codesquad.domain.lotto.AnswerLotto;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.PurchaseRecord;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService {

    @Override
    public PurchaseRecord getPurchaseRecord(Integer money) {
        return PurchaseRecord.getNew(money);
    }

    @Override
    public List<Lotto> getRandomLottos(PurchaseRecord purchaseRecord) {
        List<Lotto> lottos = new ArrayList<>();
        Integer count = purchaseRecord.getNumberOfLottery();

        while (count > 0) {
            lottos.add(new Lotto());
            count--;
        }
        return lottos;
    }

    @Override
    public AnswerLotto getAnswerLotto(List<Integer> answerNumbers, Integer bonusNumber) {
        return new AnswerLotto(answerNumbers, bonusNumber);
    }

    @Override
    public Result getResult(List<Lotto> lottos, AnswerLotto answerLotto, PurchaseRecord purchaseRecord) {
        return Result.getNew(lottos, answerLotto, purchaseRecord);
    }
}
