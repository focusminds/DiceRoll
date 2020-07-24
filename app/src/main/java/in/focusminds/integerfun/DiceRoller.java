package in.focusminds.integerfun;

import java.util.Random;

public class DiceRoller {

    private Die[] dice;
    private Random rand;

    public DiceRoller(){
        dice = new Die[DiceConstants.NUM_DICE];
        dice[0] = new Die();
        dice[1] = new Die();
        dice[2] = new Die();

        rand = new Random();

        rollDice();
    }

    public int generateRandomNumber(){

        return (int)(Math.random() * 27 + 1);
    }

    public void rollDice() {
        for(int i = 0; i < DiceConstants.NUM_DICE; i++) {
            dice[i].setDieResult(generateRandomNumber());
        }
    }

    public Die[] getDice() {
        return dice;
    }
}
