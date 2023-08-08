package pers.zymir.lucky.award;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zymir.lucky.LuckyApp;
import pers.zymir.lucky.domain.award.model.req.AwardDistributionReq;
import pers.zymir.lucky.domain.award.model.res.AwardDistributionRes;
import pers.zymir.lucky.domain.award.service.distribution.IAwardDistributionService;
import pers.zymir.lucky.domain.award.service.factory.AwardDistributionServiceFactory;
import pers.zymir.lucky.enums.AwardTypeEnum;

@SpringBootTest(classes = LuckyApp.class)
@RunWith(SpringRunner.class)
public class AwardTest {

    @Test
    public void testAwardDistribution() {
        for (AwardTypeEnum each : AwardTypeEnum.values()) {
            IAwardDistributionService awardDistributionService = AwardDistributionServiceFactory.getAwardDistribution(each);
            Assert.assertNotNull(awardDistributionService);
            AwardDistributionRes awardDistributionRes = awardDistributionService.distributionAward(new AwardDistributionReq());
        }
    }
}
