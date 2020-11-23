package in.focusminds.diceroll;

import java.util.Random;

public class DiceRoller {

    private Die[] dice;
    private Random rand;
    DiceConstants diceConstants = new DiceConstants();
    public DiceRoller() {
        dice = new Die[diceConstants.getNUMDICE()];
        dice[0] = new Die();
        dice[1] = new Die();
        dice[2] = new Die();

        rand = new Random();

        //rollDiceHard();
    }

    public int generateRandomNumber() {

        return (int) (Math.random() * 27 + 1);
    }


    public void rollDiceHard() {
        for (int i = 0; i < diceConstants.getNUMDICE(); i++) {
            dice[i].setDieResult(generateRandomNumber());
        }
    }

    public void rollDiceEasy() {
        int iEasyRandom = 0;
        int range = 0;
        for (int i = 0; i < diceConstants.getNUMDICE(); i++) {
            if (i == 0) {
                iEasyRandom = (int) (Math.random() * 9 + 1);
                dice[i].setDieResult(iEasyRandom);
            }
            if (i == 1) {
                range = 18 - 10 + 1;
                iEasyRandom = (int) (Math.random() * range + 10);
                dice[i].setDieResult(iEasyRandom);
            }
            if (i == 2) {
                range = 27 - 19 + 1;
                iEasyRandom = (int) (Math.random() * range + 19);
                dice[i].setDieResult(iEasyRandom);
            }

        }
    }

    public Die[] getDice() {
        return dice;
    }
}
