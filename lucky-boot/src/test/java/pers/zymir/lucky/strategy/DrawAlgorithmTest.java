package pers.zymir.lucky.strategy;

import cn.hutool.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zymir.lucky.LuckyApp;
import pers.zymir.lucky.domain.strategy.model.req.DrawReq;
import pers.zymir.lucky.domain.strategy.model.res.DrawResult;
import pers.zymir.lucky.domain.strategy.service.draw.IDrawService;

@SpringBootTest(classes = LuckyApp.class)
@RunWith(SpringRunner.class)
public class DrawAlgorithmTest {

    @Autowired
    private IDrawService drawService;

    @Test
    public void testMultiAlgorithm() {
        DrawReq drawReq = new DrawReq();
        drawReq.setStrategyId(1L);
        DrawResult drawResult = drawService.executeDraw(drawReq);
        System.out.println(JSONUtil.toJsonStr(drawResult));
    }
}
