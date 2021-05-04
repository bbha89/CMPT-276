package elements;

import core.Board;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy{

    int x, y;
    int xSpeed = 0;
    int ySpeed = 0;
    int speed = 10;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update(int playerX, int playerY) {
        chasePlayer(playerX, playerY);
        checkCollisions();
        x += xSpeed;
        y += ySpeed;
    }
    private void chasePlayer(int playerX, int playerY) {
        if(x < playerX){
            xSpeed = +speed;
        }
        else if(x > playerX) {
            xSpeed = -speed;
        }
        else if ( x == playerX ){
            xSpeed = 0;
        }
        if(y < playerY) {
            ySpeed = +speed;
        }
        else if(y > playerY) {
            ySpeed = -speed;
        }
        else if ( y == playerY ){
            ySpeed = 0;
        }
    }
    private void checkCollisions(){
        ArrayList<Wall> walls = Board.getWallList();
        for(int i = 0; i < walls.size(); i++) {
            Wall tempWall = walls.get(i);
            if(getBounds().intersects(tempWall.getBounds())) {
                xSpeed = 0;
                ySpeed = 0;
            }
        }
//        if(getBounds().intersects(Board.getDoor().getBounds())) {
//            xSpeed = 0;
//            ySpeed = 0;
//        }
    }

    public void draw(Graphics2D a) {
        a.drawImage(getEnemyImg(), x, y, null);// draw player image
//      a.draw(getBounds());
    }
    private Image getEnemyImg() {// here and not in board so you don't have to call it twice
        ImageIcon icon = new ImageIcon("src/main/resources/image/enemy.png"); //player character
        return icon.getImage(); //returns this icon's image
    }
    public Rectangle getBounds() {
        return new Rectangle(x+xSpeed,y+ySpeed,getEnemyImg().getWidth(null),getEnemyImg().getHeight(null));
    }
    public int getX(){ return x;}
    public int getY(){ return y;}
    public int getxSpeed(){ return xSpeed;}
    public int getySpeed(){ return ySpeed;}
}
