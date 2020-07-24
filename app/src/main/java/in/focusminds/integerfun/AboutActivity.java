package in.focusminds.integerfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import in.focusminds.integerfun.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}