package kr.codesquad.domain.lottomachine;

import kr.codesquad.domain.lotto.AnswerLotto;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.Result;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> getRandomLottos(Integer count) {
        List<Lotto> lottos = new ArrayList<>();
        while (count > 0) {
            lottos.add(new Lotto());
            count--;
        }
        return lottos;
    }

    public Result getResult(List<Lotto> lottos, AnswerLotto answerLotto) {
        Result result = Result.initResult();

        lottos.stream().forEach(lotto -> result.record(lotto.compare(answerLotto)));

        result.removeUnnecessaryAccuracy();

        return result;
    }
}
