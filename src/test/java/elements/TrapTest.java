package elements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * test trap class
 */
public class TrapTest {

    Trap trap = new Trap(40,80);

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(trap);
        Assert.assertEquals(40, trap.getX());
        Assert.assertEquals(80, trap.getY());
    }


    @Test
    public void getBounds() {
        Rectangle r = new Rectangle(40, 80, 40, 40);
        Assert.assertEquals(r.getBounds(), trap.getBounds());
    }
}