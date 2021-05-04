package elements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * test for score panel class
 */
public class ScorePanelTest {
    ScorePanel scorePanel;

    @Before
    public void setUp() throws Exception {
        scorePanel = new ScorePanel(20,40);
    }
    @Test
    public void test(){
        Assert.assertNotNull(scorePanel);
        Assert.assertEquals(40, scorePanel.getCredit());
        Assert.assertEquals(20,scorePanel.getScore());

        scorePanel.reduceScore(-10);
        Assert. assertEquals(10,scorePanel.getScore());
        scorePanel.reduceScore_enemy(-10);
        Assert. assertEquals(0,scorePanel.getScore());
        scorePanel.addCredit(10);
        scorePanel.addScore(10);
        Assert. assertEquals(50, scorePanel.getCredit());
        Assert. assertEquals(10,scorePanel.getScore());
        Assert. assertEquals(true,scorePanel.checkScore());
        Assert. assertEquals(true,scorePanel.checkCredit());
        scorePanel.addCredit(-20);
        Assert. assertEquals(false,scorePanel.checkCredit());
        scorePanel.setLose(false);
        Assert. assertEquals(false, scorePanel.isGameOver);
        int score = scorePanel.getScore();
        Assert. assertEquals(10, score);
        scorePanel.reduceScore(-10);
        Assert. assertEquals(false,scorePanel.checkScore());

    }



}