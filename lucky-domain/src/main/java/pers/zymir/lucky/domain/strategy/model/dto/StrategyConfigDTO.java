package pers.zymir.lucky.domain.strategy.model.dto;

import lombok.Data;
import pers.zymir.lucky.po.Strategy;
import pers.zymir.lucky.po.StrategyDetail;

import java.util.List;

@Data
public class StrategyConfigDTO {
    private Strategy strategy;

    private List<StrategyDetail> strategyDetails;
}
