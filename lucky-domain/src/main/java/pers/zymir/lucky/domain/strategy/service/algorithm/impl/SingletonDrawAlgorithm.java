package pers.zymir.lucky.domain.strategy.service.algorithm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.zymir.lucky.domain.strategy.repository.IStrategyRepository;
import pers.zymir.lucky.domain.strategy.service.algorithm.IDrawAlgorithm;
import pers.zymir.lucky.enums.StrategyModeEnum;

import java.util.Set;

@Component
public class SingletonDrawAlgorithm implements IDrawAlgorithm {

    @Autowired
    private IStrategyRepository strategyRepository;

    @Override

    public Long randomDraw(long strategyId, Set<Long> excludeAwardIds) {
        return null;
    }

    @Override
    public Integer getAlgorithmType() {
        return StrategyModeEnum.SINGLETON.getCode();
    }

}
