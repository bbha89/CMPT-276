package elements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class WallTest {

    Wall wall = new Wall(40, 80);

    /**
     * Test on constructor
     */
    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(wall);
        Assert.assertEquals(40, wall.getX());
        Assert.assertEquals(80,wall.getY());
    }

    /**
     * Test on getBounds
     */
    @Test
    public void getBounds() {
        Rectangle r = new Rectangle(40, 80, 40, 40);
        Assert.assertEquals(r.getBounds(), wall.getBounds());
    }
}