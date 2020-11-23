package in.focusminds.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import in.focusminds.diceroll.sound.MyApplication;
import in.focusminds.diceroll.sound.SoundManager;


public class LevelSelection extends AppCompatActivity {
  //  private  static final String TAG = "LevelSelection";
     Button beasy,bhard;
    AudioManager audioManager;
    float actualVolume;
    String sLabel ="";
    public SoundManager soundManager;
    int buttonClick = R.raw.button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        Intent iLabelMessage = getIntent();
        sLabel = iLabelMessage.getStringExtra("Action");

          beasy = (Button) findViewById(R.id.beasy);
        bhard = (Button) findViewById(R.id.bhard);

        soundManager = new SoundManager();
        soundManager = MyApplication.getSoundManager(getApplicationContext());
        onload();
        beasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oncChange();
                soundManager.playSound(buttonClick);
                Intent ieasy = new Intent(LevelSelection.this,AdditionActivity.class);
                ieasy.putExtra("Action",sLabel);
                ieasy.putExtra("Level","Medium");
                startActivity(ieasy);
            }
        });

        bhard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oncChange();
                soundManager.playSound(buttonClick);
                Intent ihard = new Intent(LevelSelection.this,AdditionActivity.class);
                ihard.putExtra("Action",sLabel);
                ihard.putExtra("Level","Hard");
                startActivity(ihard);
            }
        });


    }

    private void oncChange() {

        actualVolume= (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        soundManager.setVolume(actualVolume);
    }

    private void onload() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fadre);

        Animation animationrev = AnimationUtils.loadAnimation(this, R.anim.blinkrev);
        beasy.startAnimation(animationrev);
        bhard.startAnimation(animation);
    }




}