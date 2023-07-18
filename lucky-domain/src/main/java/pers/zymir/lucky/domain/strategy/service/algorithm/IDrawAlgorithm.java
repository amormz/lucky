package pers.zymir.lucky.domain.strategy.service.algorithm;

import pers.zymir.lucky.domain.strategy.model.dto.AwardRateDTO;
import pers.zymir.lucky.enums.StrategyModeEnum;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽奖算法
 */
public interface IDrawAlgorithm {

    Map<Long, List<AwardRateDTO>> STRATEGY_AWARD_RATE_MAPPING = new ConcurrentHashMap<>();

    /**
     * 随机进行抽奖
     *
     * @param strategyId      策略ID
     * @param excludeAwardIds 排除的奖品（抽奖算法不关心业务，无库存等业务逻辑排除的通过该字段传递进来）
     * @return 中奖奖品ID，null为未中奖
     */
    Long randomDraw(long strategyId, Set<Long> excludeAwardIds);

    /**
     * 获取当前算法类型code
     *
     * @return {@link StrategyModeEnum#getCode()}
     */
    Integer getAlgorithmType();
}
