package pers.zymir.lucky.domain.strategy.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class StrategyConfigDTO {
    private StrategyDTO strategy;

    private List<StrategyDetailDTO> strategyDetails;
}
