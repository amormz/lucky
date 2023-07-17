package pers.zymir.lucky.domain.strategy.service.impl;

import org.springframework.stereotype.Component;
import pers.zymir.lucky.domain.strategy.service.IDrawAlgorithm;
import pers.zymir.lucky.enums.StrategyModeEnum;

import java.util.Set;

@Component
public class SingletonDrawAlgorithm implements IDrawAlgorithm {

    @Override
    public Long randomDraw(long strategyId, Set<Long> excludeAwardIds) {
        return null;
    }

    @Override
    public Integer getAlgorithmType() {
        return StrategyModeEnum.SINGLETON.getCode();
    }

}
