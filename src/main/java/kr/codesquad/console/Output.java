package kr.codesquad.console;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Result;

import java.util.List;

public interface Output {
    void print(String message);

    void printLottos(List<Lotto> lottos);

    void printResult(Result results);
}
