package in.focusminds.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import in.focusminds.diceroll.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}