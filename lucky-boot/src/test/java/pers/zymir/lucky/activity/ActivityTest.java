package pers.zymir.lucky.activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zymir.lucky.LuckyApp;
import pers.zymir.lucky.constant.ActivityStateEnum;
import pers.zymir.lucky.constant.AwardTypeEnum;
import pers.zymir.lucky.constant.StrategyGrantTypeEnum;
import pers.zymir.lucky.constant.StrategyModeEnum;
import pers.zymir.lucky.domain.activity.model.dto.ActivityCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.AwardCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.StrategyCreateDTO;
import pers.zymir.lucky.domain.activity.model.dto.StrategyDetailCreateDTO;
import pers.zymir.lucky.domain.activity.model.req.ActivityDeployReq;
import pers.zymir.lucky.domain.activity.model.res.ActivityResult;
import pers.zymir.lucky.domain.activity.service.deploy.IActivityDeployService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;

@SpringBootTest(classes = LuckyApp.class)
@RunWith(SpringRunner.class)
public class ActivityTest {

    @Autowired
    private IActivityDeployService activityDeployService;

    @Test
    public void testActivityDeploy() {
        ActivityDeployReq activityDeployReq = new ActivityDeployReq();
        activityDeployReq.setActivityId(123456L);

        ActivityCreateDTO activityCreateDTO = new ActivityCreateDTO();
        activityCreateDTO.setActivityId(123456L);
        activityCreateDTO.setActivityName("活动部署测试");
        activityCreateDTO.setActivityDesc("测试");
        activityCreateDTO.setBeginDateTime(new Date());
        activityCreateDTO.setEndDateTime(new Date());
        activityCreateDTO.setStockCount(10);
        activityCreateDTO.setTakeCount(1);
        activityCreateDTO.setState(ActivityStateEnum.EDIT.getCode());
        activityCreateDTO.setCreator("zymir");

        activityDeployReq.setActivityCreateDTO(activityCreateDTO);
        AwardCreateDTO awardCreateDTO = new AwardCreateDTO();
        awardCreateDTO.setAwardId("123");
        awardCreateDTO.setAwardType(AwardTypeEnum.COUPON.getCode());
        awardCreateDTO.setAwardName("优惠券");
        awardCreateDTO.setAwardContent("CDK..");

        activityDeployReq.setAwardCreateDTOList(Collections.singletonList(awardCreateDTO));
        StrategyCreateDTO strategyCreateDTO = new StrategyCreateDTO();
        strategyCreateDTO.setStrategyId(123L);
        strategyCreateDTO.setStrategyDesc("测试策略");
        strategyCreateDTO.setStrategyMode(StrategyModeEnum.MULTI.getCode());
        strategyCreateDTO.setGrantType(StrategyGrantTypeEnum.IMMEDIATELY.getCode());
        strategyCreateDTO.setGrantDate(new Date());
        strategyCreateDTO.setExtInfo("non");
        activityDeployReq.setStrategyCreateDTO(strategyCreateDTO);

        StrategyDetailCreateDTO strategyDetailCreateDTO = new StrategyDetailCreateDTO();
        strategyDetailCreateDTO.setStrategyId(123L);
        strategyDetailCreateDTO.setAwardId("123");
        strategyDetailCreateDTO.setAwardName("优惠券");
        strategyDetailCreateDTO.setAwardCount(10);
        strategyDetailCreateDTO.setAwardSurplusCount(10);
        strategyDetailCreateDTO.setAwardRate(BigDecimal.ONE);

        activityDeployReq.setStrategyDetailCreateDTO(Collections.singletonList(strategyDetailCreateDTO));
        ActivityResult deploy = activityDeployService.deploy(activityDeployReq);
    }
}

