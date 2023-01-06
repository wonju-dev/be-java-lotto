package kr.codesquad.service;

import kr.codesquad.domain.Result;
import kr.codesquad.domain.lotto.AnswerLotto;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.PurchaseRecord;

import java.util.List;

public interface LottoService {
    PurchaseRecord getPurchaseRecord(Integer money, Integer manualLottoCount);

    List<Lotto> getLottos(PurchaseRecord purchaseRecord, List<List<Integer>> manualNumbers);

    AnswerLotto getAnswerLotto(List<Integer> answerNumbers, Integer bonusNumber);

    Result getResult(List<Lotto> lottos, AnswerLotto answerLotto, PurchaseRecord purchaseRecord);
}
