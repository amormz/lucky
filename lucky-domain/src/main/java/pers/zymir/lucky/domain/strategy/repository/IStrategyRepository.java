package pers.zymir.lucky.domain.strategy.repository;

import pers.zymir.lucky.domain.strategy.model.dto.StrategyConfigDTO;

import java.util.Set;

public interface IStrategyRepository {

    StrategyConfigDTO queryStrategyConfig(Long strategyId);

    int deductionInventory(Long strategyId, Long awardId);

    Set<Long> queryEmptyInventoryAwardIds(Long strategyId);
}
