package pers.zymir.lucky.domain.award.service.distribution;

import pers.zymir.lucky.constant.AwardTypeEnum;
import pers.zymir.lucky.domain.award.model.req.AwardDistributionReq;
import pers.zymir.lucky.domain.award.model.res.AwardDistributionRes;

public interface IAwardDistributionService {

    AwardDistributionRes distributionAward(AwardDistributionReq awardDistributionReq);

    AwardTypeEnum applyAwardType();
}
