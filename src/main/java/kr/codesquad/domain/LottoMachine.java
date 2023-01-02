package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private List<Lotto> lottos;

    public List<Lotto> getRandomLottos(Integer price) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < price; i++) {
            lottos.add(Lotto.getNewLotto());
        }
        this.lottos = lottos;
        return lottos;
    }

    public Result getResult(List<Integer> answerNumbers) {
        Result result = Result.initResult();

        for (Lotto lotto : lottos) {
            Accuracy accuracy = lotto.compare(answerNumbers);
            result.record(accuracy);
        }

        return result;
    }
}
