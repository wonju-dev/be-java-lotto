package kr.codesquad.domain;

import kr.codesquad.enums.Accuracy;
import kr.codesquad.domain.lotto.Lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageGenerator {

    private static final String LOTTO_COUNT_MSG_TEMPLATE = "개를 구매했습니다.";
    private static final String INPUT_MSG_TEMPLATE = "구입금액을 입력해 주세요.";
    private static final String ANSWER_NUMBER_MSG_TEMPLATE = "당첨 번호를 입력해 주세요.";
    private static final String PROFIT_MSG_TEMPLATE = "총 수익률은 %.2f%%입니다.";
    private static final String BONUS_BALL_REQUIRE_MSG_TEMPLATE = "보너스 볼을 입력해 주세요.";
    public static final String MATCH_RESULT_MSG_TEMPLATE = "%d개 일치 (%d원)-%d개";
    public static final String BONUS_MATCH_RESULT_MSG_TEMPLATE = "%d개 일치, 보너스 볼 일치(%d원)-%d개";
    private static final String NEW_LINE_DELIMITER = "\n";

    public String getLottoCountMessage(Integer count) {
        return count + LOTTO_COUNT_MSG_TEMPLATE;
    }

    public String getInputMessage() {
        return INPUT_MSG_TEMPLATE;
    }

    public String getAnswerNumberMessage() {
        return ANSWER_NUMBER_MSG_TEMPLATE;
    }

    public String getResultMessage(Result results) {
        return String.join(NEW_LINE_DELIMITER, results.getScoreBoard().entrySet().stream().sorted(Accuracy.getComparator())
                .map((Map.Entry<Accuracy, Integer> entry) -> {
                    Accuracy accuracy = entry.getKey();
                    Integer count = entry.getValue();
                    return String.format(accuracy.getResultMessage(), accuracy.getMatch(), accuracy.getPrize(), count);
                })
                .collect(Collectors.toList()));
    }

    public String getLottoMessage(List<Lotto> lottos) {
        return String.join(NEW_LINE_DELIMITER, lottos.stream().map(lotto -> lotto.toString()).collect(Collectors.toList()));
    }

    public String getProfitMessage(Double profit) {
        return String.format(PROFIT_MSG_TEMPLATE, profit);
    }

    public String getBonusNumberMessage() {
        return BONUS_BALL_REQUIRE_MSG_TEMPLATE;
    }
}
