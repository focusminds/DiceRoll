package in.focusminds.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.diceroll.R;

public class MainActivity extends AppCompatActivity {
    Button bAddition;
    Button bSbtraction,bInstruction,bAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAddition = findViewById(R.id.addition);
        bSbtraction = findViewById(R.id.subtraction);
        bInstruction = findViewById(R.id.instruction);

        bAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iAdditionIntent = new Intent(MainActivity.this,AdditionActivity.class);
                iAdditionIntent.putExtra("Action","Addition");
                startActivity(iAdditionIntent);


            }
        });

        bSbtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iSubtractionIntent = new Intent(MainActivity.this,AdditionActivity.class);
                iSubtractionIntent.putExtra("Action","Subtraction");
                startActivity(iSubtractionIntent);


            }
        });

        bInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iInstructionIntent = new Intent(MainActivity.this,InstructionActivty.class);
                startActivity(iInstructionIntent);

            }
        });

        bAbout = findViewById(R.id.about);
        bAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iAbout = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(iAbout);
            }
        });
    }

}