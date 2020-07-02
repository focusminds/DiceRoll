package com.example.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button bAddition;
    Button bSbtraction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAddition = findViewById(R.id.addition);
        bSbtraction = findViewById(R.id.subtraction);

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
    }

}