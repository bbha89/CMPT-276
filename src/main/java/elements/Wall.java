package elements;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Wall{

    int x, y;

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D a) {
        a.drawImage(getWallImg(), x, y, null);//use the x/y found in moving
//		a.draw(getBounds());
    }
    private Image getWallImg() {// here and not in board so you don't have to call it twice
        ImageIcon icon = new ImageIcon("src/main/resources/image/wall.png"); //player character
        return icon.getImage(); //returns this icon's image
    }
    public Rectangle getBounds() {
        return new Rectangle(x,y,getWallImg().getWidth(null),getWallImg().getHeight(null));
    }
    public int getX(){return x;}
    public int getY(){ return y;}
}