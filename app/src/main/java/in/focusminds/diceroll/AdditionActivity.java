package in.focusminds.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.diceroll.R;

public class AdditionActivity extends AppCompatActivity {

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
        //bBack = findViewById(R.id.back);
        bCheckAnswer.setVisibility(View.INVISIBLE);
       // bBack.setVisibility(View.INVISIBLE);
        bEndGame.setVisibility(View.INVISIBLE);

        // tTextView1 = findViewById(R.id.resulttextView);
        //tGreenTextView = findViewById(R.id.greenresulttextView);
        //tYellowTextView = findViewById(R.id.yellowresulttextView);
        tAnsTextView = findViewById(R.id.answerstatus);
        tNumberofQuestions = findViewById(R.id.numberofquestions);
        tButtonLabel  = findViewById(R.id.buttonlabel);
        iRedDice = findViewById(R.id.redimageView);
        iGreenDice = findViewById(R.id.greenimageView);
        iYellowDice = findViewById(R.id.yellowimageView);
        eResultNumber = findViewById(R.id.signedresultnumber);
        rtScoreBar = findViewById(R.id.ratingBar);

        tButtonLabel.setText("Roll Dice");

        final MediaPlayer mpRoll = MediaPlayer.create(this, R.raw.shake_dice);

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
                endgame();
            }
        });

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
        //bBack.setVisibility(View.VISIBLE);

    }

    private void roll() {
        eResultNumber.setEnabled(true);
        bEndGame.setVisibility(View.INVISIBLE);
        eResultNumber.setVisibility(View.VISIBLE);
        tAnsTextView.setText("");
        eResultNumber.setText("");
        iQ++;
        siQ = String.valueOf(iQ);
        tNumberofQuestions.setText(siQ);

        int rollnumber = (int)(Math.random() * 9 + 1);
        switch (rollnumber) {
            case 1:
                //tTextView1.setText("1");
                iRedDice.setImageResource(R.drawable.r1);
                iReddicenumber =1;
                //    Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                //tTextView1.setText("2");
                iRedDice.setImageResource(R.drawable.r2);
                iReddicenumber =2;
                //  Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                //tTextView1.setText("3");
                iRedDice.setImageResource(R.drawable.r3);
                iReddicenumber =3;
                //Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                //tTextView1.setText("4");
                iRedDice.setImageResource(R.drawable.r4);
                iReddicenumber =4;
                //Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                //tTextView1.setText("5");
                iRedDice.setImageResource(R.drawable.r5);
                iReddicenumber =5;
                //Toast.makeText(getApplicationContext(),"5",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                //tTextView1.setText("6");
                iRedDice.setImageResource(R.drawable.r6);
                iReddicenumber =6;
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                break;
            case 7:
                //tTextView1.setText("6");
                iRedDice.setImageResource(R.drawable.r7);
                iReddicenumber =7;
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                break;
            case 8:
                //tTextView1.setText("6");
                iRedDice.setImageResource(R.drawable.r8);
                iReddicenumber =8;
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                break;
            case 9:
                //tTextView1.setText("6");
                iRedDice.setImageResource(R.drawable.r9);
                iReddicenumber =9;
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                break;
        }

        int greennumber = (int)(Math.random() * 9 + 1);
        switch (greennumber) {
            case 1:
                //tGreenTextView.setText("1");
                iGreenDice.setImageResource(R.drawable.g1);
                iGreendicenumber =1;
                //Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                //tGreenTextView.setText("2");
                iGreenDice.setImageResource(R.drawable.g2);
                iGreendicenumber=2;
                //Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                //tGreenTextView.setText("3");
                iGreenDice.setImageResource(R.drawable.g3);
                iGreendicenumber=3;
                //Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                //tGreenTextView.setText("4");
                iGreenDice.setImageResource(R.drawable.g4);
                iGreendicenumber=4;
                //Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                //tGreenTextView.setText("5");
                iGreenDice.setImageResource(R.drawable.g5);
                iGreendicenumber=5;
                //Toast.makeText(getApplicationContext(),"5",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                //tGreenTextView.setText("6");
                iGreenDice.setImageResource(R.drawable.g6);
                iGreendicenumber=6;
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                break;
            case 7:
                //tGreenTextView.setText("6");
                iGreenDice.setImageResource(R.drawable.g7);
                iGreendicenumber=7;
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                break;
            case 8:
                //tGreenTextView.setText("6");
                iGreenDice.setImageResource(R.drawable.g8);
                iGreendicenumber=8;
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                break;
            case 9:
                //tGreenTextView.setText("6");
                iGreenDice.setImageResource(R.drawable.g9);
                iGreendicenumber=9;
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                break;
        }


        int yellownumber = (int)(Math.random() * 9 + 1);
        switch (yellownumber) {
            case 1:
                //tYellowTextView.setText("1");
                iYellowDice.setImageResource(R.drawable.y1);
                iYellowdicenumber=1;
                //Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                //tYellowTextView.setText("2");
                iYellowDice.setImageResource(R.drawable.y2);
                //Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=2;
                break;
            case 3:
                //tYellowTextView.setText("3");
                iYellowDice.setImageResource(R.drawable.y3);
                //Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=3;
                break;
            case 4:
                //tYellowTextView.setText("4");
                iYellowDice.setImageResource(R.drawable.y4);
                //Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=4;
                break;
            case 5:
                //tYellowTextView.setText("5");
                iYellowDice.setImageResource(R.drawable.y5);
                //Toast.makeText(getApplicationContext(),"5",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=5;
                break;
            case 6:
                //tYellowTextView.setText("6");
                iYellowDice.setImageResource(R.drawable.y6);
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=6;
                break;
            case 7:
                //tYellowTextView.setText("6");
                iYellowDice.setImageResource(R.drawable.y7);
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=7;
                break;
            case 8:
                //tYellowTextView.setText("6");
                iYellowDice.setImageResource(R.drawable.y8);
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=8;
                break;
            case 9:
                //tYellowTextView.setText("6");
                iYellowDice.setImageResource(R.drawable.y9);
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=9;
                break;
        }

        bRollButton.setVisibility(View.INVISIBLE);
        tButtonLabel.setText("");
        bCheckAnswer.setVisibility(View.VISIBLE);

    }

    public void addnumber(View v) {

        Intent iActionMessage = getIntent();
        sAction = iActionMessage.getStringExtra("Action");
        if (eResultNumber.getText().toString().equals("")) {
            if(iReddicenumber != 0) {
                tAnsTextView.setText("Please Enter Answer");
            } else{
                tAnsTextView.setText("Please Roll the Dice");
            }
        } else {
            if(sAction.equals("Addition")) {
                iresultnumber = (-iReddicenumber) + (iYellowdicenumber) + (-iGreendicenumber);
            } else {
                iresultnumber = (-iReddicenumber) - (iYellowdicenumber) - (-iGreendicenumber);;
            }
            dEnteredResult = Double.parseDouble(eResultNumber.getText().toString());

            if (iresultnumber == dEnteredResult) {
                iCorrect++;
                tAnsTextView.setText("Correct Answer");
            } else {
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