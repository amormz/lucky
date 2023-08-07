package pers.zymir.lucky.domain.strategy.service.draw.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zymir.lucky.domain.strategy.repository.IStrategyRepository;
import pers.zymir.lucky.domain.strategy.service.algorithm.IDrawAlgorithm;
import pers.zymir.lucky.domain.strategy.service.draw.AbstractDrawService;
import pers.zymir.lucky.helper.MyBatisHelper;

import java.util.Objects;
import java.util.Set;

@Service
public class DefaultDrawService extends AbstractDrawService {

    @Autowired
    private IStrategyRepository strategyRepository;

    @Override
    protected Set<Long> queryExcludeAwardIds(Long strategyId) {
        return strategyRepository.queryEmptyInventoryAwardIds(strategyId);
    }

    @Override
    protected Long drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, Set<Long> excludeAwardIds) {
        Long awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);
        if (Objects.isNull(awardId)) {
            // 未中奖
            return null;
        }

        int result = strategyRepository.deductionInventory(strategyId, awardId);
        boolean success = MyBatisHelper.isSuccess(result);
        if (!success) {
            // 库存扣减失败 视为未中奖
            return null;
        }

        return awardId;
    }
}
