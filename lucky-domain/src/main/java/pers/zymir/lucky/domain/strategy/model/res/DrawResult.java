package pers.zymir.lucky.domain.strategy.model.res;

import lombok.Data;

@Data
public class DrawResult {
    private Boolean isLucky;

    private String awardName;

    private Long awardId;
}
