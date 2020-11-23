package in.focusminds.diceroll.sound;

import android.content.Context;

import in.focusminds.diceroll.R;

public class Constants {

    public static final int sRoll = R.raw.shake_dice;
    public static final int sCorrectAnser =R.raw.cheers;
    public static final int sWrongAnswer =R.raw.ohno;
    public static final int sEndgame = R.raw.endgame;
    public static final int buttonClick = R.raw.button;

    public static void initSoundManager(Context context, SoundManager soundManager){
        soundManager.addSound(context,sRoll);
        soundManager.addSound(context,sCorrectAnser);
        soundManager.addSound(context,sWrongAnswer);
        soundManager.addSound(context,sEndgame);
        soundManager.addSound(context,buttonClick);
    }
}
