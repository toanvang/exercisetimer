package com.mobile.exercisetimer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {
    ToggleButton countdownBtn;
    ToggleButton halfwayBtn;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private SharedPreferences spGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sp = getSharedPreferences("setting", Context.MODE_PRIVATE);
        editor = sp.edit();
        spGet = getApplicationContext().getSharedPreferences("setting", Context.MODE_PRIVATE);


        countdownBtn = findViewById(R.id.countdown5_btn);
        countdownBtn.setChecked(spGet.getBoolean("countdown", Setting.getInstance().isCountdownSoundEnabled()));
//        countdownBtn.setOnCheckedChangeListener((compoundButton, unchecked) -> Setting.getInstance().setDisableCountdownSound(unchecked));
        countdownBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    // if toggle button is enabled/on
                    Setting.getInstance().setEnableCountdownSound(true);
                    editor.putBoolean("countdown", true);
                    editor.commit();
                }
                else{
                    Setting.getInstance().setEnableCountdownSound(false);
                    editor.putBoolean("countdown", false);
                    editor.commit();
                }

            }
        });

        halfwayBtn = findViewById(R.id.halfway_btn);
        halfwayBtn.setChecked(spGet.getBoolean("halfway", Setting.getInstance().isHalfwaySoundEnabled()));
//        halfwayBtn.setOnCheckedChangeListener((compoundButton, unchecked) -> Setting.getInstance().setDisableHalfwaySound(unchecked));
        halfwayBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    // if toggle button is enabled/on
                    Setting.getInstance().setEnableHalfwaySound(true);
                    editor.putBoolean("halfway", true);
                    editor.commit();
                }
                else{
                    Setting.getInstance().setEnableHalfwaySound(false);
                    editor.putBoolean("halfway", false);
                    editor.commit();
                }


            }
        });
    }
}