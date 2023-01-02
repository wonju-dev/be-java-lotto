package kr.codesquad.console;

import kr.codesquad.domain.Accuracy;
import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Result;

import java.util.List;
import java.util.Map;

public class TerminalOut implements Output {
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printResult(Result results) {
        Map<Accuracy, Integer> scoreBoard = results.getScoreBoard();
        for (Accuracy accuracy : scoreBoard.keySet()) {
            System.out.println(accuracy.getMatch() + "개 일치 (" + accuracy.getPrize() + "원)-" + scoreBoard.get(accuracy) + "개");
        }
    }
}
