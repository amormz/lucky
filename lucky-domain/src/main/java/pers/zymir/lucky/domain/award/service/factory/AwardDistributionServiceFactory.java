package pers.zymir.lucky.domain.award.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.zymir.lucky.domain.award.service.distribution.IAwardDistributionService;
import pers.zymir.lucky.enums.AwardTypeEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AwardDistributionServiceFactory {

    private static final Map<AwardTypeEnum, IAwardDistributionService> AWARD_DISTRIBUTION_MAPPING = new HashMap<>();

    @Autowired
    public AwardDistributionServiceFactory(List<IAwardDistributionService> awardDistributionServices) {
        awardDistributionServices.forEach(service -> AWARD_DISTRIBUTION_MAPPING.put(service.applyAwardType(), service));
    }

    public static IAwardDistributionService getAwardDistribution(AwardTypeEnum awardTypeEnum) {
        return AWARD_DISTRIBUTION_MAPPING.get(awardTypeEnum);
    }
}
