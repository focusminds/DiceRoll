package in.focusminds.diceroll;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import in.focusminds.diceroll.sound.MyApplication;
import in.focusminds.diceroll.sound.SoundManager;


public class AdditionActivity extends AppCompatActivity {

    AudioManager audioManager;
    float actualVolume;
    private int sRoll, sCorrectAnser, sWrongAnswer, sEndgame;
    private DiceRoller diceRoller;
    ImageView[] diceViews;
    int[] inumber = new int[3];
    Button bRollButton, bCheckAnswer, bEndGame, bBack;
    TextView tAnsTextView, tNumberofQuestions, tButtonLabel;
    ImageView iRedDice, iGreenDice, iYellowDice;
    EditText eResultNumber;
    RatingBar rtScoreBar;
    double iReddicenumber = 0;
    double iGreendicenumber = 0;
    double iYellowdicenumber = 0;
    double iresultnumber = 0;
    double dEnteredResult = 0;
    String sAction = "";
    String sLabel = "";
    String sLevel = "";

    int iQ = 0;
    int iCorrect = 0;
    String siQ = "";
    int unicde = 0x1F973;
    String sSmiley = "";
    Dialog hintdialog;
    String str = "";
    public SoundManager soundManager;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    // private static final String TAG = "AdditionActivity";
    DiceConstants diceConstants = new DiceConstants();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent iLabelMessage = getIntent();
        sLabel = iLabelMessage.getStringExtra("Action");
        sLevel = iLabelMessage.getStringExtra("Level");
        super.onCreate(savedInstanceState);
        setTitle(sLabel);


        setContentView(R.layout.activity_addition);


        iGreenDice = findViewById(R.id.greenimageView);
        if (sLevel.equalsIgnoreCase("Easy")) {
            iGreenDice.setVisibility(View.INVISIBLE);
            diceConstants.setNUMDICE(2);
        } else {

            diceConstants.setNUMDICE(3);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        bRollButton = findViewById(R.id.rollbutton);
        bCheckAnswer = findViewById(R.id.checkanwer);
        bEndGame = findViewById(R.id.endgame);

        bCheckAnswer.setVisibility(View.INVISIBLE);

        bEndGame.setVisibility(View.INVISIBLE);

        tAnsTextView = findViewById(R.id.answerstatus);
        tNumberofQuestions = findViewById(R.id.numberofquestions);
        tButtonLabel = findViewById(R.id.buttonlabel);

        eResultNumber = findViewById(R.id.signedresultnumber);
        rtScoreBar = findViewById(R.id.ratingBar);

        tButtonLabel.setText("Roll Dice");


        sRoll = R.raw.shake_dice;
        sCorrectAnser = R.raw.cheers;
        sWrongAnswer = R.raw.ohno;
        sEndgame = R.raw.endgame;


        diceViews = new ImageView[diceConstants.getNUMDICE()];

        diceRoller = new DiceRoller();
        setupImageViews();

        soundManager = new SoundManager();
        soundManager = MyApplication.getSoundManager(getApplicationContext());


        bRollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll();


            }
        });

        bEndGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                endgame();
            }
        });

        sSmiley = getSmiley(unicde);
        hintdialog = new Dialog(this);
        Button bHint = (Button) findViewById(R.id.hint);
        bHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hintdialog.setContentView(R.layout.pageinstruction);
                hintdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                hintdialog.show();
                displayMetrics = getResources().getDisplayMetrics();
                int displayWidth = displayMetrics.widthPixels;
                int displayHeight = displayMetrics.heightPixels;
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(hintdialog.getWindow().getAttributes());
                int dialogWindowWidth = (int) (displayWidth * 0.92f);
                int dialogWindowHeight = (int) (displayHeight * 0.92f);
                layoutParams.width = dialogWindowWidth;
                layoutParams.height = dialogWindowHeight;
                hintdialog.getWindow().setAttributes(layoutParams);
            }
        });
    }

    public String getSmiley(int unicde) {
        return new String(Character.toChars(unicde));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                navigateUpTo(new Intent(getBaseContext(), MainActivity.class));
                overridePendingTransition(R.anim.zoom_in, R.anim.static_anim);
                break;
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {

        navigateUpTo(new Intent(getBaseContext(), MainActivity.class));
        overridePendingTransition(R.anim.zoom_in, R.anim.static_anim);
    }

    private void oncChange() {

        actualVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        soundManager.setVolume(actualVolume);
    }

    private void endgame() {
        soundManager.autoPause();
        oncChange();
        soundManager.playSound(sEndgame);
        float d = (Float.valueOf(iCorrect) / Float.valueOf(iQ)) * 100;
        d /= 20;
        rtScoreBar.setRating(d);
        bRollButton.setVisibility(View.INVISIBLE);
        tAnsTextView.setVisibility(View.INVISIBLE);
        bEndGame.setVisibility(View.INVISIBLE);
        rtScoreBar.setVisibility(View.VISIBLE);
        tButtonLabel.setText("");
        eResultNumber.setVisibility(View.INVISIBLE);
        iRedDice.setVisibility(View.INVISIBLE);
        findViewById(R.id.smiley).setVisibility(View.INVISIBLE);
        iYellowDice.setVisibility(View.INVISIBLE);
        if (diceConstants.getNUMDICE() > 2) {
            iGreenDice.setVisibility(View.INVISIBLE);
        }
    }

    private void setupImageViews() {
        iRedDice = findViewById(R.id.redimageView);
        iYellowDice = findViewById(R.id.yellowimageView);


        diceViews[0] = iRedDice;
        diceViews[1] = iYellowDice;
        if (diceConstants.getNUMDICE() > 2) {

            diceViews[2] = iGreenDice;
        }
    }

    private int getDrawableDiceId(int number) {
        String name = "dice" + number;


        return getResources().getIdentifier(name, "drawable", getPackageName());
    }

    private void changeDiceImages() {
        int number = 0;
        for (int i = 0; i < diceConstants.getNUMDICE(); i++) {

            diceViews[i].setImageResource(getDrawableDiceId(
                    diceRoller.getDice()[i].getDieResult()
            ));

            number = diceRoller.getDice()[i].getDieResult();
            if (number >= 1 && number <= 9) {
                inumber[i] = -number;
            } else if (number >= 10 && number <= 18) {
                inumber[i] = number - 9;
            } else if (number >= 19 && number <= 27) {
                inumber[i] = -(number - (2 * 9));
            }
        }
    }

    private void roll() {
        oncChange();
        soundManager.autoPause();
        soundManager.playSound(sRoll);
        iReddicenumber = 0;
        iGreendicenumber = 0;
        iYellowdicenumber = 0;
        eResultNumber.setEnabled(true);
        bEndGame.setVisibility(View.INVISIBLE);
        eResultNumber.setVisibility(View.VISIBLE);
        findViewById(R.id.smiley).setVisibility(View.INVISIBLE);
        findViewById(R.id.roll).setVisibility(View.VISIBLE);
        tAnsTextView.setText("");
        eResultNumber.setText("");
        iQ++;
        siQ = String.valueOf(iQ);
        tNumberofQuestions.setText(siQ);

        if (sLevel.equalsIgnoreCase("Hard")) {
            diceRoller.rollDiceHard();
        } else {
            diceRoller.rollDiceEasy();
        }

        changeDiceImages();


        bRollButton.setVisibility(View.INVISIBLE);
        tButtonLabel.setText("");
        bCheckAnswer.setVisibility(View.VISIBLE);

    }

    public void addnumber(View v) {

        oncChange();
        Intent iActionMessage = getIntent();
        sAction = iActionMessage.getStringExtra("Action");
        if (eResultNumber.getText().toString().equals("")) {
            if (inumber[0] != 0 && inumber[1] != 0 && inumber[2] != 0) {
                tAnsTextView.setText("Please Enter Answer");
            } else {
                tAnsTextView.setText("Please Roll the Dice");
            }
        } else {
            if (sAction.equals("Addition")) {
                if (diceConstants.getNUMDICE() == 3) {
                    iresultnumber = (inumber[0]) + (inumber[1]) + (inumber[2]);
                } else {
                    iresultnumber = (inumber[0]) + (inumber[1]);
                }
            } else {
                if (diceConstants.getNUMDICE() == 3) {
                    iresultnumber = (inumber[0]) - (inumber[1]) - (inumber[2]);
                } else {
                    iresultnumber = (inumber[0]) - (inumber[1]);
                }

            }
            dEnteredResult = Double.parseDouble(eResultNumber.getText().toString());

            if (iresultnumber == dEnteredResult) {
                iCorrect++;
                soundManager.autoPause();

                soundManager.playSound(sCorrectAnser);
                str = "CORRECT ANSWER ";
                SpannableString ss1 = new SpannableString("CORRECT ANSWER ");
               // ss1.setSpan(new RelativeSizeSpan(3f), 15, str.length(), 0);
                findViewById(R.id.smiley).setVisibility(View.VISIBLE);
                tAnsTextView.setText(ss1);
            } else {
                soundManager.autoPause();
                soundManager.playSound(sWrongAnswer);

                SpannableString ss1 = new SpannableString("OH NO! THE CORRECT ANSWER IS " + (int) iresultnumber);
                str = "OH NO! THE CORRECT ANSWER IS " + (int) iresultnumber;
                StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
                ss1.setSpan(new RelativeSizeSpan(1.3f), 29, str.length(), 0); // set size
                ss1.setSpan(new ForegroundColorSpan(Color.RED), 29, str.length(), 0);// set color
                ss1.setSpan(boldSpan, 29, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                tAnsTextView.setText(ss1);
            }
            bRollButton.setVisibility(View.VISIBLE);
            tButtonLabel.setText("Roll Dice");
            eResultNumber.setEnabled(false);
            bCheckAnswer.setVisibility(View.INVISIBLE);
            bEndGame.setVisibility(View.VISIBLE);

        }

    }


    @Override
    protected void onStop() {
        soundManager.autoPause();
        super.onStop();
    }


    @Override
    protected void onResume() {
        // Log.i(TAG, "**OnReusme******");
        soundManager = new SoundManager();
        soundManager = MyApplication.getSoundManager(getApplicationContext());
        super.onResume();
    }

    @Override
    protected void onPause() {
        soundManager.release();
        //  Log.i(TAG, "**onPause******");
        super.onPause();
    }
}