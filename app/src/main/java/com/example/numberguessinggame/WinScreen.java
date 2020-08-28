package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WinScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);

        Intent receivedIntent = getIntent();
        int numGuesses = receivedIntent.getIntExtra("numGuesses", -1);

        TextView numGuessesBox = findViewById(R.id.numGuessesBox);
        numGuessesBox.setText(getString(R.string.it_took_guesses, numGuesses));
    }
}