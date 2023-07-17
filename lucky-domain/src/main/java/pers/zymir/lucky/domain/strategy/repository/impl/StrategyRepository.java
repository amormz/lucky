package pers.zymir.lucky.domain.strategy.repository.impl;

import org.springframework.stereotype.Repository;
import pers.zymir.lucky.domain.strategy.model.dto.AwardRateDTO;
import pers.zymir.lucky.domain.strategy.repository.IStrategyRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StrategyRepository implements IStrategyRepository {
    public List<AwardRateDTO> listAwardRates(long strategyId) {

        // TODO MOCK数据
        List<AwardRateDTO> result = new ArrayList<>();
        result.add(new AwardRateDTO(100L, new BigDecimal("0.01")));
        result.add(new AwardRateDTO(101L, new BigDecimal("0.22")));
        result.add(new AwardRateDTO(102L, new BigDecimal("0.32")));
        result.add(new AwardRateDTO(103L, new BigDecimal("0.02")));
        result.add(new AwardRateDTO(104L, new BigDecimal("0.31")));
        return result;
    }
}
