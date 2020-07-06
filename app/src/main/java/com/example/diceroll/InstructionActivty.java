package com.example.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InstructionActivty extends AppCompatActivity {

    Button bBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_activty);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}