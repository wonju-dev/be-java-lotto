package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private List<Lotto> lottos;

    public List<Lotto> getRandomLottos(Integer count) {
        List<Lotto> lottos = new ArrayList<>();
        while (count > 0) {
            lottos.add(Lotto.getNewLotto());
            count--;
        }
        this.lottos = lottos;
        return lottos;
    }

    public Result getResult(Lotto answerLotto) {
        Result result = Result.initResult();

        lottos.stream().forEach(lotto -> result.record(lotto.compare(answerLotto)));

        result.removeUnnecessaryAccuracy();

        return result;
    }
}
