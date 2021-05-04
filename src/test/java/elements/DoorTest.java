package elements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * test door class
 */
public class DoorTest {

    Door door = new Door(40,80);

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(door);
        Assert.assertEquals(40, door.getX());
        Assert.assertEquals(80,door.getY());
    }


    @Test
    public void getBounds() {
        Rectangle r = new Rectangle(40, 80, 40, 40);
        Assert.assertEquals(r.getBounds(), door.getBounds());
    }
}