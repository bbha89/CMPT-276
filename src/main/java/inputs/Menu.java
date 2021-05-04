package inputs;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    public Rectangle playbutton = new Rectangle(500,400,150,80);

    public void paint(Graphics g) {
        Graphics2D a = (Graphics2D) g;
        Font f = new Font("SansSerif", Font.BOLD, 80);
        Font f2 = new Font("arial", Font.BOLD, 40);

        g.setColor(Color.white);
        g.setFont(f);
        g.drawString("Virus2020", 100,150);

        g.setFont(f2);
        g.drawString("Play", playbutton.x +45, playbutton.y + 45);
        //a.draw(playbutton);
    }

}
