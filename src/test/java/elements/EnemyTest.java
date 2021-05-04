package elements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class EnemyTest {

    Enemy enemy;

    /**
     * Test on constructor
     */
    @Before
    public void setUp() throws Exception {
        enemy = new Enemy(40, 80);
        Assert.assertNotNull(enemy);
        Assert.assertEquals(40, enemy.getX());
        Assert.assertEquals(80,enemy.getY());
        Assert.assertEquals(0, enemy.getxSpeed());
        Assert.assertEquals(0,enemy.getySpeed());
    }

    /**
     * Test on enemy's movement (chase player),
     * not include checkCollisions.
     */
    @Test
    public void Move() {
        // test positive x movement
        int playerx = 80;
        int playery = 80;
        enemy.update(playerx, playery);
        Assert.assertEquals(50, enemy.getX());
        Assert.assertEquals(80,enemy.getY());
        // test negative x movement
        playerx = 40;
        playery = 80;
        enemy.update(playerx, playery);
        Assert.assertEquals(40, enemy.getX());
        Assert.assertEquals(80,enemy.getY());
        // test positive y movement
        playerx = 40;
        playery = 120;
        enemy.update(playerx, playery);
        Assert.assertEquals(40, enemy.getX());
        Assert.assertEquals(90,enemy.getY());
        // test negative x movement
        playerx = 40;
        playery = 40;
        enemy.update(playerx, playery);
        Assert.assertNotNull(enemy);
        Assert.assertEquals(40, enemy.getX());
        Assert.assertEquals(80,enemy.getY());
    }

    /**
     * Test on getBounds
     */
    @Test
    public void getBounds() {
        Rectangle r = new Rectangle(40, 80, 40, 40);
        Assert.assertEquals(r.getBounds(), enemy.getBounds());
    }
}