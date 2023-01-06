package kr.codesquad.generator.message;

import kr.codesquad.domain.PurchaseRecord;
import kr.codesquad.domain.Result;
import kr.codesquad.enums.Accuracy;
import kr.codesquad.domain.lotto.Lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageGenerator {

    private static final String NEW_LINE_DELIMITER = "\n";
    private static final String LOTTO_COUNT_MSG = "개를 구매했습니다.";
    private static final String GET_MONEY_MSG = "구입금액을 입력해 주세요.";
    private static final String ANSWER_NUMBER_MSG = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_REQUIRE_MSG = "보너스 볼을 입력해 주세요.";
    public static final String MANUAL_LOTTO_COUNT_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_LOTTO_NUMBER_MSG = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String PROFIT_MSG_TEMPLATE = "총 수익률은 %.2f%%입니다.";
    private static final String PURCHASE_RESULT_MSG_TEMPLATE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    public static final String MATCH_RESULT_MSG_TEMPLATE = "%d개 일치 (%d원)-%d개";
    public static final String BONUS_MATCH_RESULT_MSG_TEMPLATE = "%d개 일치, 보너스 볼 일치(%d원)-%d개";

    public String getLottoCountMessage(Integer count) {
        return count + LOTTO_COUNT_MSG;
    }

    public String getMoneyMessage() {
        return GET_MONEY_MSG;
    }

    public String getAnswerNumberMessage() {
        return ANSWER_NUMBER_MSG;
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

    public String getLottoDetailMessage(PurchaseRecord purchaseRecord, List<Lotto> lottos) {
        String lottoMessage = String.join(NEW_LINE_DELIMITER, lottos.stream()
                .map(lotto -> lotto.toString())
                .collect(Collectors.toList()));

        Integer numOfManualLotto = purchaseRecord.getNumOfManualLotto();
        Integer numOfAutoLotto = purchaseRecord.getNumOfLotto() - numOfManualLotto;
        return String.format(PURCHASE_RESULT_MSG_TEMPLATE, numOfManualLotto, numOfAutoLotto) + NEW_LINE_DELIMITER + lottoMessage;
    }

    public String getProfitMessage(Double profit) {
        return String.format(PROFIT_MSG_TEMPLATE, profit);
    }

    public String getBonusNumberMessage() {
        return BONUS_BALL_REQUIRE_MSG;
    }

    public String getManualLottoCountMessage() {
        return MANUAL_LOTTO_COUNT_MSG;
    }

    public String getManualLottoNumberMessage() {
        return MANUAL_LOTTO_NUMBER_MSG;
    }
}
