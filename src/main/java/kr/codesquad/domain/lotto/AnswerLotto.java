package kr.codesquad.domain.lotto;

import java.util.List;

public class AnswerLotto extends Lotto {
    private Integer bonusNumber;

    public AnswerLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Boolean hasBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
