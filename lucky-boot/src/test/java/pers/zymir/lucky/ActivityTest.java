package pers.zymir.lucky;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zymir.lucky.dao.ActivityDAO;

@SpringBootTest(classes = LuckyApp.class)
@RunWith(SpringRunner.class)
public class ActivityTest {

    @Autowired
    private ActivityDAO activityDAO;

    @Test
    public void testActivity() {
        Assert.assertNotNull(activityDAO);
    }
}
