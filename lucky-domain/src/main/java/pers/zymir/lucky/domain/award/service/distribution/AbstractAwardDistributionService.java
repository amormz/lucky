package pers.zymir.lucky.domain.award.service.distribution;

import pers.zymir.lucky.domain.award.model.req.AwardDistributionReq;
import pers.zymir.lucky.domain.award.model.res.AwardDistributionRes;

/**
 * TODO 待完善的类
 */
public abstract class AbstractAwardDistributionService implements IAwardDistributionService {

    @Override
    public AwardDistributionRes distributionAward(AwardDistributionReq awardDistributionReq) {
        // 1.执行奖品发放逻辑
        boolean distributionResult = executeDistribution(awardDistributionReq);
        // 2.成功/失败 更新用户发奖状态
        updateUserAwardState(distributionResult, awardDistributionReq);
        // 3.构建结果
        return new AwardDistributionRes();
    }

    protected abstract boolean executeDistribution(AwardDistributionReq awardDistributionReq);

    public void updateUserAwardState(boolean distributionResult, AwardDistributionReq awardDistributionReq) {

    }
}
