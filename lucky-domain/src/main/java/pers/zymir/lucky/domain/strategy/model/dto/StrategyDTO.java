package pers.zymir.lucky.domain.strategy.model.dto;

import lombok.Data;

@Data
public class StrategyDTO {
    private Long id;
    private Long strategyId;
    private Integer strategyMode;
    private String extInfo;
}
