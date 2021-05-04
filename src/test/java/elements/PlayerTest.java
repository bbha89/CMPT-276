package elements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class PlayerTest {

    Player player;

    /**
     * Test on constructor
     */
    @Before
    public void setUp() throws Exception {
        player = new Player(40, 80);
        Assert.assertNotNull(player);
        Assert.assertEquals(40, player.getPlayerX());
        Assert.assertEquals(80,player.getPlayerY());
        Assert.assertEquals(0, player.getScore());
        Assert.assertEquals(0,player.getCredit());
    }

    /**
     * Test on player's movement,
     * not include checkStatus and checkCollisions.
     */
    @Test
    public void Move() {
        // test positive x movement
        player.speedx = player.speed;
        player.update();
        Assert.assertEquals(80, player.getPlayerX());
        Assert.assertEquals(80, player.getPlayerY());
        player.speedx = 0;
        // test negative x movement
        player.speedx = -player.speed;
        player.update();
        Assert.assertEquals(40, player.getPlayerX());
        Assert.assertEquals(80, player.getPlayerY());
        player.speedx = 0;
        // test negative y movement
        player.speedy = -player.speed;
        player.update();
        Assert.assertEquals(40, player.getPlayerX());
        Assert.assertEquals(40, player.getPlayerY());
        player.speedy = 0;
        // test positive y movement
        player.speedy = player.speed;
        player.update();
        Assert.assertEquals(40, player.getPlayerX());
        Assert.assertEquals(80, player.getPlayerY());
        player.speedy = 0;
    }

    /**
     * Test on getBounds
     */
    @Test
    public void getBounds() {
        Rectangle r = new Rectangle(40, 80, 40, 40);
        Assert.assertEquals(r.getBounds(), player.getBounds());
    }
}