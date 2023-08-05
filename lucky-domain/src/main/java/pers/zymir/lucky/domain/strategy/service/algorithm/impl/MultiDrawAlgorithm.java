package pers.zymir.lucky.domain.strategy.service.algorithm.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.zymir.lucky.domain.strategy.model.dto.AwardRateDTO;
import pers.zymir.lucky.domain.strategy.repository.IStrategyRepository;
import pers.zymir.lucky.domain.strategy.service.algorithm.DrawAlgorithmCache;
import pers.zymir.lucky.domain.strategy.service.algorithm.IDrawAlgorithm;
import pers.zymir.lucky.enums.StrategyModeEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class MultiDrawAlgorithm implements IDrawAlgorithm {

    @Autowired
    private IStrategyRepository strategyRepository;

    @Override
    public Long randomDraw(long strategyId, Set<Long> excludeAwardIds) {
        List<AwardRateDTO> awardRates = DrawAlgorithmCache.listAwardRatesFromCache(strategyId);
        Assert.isTrue(CollUtil.isNotEmpty(awardRates));
        // 1.排除不参与抽奖奖品
        excludeAward(excludeAwardIds, awardRates);
        // 2.空奖品返回未中奖
        if (CollUtil.isEmpty(awardRates)) {
            return null;
        }
        // 3.当前为总体概率算法 只剩下一个奖品 直接中奖该奖品
        if (isOnlyRemainOneAward(awardRates)) {
            AwardRateDTO awardRateDTO = awardRates.get(0);
            return awardRateDTO.getAwardId();
        }
        // 4.按照剩余概率 重新分配概率为100%
        redistributeRemainingProbabilities(awardRates);
        // 5.执行抽奖
        Long awardId = executeDraw(awardRates);
        log.info("总体概率算法执行成功，中奖奖品ID: {}, 策略ID: {}", awardId, strategyId);
        return awardId;
    }

    private boolean isOnlyRemainOneAward(List<AwardRateDTO> awardRates) {
        return CollUtil.size(awardRates) == 1;
    }

    private Long executeDraw(List<AwardRateDTO> awardRates) {

        // 中奖奖品ID
        Long awardId = null;

        // 随机数 作为抽奖种子
        int randomSeeds = generateRandomSeeds();

        // 游标
        int cursor = 0;
        for (AwardRateDTO awardRate : awardRates) {
            int rateVal = awardRate.getAwardRate().multiply(new BigDecimal(100)).intValue();
            if (randomSeeds <= (rateVal + cursor)) {
                awardId = awardRate.getAwardId();
                break;
            }

            cursor += rateVal;
        }

        return awardId;
    }

    private int generateRandomSeeds() {
        return RandomUtil.getSecureRandom().nextInt(1, 101);
    }

    private void redistributeRemainingProbabilities(List<AwardRateDTO> awardRates) {
        BigDecimal currentTotalProbability = calculateCurrentTotalProbability(awardRates);
        for (AwardRateDTO awardRate : awardRates) {
            BigDecimal rate = awardRate.getAwardRate();
            awardRate.setAwardRate(rate.divide(currentTotalProbability, RoundingMode.UP));
        }
    }

    private BigDecimal calculateCurrentTotalProbability(List<AwardRateDTO> awardRates) {
        return awardRates.stream()
                .map(AwardRateDTO::getAwardRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void excludeAward(Set<Long> excludeAwardIds, List<AwardRateDTO> awardRates) {
        if (CollUtil.isEmpty(excludeAwardIds)) {
            return;
        }

        awardRates.removeIf(awardRate -> excludeAwardIds.contains(awardRate.getAwardId()));
    }

    @Override
    public Integer getAlgorithmType() {
        return StrategyModeEnum.MULTI.getCode();
    }
}
