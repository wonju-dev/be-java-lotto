package kr.codesquad.domain;

import java.util.List;

public class AnswerLotto extends Lotto {
    private Integer bonusNumber;

    public AnswerLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Boolean matchBonusNumber(Integer number) {
        return bonusNumber == number;
    }
}
