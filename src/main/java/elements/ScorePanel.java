package elements;


/**
 * ScorePanel class
 */
public class ScorePanel {

    int score;
    static int credit;
    static public boolean isGameOver=false;
    static public boolean isWin=false;

    int game_scor; //game_scor = 0, game lose; game_scor = 1, game continue
    int game_cred; //game_cred = 100

    /**
     * @param score
     * @param credit
     * constructor
     */
    public ScorePanel(int score, int credit){
        this.score = score;
        this.credit = credit;
    }


    /**
     * @param state
     * set lose state
     */
    public void setLose(boolean state){
        isGameOver = state;
    }

    /**
     * @return
     * get score
     */
    public int getScore(){
        return score;
    }

    /**
     * @return
     * get credit
     */
    public int getCredit(){
        return credit;
    }

    /**
     * @param number
     * add score
     */
    public void addScore(int number){
        score = score + number;
    }

    /**
     * @param number
     * reduce score
     */
    public void reduceScore(int number){
        score = score + number;
    }

    /**
     * @param number
     * reduce score with enemy
     */
    public void reduceScore_enemy(int number){
        score = score + number;
    }

    /**
     * @return
     * check score
     */
    public boolean checkScore(){
        if(score<=0){
            game_scor = 0;
            return false; //game lose
        }
        else{
            game_scor = 1;
            return true;
        }
    }

    /**
     * @param nunmber
     */
    public void addCredit(int nunmber){
        credit = credit + nunmber;
    }

    /**
     * @return
     * check credit
     */
    public boolean checkCredit(){ //5 reward, if user gets 4 reward or gets 5 but is hitted 1 once, game win
        if(credit >= 40){
            game_cred = 1;
            return true;
        }
        else{
            return false;
        }
    }

}

