package pers.zymir.lucky.domain.strategy.repository;

import pers.zymir.lucky.domain.strategy.model.dto.StrategyConfigDTO;

public interface IStrategyRepository {

    StrategyConfigDTO queryStrategyConfig(Long strategyId);
}
