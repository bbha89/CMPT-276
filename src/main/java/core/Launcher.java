package core;

import javax.swing.JFrame;

/**
 *
 */
public class Launcher {

    /**
     * Creates the interface for the Game
     * @param args
     */
    public static void main(String[] args) {
        new Launcher();
    }

    public Launcher() {
        JFrame f = new JFrame();
        f.setTitle("Virus2020");
        f.add(new Board());
        f.setSize(800,620);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setResizable(false);
    }

}
