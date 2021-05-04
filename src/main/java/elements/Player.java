package elements;

import core.Board;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player{

    int x, y;
    int speedx = 0;
    int speedy = 0;
    int speed = 40;

    int score_now = 0;
    int credit_now = 0;

    ScorePanel panel = new ScorePanel(score_now,credit_now);
    Door door = new Door(x,y);

    /**
     * @param x is the character's current x position
     * @param y is the character's current y position
     */
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        update();//
    }

    public void update() {
        checkStatus();
        checkCollisions();
        y += speedy;
        x += speedx;
    }

    /**
     * moves the character's position to the next position when key has been pressed
     * @param e is an action type variable
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            speedy = -speed;
        } else if(key == KeyEvent.VK_S) {
            speedy = speed;
        }else if(key == KeyEvent.VK_A) {
            speedx = -speed;
        }else if(key == KeyEvent.VK_D) {
            speedx = speed;
        }
    }

    /**
     * stops the character's movement when key has been released
     * @param e is an action type variable
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            speedy = 0;
        } else if(key == KeyEvent.VK_S) {
            speedy = 0;
        }else if(key == KeyEvent.VK_A) {
            speedx = 0;
        }else if(key == KeyEvent.VK_D) {
            speedx = 0;
        }
    }

    /**
     * Checks if character or enemy intersects with wall
     */
    private void checkCollisions(){
        ArrayList<Enemy> enemies = Board.getEnemyList();
        for(int i = 0; i < enemies.size(); i++) {
            Enemy tempEnemy = enemies.get(i);
            if (getBounds().intersects(tempEnemy.getBounds())) {
                // Score -10
                if(score_now >= 0 && credit_now <= 40) {  //new code
                    panel.reduceScore_enemy(-10);
                    score_now = panel.getScore();
                    credit_now = panel.getCredit();
                }
                else if(score_now < 0){ //new code
                    panel.setLose(true);
                    //System.out.println("gg");
                    enemies.clear();
                }
            }
        }
        ArrayList<Trap> traps = Board.getTrapList();
        for(int i = 0; i < traps.size(); i++) {
            Trap tempTrap = traps.get(i);
            if (getBounds().intersects(tempTrap.getBounds())) { //new code
                Board.removeTrap(tempTrap);
                // Score -10
                if(score_now >= 0 && credit_now <= 40) {
                    panel.reduceScore(-10);
                    score_now = panel.getScore();
                    credit_now = panel.getCredit();
                }
            }
            else if(score_now < 0){ //new code
                panel.setLose(true);
                //System.out.println("gg");
                enemies.clear();
            }
        }
        ArrayList<Reward> rewards = Board.getRewardList();
        for(int i = 0; i < rewards.size(); i++) {
            Reward tempRewards = rewards.get(i);
            if (getBounds().intersects(tempRewards.getBounds())) {
                Board.removeReward(tempRewards);
                // Reward +10
                // Score +10
                if (score_now >= 0 && credit_now <= 50) { //new code
                    panel.addScore(10);
                    panel.addCredit(10);
                    score_now = panel.getScore();
                    credit_now = panel.getCredit();
                }
            }
            else if(score_now < 0){ //new code
                panel.setLose(true);
                //System.out.println("gg");
                enemies.clear();
            }
        }
        ArrayList<Wall> walls = Board.getWallList();
        for(int i = 0; i < walls.size(); i++) {
            Wall tempWall = walls.get(i);
            if(getBounds().intersects(tempWall.getBounds())) {
                speedx = 0;
                speedy = 0;
            }
        }
    }

    private void checkStatus(){
        if(panel.score<0){
            panel.isGameOver = true;
        }
        else if(panel.credit == 50){
            door.update();
        }

    }

    public int getScore(){
        return score_now;
    }
    public int getCredit(){
        return credit_now;
    }
    public int getPlayerX(){
        return x;
    }
    public int getPlayerY(){
        return y;
    }

    public void draw(Graphics2D a) {
        a.drawImage(getPlayerImg(), x, y, null);// draw player image
    }
    private Image getPlayerImg() {// here and not in board so you don't have to call it twice
        ImageIcon icon = new ImageIcon("src/main/resources/image/player.png"); //player character
        return icon.getImage(); //returns this icon's image
    }
    public Rectangle getBounds() {
        return new Rectangle(x+speedx,y+speedy,getPlayerImg().getWidth(null),getPlayerImg().getHeight(null));
    }
}
