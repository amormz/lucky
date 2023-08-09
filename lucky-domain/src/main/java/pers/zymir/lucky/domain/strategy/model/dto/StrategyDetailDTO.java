package pers.zymir.lucky.domain.strategy.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StrategyDetailDTO {
    private Long awardId;
    private BigDecimal awardRate;
}
