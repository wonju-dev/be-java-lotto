package kr.codesquad.messageGenerator;

public class MessageGenerator {

    private static final String LOTTO_COUNT_MSG_TEMPLATE = "개를 구매했습니다.";
    private static final String INPUT_MSG_TEMPLATE = "구입금액을 입력해 주세요.";

    public String getLottoCountMessage(Integer count) {
        return count + LOTTO_COUNT_MSG_TEMPLATE;
    }

    public String getInputMessage() {
        return INPUT_MSG_TEMPLATE;
    }
}
