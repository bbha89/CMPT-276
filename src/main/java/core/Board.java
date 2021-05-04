package core;

import inputs.KeyAdapt;
import inputs.Menu;
import inputs.MouseInput;
import elements.*;

import java.awt.*;//graphics
import java.awt.event.*;//events
import java.util.ArrayList;

import javax.swing.*;

import static elements.ScorePanel.isGameOver;
import static elements.ScorePanel.isWin;

public class Board extends JPanel implements ActionListener {

    // Menu
    public enum STATE{
        GAME, MENU
    };
    public static STATE state = STATE.MENU;
    public inputs.Menu menu = new Menu();

    private Image GameBackground = Toolkit.getDefaultToolkit().getImage("src/main/resources/image/map.png");
    private Image MenuBackground = Toolkit.getDefaultToolkit().getImage("src/main/resources/image/menu.png");

    public static final int DEFAULTWIDTH = 40;
    public static final int DEFAULTHEIGHT = 40;
    public static final int MAPROWS = 15;
    public static final int MAPCOLS = 20;
    public static int[][] idMap = new int[][]{
   //  0 = wall  1 = path  2 = reward  3 = trap  4 = enemy  5 = player  6 = door
   //  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19
	  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	  {0, 1, 1, 2, 1, 0, 1, 1, 1, 4, 1, 1, 1, 1, 0, 1, 1, 2, 1, 0},
	  {0, 1, 5, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
	  {0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0},
	  {0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0}, // 4
	  {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 3, 1, 1, 1, 1, 1, 1, 0},
	  {0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 4, 1, 1, 6},
	  {0, 4, 1, 0, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 3, 1, 0},
	  {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
	  {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 0}, // 9
	  {0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
	  {0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0},
	  {0, 1, 2, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
	  {0, 1, 1, 1, 1, 0, 1, 1, 1, 4, 1, 1, 1, 1, 0, 1, 1, 2, 1, 0},
	  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}  // 14
	};

    public static Timer timer;
    public static Player player;
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static ArrayList<Trap> traps = new ArrayList<Trap>();
    public static ArrayList<Reward> rewards = new ArrayList<Reward>();
    public static ArrayList<Wall> walls = new ArrayList<Wall>();
    public static Door door;

    public Board() {

        // Build map
        for(int i = 0; i < MAPROWS; i++){
            for(int j = 0; j < MAPCOLS; j++){
                if(idMap[i][j] == 0){
                    addWall(new Wall(j*DEFAULTWIDTH, i*DEFAULTHEIGHT));
                }
                if(idMap[i][j] == 2){
                    addReward(new Reward(j*DEFAULTWIDTH, i*DEFAULTHEIGHT));
                }
                if(idMap[i][j] == 3){
                    addTrap(new Trap(j*DEFAULTWIDTH, i*DEFAULTHEIGHT));
                }
                if(idMap[i][j] == 4){
                    addEnemy(new Enemy(j*DEFAULTWIDTH, i*DEFAULTHEIGHT));
                }
                if(idMap[i][j] == 5){
                    player = new Player(j*DEFAULTWIDTH, i*DEFAULTHEIGHT);
                }
                if(idMap[i][j] == 6){
                    door = new Door(j*DEFAULTWIDTH, i*DEFAULTHEIGHT);
                    addWall(new Wall((j+1)*DEFAULTWIDTH, i*DEFAULTHEIGHT));
                }
            }
        }

        setFocusable(true);
        addMouseListener(new MouseInput());
        addKeyListener(new KeyAdapt(player));

        timer = new Timer(100, this);// perform this(class) actionPerformed every 25ms
        timer.start();//start timer

    }

    /**
     * This method is used for drawing image on screen
     * @param g is a Graphics type variable
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D a = (Graphics2D) g; // draws player character etc

        if(state == STATE.MENU){
            a.drawImage(MenuBackground, 0, 0, 800, 600, this);
            this.menu.paint(g);
        }

        if(state == STATE.GAME) {
            a.drawImage(this.GameBackground, 0, 0, 800, 600, this);

            for (int i = 0; i < traps.size(); i++) {
                Trap tempTrap = traps.get(i);
                tempTrap.draw(a);
            }
            for (int i = 0; i < rewards.size(); i++) {
                Reward tempReward = rewards.get(i);
                tempReward.draw(a);
            }
            door.draw(a);
            for (int i = 0; i < enemies.size(); i++) {
                Enemy tempEnemy = enemies.get(i);
                tempEnemy.draw(a);
            }
            player.draw(a);// draw the player image onto the panel
            for (int i = 0; i < walls.size(); i++) {
                Wall tempWall = walls.get(i);
                tempWall.draw(a);
            }

            //score panel
            g.setColor(Color.white);
            g.setFont(new Font("", Font.BOLD, 15));
            a.drawString("Score: ", 650, 20);
            a.drawString("Reward: ", 650, 40);
            g.drawString("" + player.getScore(), 715, 20);
            g.drawString("" + player.getCredit(), 715, 40);

            //Fail end
            if(isGameOver){
                timer.stop();
                g.setColor(Color.BLACK);
                g.setFont(new Font("",Font.BOLD,60));
                g.drawString("GAME OVER", 800/2-180, 620/2);
            }

            //Successful end
            if(isWin){
                timer.stop();
                g.setColor(Color.BLACK);
                g.setFont(new Font("",Font.BOLD,60));
                g.drawString("SUCCESS", 800/2-145, 620/2);
            }

        }

    }

    /**
     * This method is implemented from ActionListener, used for repaint screen
     * @param e is an ActionEvent type variable
     */
    public void actionPerformed(ActionEvent e) {
        if(state==STATE.GAME) {
            player.update();
            door.update();
            for (int i = 0; i < enemies.size(); i++) {
                Enemy tempEnemy = enemies.get(i);
                tempEnemy.update(player.getPlayerX(), player.getPlayerY());
            }
            repaint();// update the panel
        }
    }

    /*
     * Adding methods
     */
    private void addTrap(Trap trap) {
        traps.add(trap);
    }
    private void addReward(Reward reward) {
        rewards.add(reward);
    }
    private void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
    private void addWall(Wall wall) {
        walls.add(wall);
    }

    /*
     * Getting methods
     */
    public static Player getPlayer(){
        return player;
    }
    public static ArrayList<Trap> getTrapList() {//gives us enemy arraylist
        return traps;
    }
    public static ArrayList<Reward> getRewardList() {//gives us reward arraylist
        return rewards;
    }
    public static ArrayList<Enemy> getEnemyList() {
        return enemies;
    }
    public static ArrayList<Wall> getWallList() {//gives us reward arraylist
        return walls;
    }
    public static Door getDoor(){
        return door;
    }

    /*
     * Removing methods
     */
    public static void removeTrap(Trap trap) {
        traps.remove(trap);
    }
    public static void removeReward(Reward reward) {
        rewards.remove(reward);
    }

}