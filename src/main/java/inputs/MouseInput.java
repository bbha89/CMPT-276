package inputs;

import core.Board;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(final MouseEvent e) {
        
    }

    @Override
    public void mousePressed(final MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();
//        public Rectangle playbutton = new Rectangle(500,400,150,80);
        if(mx >= 500 && mx <= 650){
            if(my >= 400 && my <= 480){
                Board.state = Board.STATE.GAME;
            }
        }

    }

    @Override
    public void mouseReleased(final MouseEvent e) {

    }

    @Override
    public void mouseEntered(final MouseEvent e) {

    }

    @Override
    public void mouseExited(final MouseEvent e) {

    }
}
