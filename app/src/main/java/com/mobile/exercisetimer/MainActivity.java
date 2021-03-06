package com.mobile.exercisetimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.startworkout:
                startActivity(new Intent(this, workoutActivity.class));
                break;
            case R.id.setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.signup_activity:
                startActivity(new Intent(this, SignupActivity.class));
                break;
            case R.id.login_button:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.summary:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
        }
    }
}