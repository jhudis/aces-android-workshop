package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int answer, numGuesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random generator = new Random();
        answer = generator.nextInt(100) + 1;
        numGuesses = 0;
    }

    public void makeGuess(View view) {
        numGuesses++;

        TextView inputBox = findViewById(R.id.inputBox);
        TextView promptBox = findViewById(R.id.promptBox);

        int input = Integer.parseInt(inputBox.getText().toString());

        String newPrompt;
        if (input < answer) {
            newPrompt = getString(R.string.higher);
        } else if (input > answer) {
            newPrompt = getString(R.string.lower);
        } else {
            newPrompt = getString(R.string.correct);

            Intent winScreenIntent = new Intent(this, WinScreen.class);
            winScreenIntent.putExtra("numGuesses", numGuesses);
            startActivity(winScreenIntent);
        }

        promptBox.setText(newPrompt);
    }
}