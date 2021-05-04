package elements;

import core.Board;

import javax.swing.*;
import java.awt.*;

public class Door {

    int x, y;

    public Door(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update(){
        checkWin();
    }

    private void checkWin(){
        if(getBounds().intersects(Board.getPlayer().getBounds())) {
            if(ScorePanel.credit == 50) {
                ScorePanel.isWin = true;
            }
        }
    }

    public void draw(Graphics2D a) {
        a.drawImage(getDoorImg(), x, y, null);//use the x/y found in moving
//		a.draw(getBounds());
    }
    private Image getDoorImg() {// here and not in board so you don't have to call it twice
        ImageIcon icon = new ImageIcon("src/main/resources/image/door.png"); //player character
        return icon.getImage(); //returns this icon's image
    }
    public Rectangle getBounds() {
        return new Rectangle(x,y,getDoorImg().getWidth(null),getDoorImg().getHeight(null));
    }
    public int getX(){return x;}
    public int getY(){ return y;}
}
