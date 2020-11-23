package in.focusminds.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.focusminds.diceroll.sound.MyApplication;
import in.focusminds.diceroll.sound.SoundManager;


public class MainActivity extends AppCompatActivity {
    private  static final String TAG = "MainActivity";
    Button bAddition;
    Button bSbtraction,bInstruction,bAbout;
    public SoundManager soundManager;
    int buttonClick = R.raw.button;
    float actualVolume;

    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //   Log.i(TAG,"**OnCreateTesting***");
       audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        soundManager = new SoundManager();
        soundManager = MyApplication.getSoundManager(getApplicationContext());

        bAddition = findViewById(R.id.addition);
        bSbtraction = findViewById(R.id.subtraction);
        bInstruction = findViewById(R.id.instruction);

        bAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onload();
                soundManager.playSound(buttonClick);
                Intent iAdditionIntent = new Intent(MainActivity.this,LevelSelection.class);
                iAdditionIntent.putExtra("Action","Addition");
                startActivity(iAdditionIntent);


            }
        });

        bSbtraction.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onload();
                soundManager.playSound(buttonClick);
                Intent iSubtractionIntent = new Intent(MainActivity.this,LevelSelection.class);
                iSubtractionIntent.putExtra("Action","Subtraction");
                startActivity(iSubtractionIntent);


            }
        });

        bInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onload();
                soundManager.playSound(buttonClick);
                Intent iInstructionIntent = new Intent(MainActivity.this,InstructionActivty.class);
                startActivity(iInstructionIntent);

            }
        });

        bAbout = findViewById(R.id.about);
        bAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onload();
                soundManager.playSound(buttonClick);
                Intent iAbout = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(iAbout);
            }
        });



    }

    private void onload() {

        actualVolume= (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        soundManager.setVolume(actualVolume);
    }


    @Override
    protected void onStop() {
        soundManager.autoPause();
        super.onStop();
    }


    @Override
    protected void onDestroy() {
      //  Log.i(TAG,"**onDestroy******");
        soundManager.release();
        super.onDestroy();
    }
}