package com.linecorp.reviewexam.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.os.StrictMode.*;

public class RockPaperScissorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThreadPolicy(new ThreadPolicy.Builder().permitAll().build());
        setContentView(R.layout.rockpaperscissors_activity);
    }
}
