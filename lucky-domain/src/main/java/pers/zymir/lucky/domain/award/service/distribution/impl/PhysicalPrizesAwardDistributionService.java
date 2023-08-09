package pers.zymir.lucky.domain.award.service.distribution.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.zymir.lucky.constant.AwardTypeEnum;
import pers.zymir.lucky.domain.award.model.req.AwardDistributionReq;
import pers.zymir.lucky.domain.award.service.distribution.AbstractAwardDistributionService;

@Service
@Slf4j
public class PhysicalPrizesAwardDistributionService extends AbstractAwardDistributionService {
    @Override
    protected boolean executeDistribution(AwardDistributionReq awardDistributionReq) {
        log.info("模拟调用实物奖品发放服务...");
        return true;
    }

    @Override
    public AwardTypeEnum applyAwardType() {
        return AwardTypeEnum.PHYSICAL_PRIZES;
    }
}
