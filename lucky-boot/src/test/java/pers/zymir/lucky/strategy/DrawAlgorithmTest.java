package pers.zymir.lucky.strategy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zymir.lucky.LuckyApp;
import pers.zymir.lucky.domain.strategy.service.DrawAlgorithmFactory;
import pers.zymir.lucky.domain.strategy.service.IDrawAlgorithm;
import pers.zymir.lucky.enums.StrategyModeEnum;

@SpringBootTest(classes = LuckyApp.class)
@RunWith(SpringRunner.class)
public class DrawAlgorithmTest {

    @Test
    public void testMultiAlgorithm() {
        IDrawAlgorithm multiDrawAlgorithm = DrawAlgorithmFactory.getDrawAlgorithmByCode(StrategyModeEnum.MULTI.getCode());
        for (int i = 0; i < 10; i++) {
            Long awardId = multiDrawAlgorithm.randomDraw(1, null);
            Assert.assertNotNull(awardId);
        }
    }
}
