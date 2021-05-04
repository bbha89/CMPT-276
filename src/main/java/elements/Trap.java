package elements;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Trap{

    int x, y;

    public Trap(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D a) {
        a.drawImage(getTrapImg(), x, y, null);//use the x/y found in moving
//		a.draw(getBounds());
    }
    private Image getTrapImg() {// here and not in board so you don't have to call it twice
        ImageIcon icon = new ImageIcon("src/main/resources/image/trap.png"); //player character
        return icon.getImage(); //returns this icon's image
    }
    public Rectangle getBounds() {
        return new Rectangle(x,y,getTrapImg().getWidth(null),getTrapImg().getHeight(null));
    }
    public int getX(){return x;}
    public int getY(){ return y;}
}