package racingcar.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public final class RacingGameRequestDto {

    @NotBlank
    private final String names;
    @Positive
    private final int count;

    public RacingGameRequestDto(final String names, final int count) {
        this.names = names;
        this.count = count;
    }

    public String getNames() {
        return this.names;
    }

    public int getCount() {
        return this.count;
    }
}
