package com.mobile.exercisetimer;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class runTimer extends AppCompatActivity {
    private TextView countdownText;
    private Button countdownButton;
    private CountDownTimer countDownTimer;
    private TextView exerciseStatus ;
    private long timeLeftInMillisecounds; //600000=10mins
    private boolean timeRunning;
    private Button homeButton;
    private String totalET;
    private String totalRT;
    private long lngrest;
    private long lngbreak;
    private long lng;
    private boolean halfwayDone;
    private boolean countdownStarted;
    private int ET;
    private int RT;
    private int BT;
    private int set;
    private int round;
    private int original_round;
    private Intent i;
    MediaPlayer countdownSoundPlayer;
    MediaPlayer halfwaySoundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_timer);
        countdownText = findViewById(R.id.countdown_text);
        countdownButton = findViewById(R.id.countdown_button);
        homeButton = findViewById(R.id.home_button);
        exerciseStatus = findViewById(R.id.exercise_status);
        halfwayDone = false;
        countdownStarted = false;


        Intent data = getIntent();
        totalET = data.getStringExtra("totalET");
        totalRT = data.getStringExtra("totalRT");
        ET = data.getIntExtra("ET", 0);
        RT = data.getIntExtra("RT",0);
        BT = data.getIntExtra("BT", 0);
        set = data.getIntExtra("set",1);
        original_round = data.getIntExtra("round",1);
        round = original_round;
        lng = Long.valueOf(ET).longValue();
        lngrest = Long.valueOf(RT).longValue();
        lngbreak = Long.valueOf(BT).longValue();
        timeLeftInMillisecounds = lng * 1000 + 1000;
        Log.d("BT", String.valueOf(BT));
        Log.d("ET", String.valueOf(ET));
        Log.d("RT", String.valueOf(RT));
        countdownSoundPlayer = MediaPlayer.create(getApplicationContext(), R.raw.countdown5);
        halfwaySoundPlayer = MediaPlayer.create(getApplicationContext(), R.raw.halfway);

        startStop();

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(runTimer.this, MainActivity.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countDownTimer.cancel();
    }

    public void startStop(){
        if (timeRunning){
            stopTimer();
        } else {
            startTimer();
        }
    }
    public void startTimer(){

        countDownTimer = new CountDownTimer(timeLeftInMillisecounds, 1000) {

            @Override
            // l contains remaining time for countDownTimer
            // everytime pass in, update timeLeftInMillisecounds to timeLeft of this timer
            public void onTick(long l) {
                timeLeftInMillisecounds = l;

                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        countdownButton.setText("PAUSE");
        timeRunning = true;
    }
    public void stopTimer(){
        countDownTimer.cancel();
        countdownButton.setText("RESUME");
        timeRunning = false;
    }



    public void updateTimer(){
        int minutes = (int)timeLeftInMillisecounds / 60000; // divided 60 seconds
        int seconds = (int)timeLeftInMillisecounds % 60000 / 1000;
        String timeLeftText = "" + minutes;
        timeLeftText += ":";
        if (seconds < 10){
            timeLeftText += "0";
        }
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);

        final long totalTimeInMilliseconds = timeLeftInMillisecounds;


        if (timeLeftInMillisecounds <= 6000 && !countdownStarted && Setting.getInstance().isCountdownSoundEnabled()) {
            countdownSoundPlayer.start();
            countdownStarted = true;
        }

        if (exerciseStatus.getText().equals("Exercise")) {
            if (timeLeftInMillisecounds <= (lng * 1000 /2) +1000 && !halfwayDone && Setting.getInstance().isHalfwaySoundEnabled()) {
                halfwayDone = true;
                halfwaySoundPlayer.start();
            }
        }
        else if (exerciseStatus.getText().equals("Rest")) {
            if (timeLeftInMillisecounds <= (lngrest * 1000/2) +1000&& !halfwayDone && Setting.getInstance().isHalfwaySoundEnabled()) {
                halfwayDone = true;
                halfwaySoundPlayer.start();
            }
        }
        if (exerciseStatus.getText().equals("Break")) {
            if (timeLeftInMillisecounds <= (lngbreak * 1000/ 2)  +1000 && !halfwayDone && Setting.getInstance().isHalfwaySoundEnabled()) {
                halfwayDone = true;
                halfwaySoundPlayer.start();

            }
        }




        if(timeLeftInMillisecounds < 1000) {
            halfwayDone = false;
            countdownStarted = false;
            if (exerciseStatus.getText().equals("Exercise")) {
                if (round > 1 ) {
                    round = round - 1;
                    timeLeftInMillisecounds = lngrest * 1000 + 1000;
                    startTimer();
                    exerciseStatus.setText("Rest");
                }
                else if (round == 1 ) {
                    if (set > 1){
                        set = set - 1;
                        timeLeftInMillisecounds = lngbreak * 1000 + 1000;
                        startTimer();
                        exerciseStatus.setText("Break");
                    }
                    else if (set == 1){
                        exerciseStatus.setText("Congratulations, Exercise Finished");
                        countdownButton.setVisibility(View.INVISIBLE);
                        homeButton.setVisibility(View.VISIBLE);
                    }
                }
            }
            else if (exerciseStatus.getText().equals("Rest")) {
                timeLeftInMillisecounds = lng * 1000 + 1000 ;
                startTimer();
                exerciseStatus.setText("Exercise");
            }
            else if (exerciseStatus.getText().equals("Break")){
                round = original_round;
                timeLeftInMillisecounds = lng * 1000 + 1000;
                startTimer();
                exerciseStatus.setText("Exercise");
            }
        }
    }
}
