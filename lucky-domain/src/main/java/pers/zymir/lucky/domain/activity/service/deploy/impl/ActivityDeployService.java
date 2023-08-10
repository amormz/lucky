package pers.zymir.lucky.domain.activity.service.deploy.impl;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.zymir.lucky.domain.activity.model.dto.ActivityCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.AwardCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.StrategyCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.StrategyDetailCreateDTO;
import pers.zymir.lucky.domain.activity.model.req.ActivityDeployReq;
import pers.zymir.lucky.domain.activity.model.res.ActivityResult;
import pers.zymir.lucky.domain.activity.repository.IActivityRepository;
import pers.zymir.lucky.domain.activity.service.deploy.IActivityDeployService;
import pers.zymir.lucky.exception.BusinessException;
import pers.zymir.lucky.exception.ResultCode;

import java.util.List;

@Service
@Slf4j
public class ActivityDeployService implements IActivityDeployService {

    @Autowired
    private IActivityRepository activityRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ActivityResult deploy(ActivityDeployReq activityDeployReq) {
        log.info("开始创建活动，参数：{}", JSONUtil.toJsonStr(activityDeployReq));

        try {
            // 1.创建活动
            ActivityCreateDTO activityCreateDTO = activityDeployReq.getActivityCreateDTO();
            activityRepository.addActivity(activityCreateDTO);

            // 2.创建奖品信息
            List<AwardCreateDTO> awardCreateDTOs = activityDeployReq.getAwardCreateDTOList();
            activityRepository.addAwards(awardCreateDTOs);

            // 3.创建抽奖策略
            StrategyCreateDTO strategyCreateDTO = activityDeployReq.getStrategyCreateDTO();
            long strategyId = activityRepository.addStrategy(strategyCreateDTO);

            // 4.创建策略详细配置
            List<StrategyDetailCreateDTO> strategyDetailCreateDTOs = activityDeployReq.getStrategyDetailCreateDTO();
            strategyDetailCreateDTOs.forEach(detail -> detail.setStrategyId(strategyId));
            activityRepository.addStrategyDetail(strategyDetailCreateDTOs);

            log.info("活动创建成功，ActivityId：{}", activityDeployReq.getActivityId());
        } catch (DuplicateKeyException duplicateKeyException) {
            log.info("抽奖活动创建失败 唯一索引冲突冲突 activityId: {}, 参数：{}", activityDeployReq.getActivityId(), JSONUtil.toJsonStr(activityDeployReq));
            throw new BusinessException(ResultCode.ACTIVITY_CREATE_FAIL);
        }

        ActivityResult activityResult = new ActivityResult();
        activityResult.setSuccess(true);
        return activityResult;
    }

}
