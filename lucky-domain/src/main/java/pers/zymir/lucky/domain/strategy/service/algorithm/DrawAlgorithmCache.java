package pers.zymir.lucky.domain.strategy.service.algorithm;

import pers.zymir.lucky.domain.strategy.model.dto.AwardRateDTO;
import pers.zymir.lucky.domain.strategy.model.dto.StrategyDetailDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DrawAlgorithmCache {

    private static final Map<Long, List<AwardRateDTO>> STRATEGY_AWARD_RATE_MAPPING = new ConcurrentHashMap<>();

    public static List<AwardRateDTO> listAwardRatesFromCache(long strategyId) {
        return STRATEGY_AWARD_RATE_MAPPING.get(strategyId);
    }

    public static void checkAndInitAwardRate(Long strategyId, List<StrategyDetailDTO> strategyDetails) {
        if (STRATEGY_AWARD_RATE_MAPPING.containsKey(strategyId)) {
            return;
        }

        Map<Long, List<AwardRateDTO>> awardRateCache = STRATEGY_AWARD_RATE_MAPPING;
        if (awardRateCache.containsKey(strategyId)) {
            return;
        }

        List<AwardRateDTO> awardRates = new ArrayList<>(strategyDetails.size());
        for (StrategyDetailDTO strategyDetail : strategyDetails) {
            awardRates.add(new AwardRateDTO(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        awardRateCache.put(strategyId, awardRates);
    }

}
