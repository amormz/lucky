package pers.zymir.lucky;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zymir.lucky.dao.ActivityMapper;
import pers.zymir.lucky.po.Activity;

import java.util.List;

@SpringBootTest(classes = LuckyApp.class)
@RunWith(SpringRunner.class)
public class ActivityTest {

    @Autowired
    private ActivityMapper activityMapper;

    @Test
    public void testActivity() {
        Assert.assertNotNull(activityMapper);
        LambdaQueryWrapper<Activity> activityLambdaQueryWrapper = Wrappers.lambdaQuery(Activity.class);
        List<Activity> activities = activityMapper.selectList(activityLambdaQueryWrapper);
        System.out.println(activities);
    }
}
