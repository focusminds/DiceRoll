package in.focusminds.integerfun;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import in.focusminds.integerfun.R;

public class AdditionActivity extends AppCompatActivity {

    private DiceRoller diceRoller;
    ImageView[] diceViews;
    int[] inumber = new int[3];
    Button bRollButton,bCheckAnswer,bEndGame,bBack ;
    TextView tTextView1,tGreenTextView,tYellowTextView,tAnsTextView,tNumberofQuestions,tButtonLabel;
    ImageView iRedDice,iGreenDice,iYellowDice,imAction;
    EditText eResultNumber;
    RatingBar rtScoreBar;
    double iReddicenumber =0;
    double iGreendicenumber =0;
    double iYellowdicenumber =0;
    double iresultnumber = 0;
    double dEnteredResult = 0;
    String sAction = "";
    String sLabel = "";

    int iQ = 0;
    int iCorrect = 0;
    String siQ = "";
    public MediaPlayer mpendgame ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent iLabelMessage = getIntent();
        sLabel = iLabelMessage.getStringExtra("Action");

        super.onCreate(savedInstanceState);
        setTitle(sLabel);
        setContentView(R.layout.activity_addition);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bRollButton = findViewById(R.id.rollbutton);
        bCheckAnswer = findViewById(R.id.checkanwer);
        bEndGame =  findViewById(R.id.endgame);

        bCheckAnswer.setVisibility(View.INVISIBLE);

        bEndGame.setVisibility(View.INVISIBLE);

        tAnsTextView = findViewById(R.id.answerstatus);
        tNumberofQuestions = findViewById(R.id.numberofquestions);
        tButtonLabel  = findViewById(R.id.buttonlabel);

        eResultNumber = findViewById(R.id.signedresultnumber);
        rtScoreBar = findViewById(R.id.ratingBar);

        tButtonLabel.setText("Roll Dice");

        diceViews = new ImageView[DiceConstants.NUM_DICE];

        diceRoller = new DiceRoller();
        setupImageViews();


        final MediaPlayer mpRoll = MediaPlayer.create(this, R.raw.shake_dice);
        mpendgame = MediaPlayer.create(this, R.raw.endgame);

        bRollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mpRoll.start();
                roll();
            }
        });

        bEndGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mpendgame.start();

                endgame();
            }
        });


    }



    @Override
    public void onBackPressed() {
        if (mpendgame.isPlaying()) {
            mpendgame.stop();
            mpendgame.release();
        }
        super.onBackPressed();
    }

    private void endgame() {

        float d = (Float.valueOf(iCorrect) / Float.valueOf(iQ))* 100 ;
        d /= 20;
        rtScoreBar.setRating(d);
        bRollButton.setVisibility(View.INVISIBLE);
        tAnsTextView.setVisibility(View.INVISIBLE);
        bEndGame.setVisibility(View.INVISIBLE);
        rtScoreBar.setVisibility(View.VISIBLE);
        tButtonLabel.setText("");
        eResultNumber.setVisibility(View.INVISIBLE);
        //bBack.setVisibility(View.VISIBLE);

    }

    private void setupImageViews() {
        iRedDice = findViewById(R.id.redimageView);
        iGreenDice = findViewById(R.id.greenimageView);
        iYellowDice = findViewById(R.id.yellowimageView);

        diceViews[0] = iRedDice;
        diceViews[1] = iYellowDice;
        diceViews[2] = iGreenDice;

    }

    private int getDrawableDiceId(int number) {
        String name = "dice" + number;


        return getResources().getIdentifier(name, "drawable", getPackageName());
    }

    private void changeDiceImages() {
        int number =0;
        for(int i = 0; i < DiceConstants.NUM_DICE; i++) {

            diceViews[i].setImageResource(getDrawableDiceId(
                    diceRoller.getDice()[i].getDieResult()
            ));

            number = diceRoller.getDice()[i].getDieResult();
            if(number >=1 && number<=9) {
                inumber[i] = -number;
            } else if(number >= 10 && number <= 18) {
                inumber[i] = number-9;
            } else if(number >= 19 && number <= 27) {
                inumber[i] = -(number-(2*9));
            }
        }
    }

    private void roll() {
        iReddicenumber =0;
        iGreendicenumber =0;
         iYellowdicenumber =0;
        eResultNumber.setEnabled(true);
        bEndGame.setVisibility(View.INVISIBLE);
        eResultNumber.setVisibility(View.VISIBLE);
        tAnsTextView.setText("");
        eResultNumber.setText("");
        iQ++;
        siQ = String.valueOf(iQ);
        tNumberofQuestions.setText(siQ);

        diceRoller.rollDice();
        changeDiceImages();


        bRollButton.setVisibility(View.INVISIBLE);
        tButtonLabel.setText("");
        bCheckAnswer.setVisibility(View.VISIBLE);

    }

    public void addnumber(View v) {
        final MediaPlayer mpCorrectAnswer = MediaPlayer.create(this, R.raw.cheers);
        final MediaPlayer mpWrngAnswer = MediaPlayer.create(this, R.raw.ohno);
        Intent iActionMessage = getIntent();
        sAction = iActionMessage.getStringExtra("Action");
        if (eResultNumber.getText().toString().equals("")) {
            if(iReddicenumber != 0 && iReddicenumber != 0 && iReddicenumber != 0) {
                tAnsTextView.setText("Please Enter Answer");
            } else{
                tAnsTextView.setText("Please Roll the Dice");
            }
        } else {
            if(sAction.equals("Addition")) {
                iresultnumber = ( inumber[0]) + ( inumber[1]) + ( inumber[2]);
            } else {
                iresultnumber = ( inumber[0]) - (inumber[1]) - (inumber[2]);;
            }
            dEnteredResult = Double.parseDouble(eResultNumber.getText().toString());

            if (iresultnumber == dEnteredResult) {
                iCorrect++;
                mpCorrectAnswer.start();
                tAnsTextView.setText("Correct Answer");
            } else {
                mpWrngAnswer.start();
                tAnsTextView.setText("oh no! The Correct Answer is " +(int)iresultnumber);
            }
            bRollButton.setVisibility(View.VISIBLE);
            tButtonLabel.setText("Roll Dice");
            eResultNumber.setEnabled(false);
            bCheckAnswer.setVisibility(View.INVISIBLE);
            bEndGame.setVisibility(View.VISIBLE);

        }

    }


}