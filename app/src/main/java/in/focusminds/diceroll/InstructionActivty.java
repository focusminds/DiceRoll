package in.focusminds.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import in.focusminds.diceroll.R;

public class InstructionActivty extends AppCompatActivity {

    Button bBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_activty);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}