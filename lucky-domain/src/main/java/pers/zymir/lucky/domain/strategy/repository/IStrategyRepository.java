package pers.zymir.lucky.domain.strategy.repository;

import pers.zymir.lucky.domain.strategy.model.dto.AwardRateDTO;

import java.util.List;

public interface IStrategyRepository {
    List<AwardRateDTO> listAwardRates(long strategyId);
}
