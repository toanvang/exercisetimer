package com.mobile.exercisetimer;

import android.os.Bundle;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {
    ToggleButton countdownBtn;
    ToggleButton halfwayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        countdownBtn = findViewById(R.id.countdown5_btn);
        countdownBtn.setChecked(Setting.getInstance().isCountdownSoundEnabled());
        countdownBtn.setOnCheckedChangeListener((compoundButton, checked) -> Setting.getInstance().setEnableCountdownSound(checked));
        halfwayBtn = findViewById(R.id.halfway_btn);
        halfwayBtn.setChecked(Setting.getInstance().isHalfwaySoundEnabled());
        halfwayBtn.setOnCheckedChangeListener((compoundButton, checked) -> Setting.getInstance().setEnableHalfwaySound(checked));
    }
}