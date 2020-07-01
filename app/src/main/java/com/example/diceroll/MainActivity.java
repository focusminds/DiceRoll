package com.example.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button bRollButton ;
    TextView tTextView1,tGreenTextView,tYellowTextView,tAnsTextView;
    ImageView iRedDice,iGreenDice,iYellowDice;
    EditText eResultNumber;
    double iReddicenumber =0;
    double iGreendicenumber =0;
    double iYellowdicenumber =0;
    double iresultnumber = 0;
    double dEnteredResult = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bRollButton = findViewById(R.id.rollbutton);
        tTextView1 = findViewById(R.id.resulttextView);
        tGreenTextView = findViewById(R.id.greenresulttextView);
        tYellowTextView = findViewById(R.id.yellowresulttextView);
        tAnsTextView = findViewById(R.id.answerstatus);

        iRedDice = findViewById(R.id.redimageView);
        iGreenDice = findViewById(R.id.greenimageView);
        iYellowDice = findViewById(R.id.yellowimageView);

        eResultNumber = findViewById(R.id.signedresultnumber);
        bRollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll();
            }
        });

    }

    private void roll() {
        tAnsTextView.setText("");
        eResultNumber.setText("");
        int rollnumber = (int)(Math.random() * 6 + 1);
        switch (rollnumber) {
            case 1:
                tTextView1.setText("1");
                iRedDice.setImageResource(R.drawable.reddice1);
                iReddicenumber =1;
            //    Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                tTextView1.setText("2");
                iRedDice.setImageResource(R.drawable.reddice2);
                iReddicenumber =2;
              //  Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                tTextView1.setText("3");
                iRedDice.setImageResource(R.drawable.reddice3);
                iReddicenumber =3;
                //Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                tTextView1.setText("4");
                iRedDice.setImageResource(R.drawable.reddice4);
                iReddicenumber =4;
                //Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                tTextView1.setText("5");
                iRedDice.setImageResource(R.drawable.reddice5);
                iReddicenumber =5;
                //Toast.makeText(getApplicationContext(),"5",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                tTextView1.setText("6");
                iRedDice.setImageResource(R.drawable.reddice6);
                iReddicenumber =6;
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                break;
        }

        int greennumber = (int)(Math.random() * 6 + 1);
        switch (greennumber) {
            case 1:
                tGreenTextView.setText("1");
                iGreenDice.setImageResource(R.drawable.greendice1);
                iGreendicenumber =1;
                //Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                tGreenTextView.setText("2");
                iGreenDice.setImageResource(R.drawable.greendice2);
                iGreendicenumber=2;
                //Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                tGreenTextView.setText("3");
                iGreenDice.setImageResource(R.drawable.greendice3);
                iGreendicenumber=3;
                //Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                tGreenTextView.setText("4");
                iGreenDice.setImageResource(R.drawable.greendice4);
                iGreendicenumber=4;
                //Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                tGreenTextView.setText("5");
                iGreenDice.setImageResource(R.drawable.greendice5);
                iGreendicenumber=5;
                //Toast.makeText(getApplicationContext(),"5",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                tGreenTextView.setText("6");
                iGreenDice.setImageResource(R.drawable.greendice6);
                iGreendicenumber=6;
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                break;
        }


        int yellownumber = (int)(Math.random() * 6 + 1);
        switch (yellownumber) {
            case 1:
                tYellowTextView.setText("1");
                iYellowDice.setImageResource(R.drawable.yellowdice1);
                iYellowdicenumber=-1;
                //Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                tYellowTextView.setText("2");
                iYellowDice.setImageResource(R.drawable.yellowdice2);
                //Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=-2;
                break;
            case 3:
                tYellowTextView.setText("3");
                iYellowDice.setImageResource(R.drawable.yellowdice3);
                //Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=-3;
                break;
            case 4:
                tYellowTextView.setText("4");
                iYellowDice.setImageResource(R.drawable.yellowdice4);
                //Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=-4;
                break;
            case 5:
                tYellowTextView.setText("5");
                iYellowDice.setImageResource(R.drawable.yellowdice5);
                //Toast.makeText(getApplicationContext(),"5",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=-5;
                break;
            case 6:
                tYellowTextView.setText("6");
                iYellowDice.setImageResource(R.drawable.yellowdice6);
                //Toast.makeText(getApplicationContext(),"6",Toast.LENGTH_SHORT).show();
                iYellowdicenumber=-6;
                break;
        }

    }

    public void addnumber(View v) {
        iresultnumber = iReddicenumber + iGreendicenumber + iYellowdicenumber;
        dEnteredResult = Double.parseDouble(eResultNumber.getText().toString());

        if(iresultnumber == dEnteredResult) {
            tAnsTextView.setText("Correct Answer");
        } else {
            tAnsTextView.setText("Wrong Answer");
        }

    }
}