package elements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * test reward class
 */
public class RewardTest {

    Reward reward = new Reward(40,80);


    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(reward);
        Assert.assertEquals(40, reward.getX());
        Assert.assertEquals(80, reward.getY());
    }


    @Test
    public void getBounds() {
        Rectangle r = new Rectangle(40, 80, 40, 40);
        Assert.assertEquals(r.getBounds(), reward.getBounds());
    }
}