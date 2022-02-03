package com.mobile.exercisetimer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SignupActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private TextView userN;
    private TextView passW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        userN = findViewById(R.id.login_user);
        passW = findViewById(R.id.login_password);
        Button registerButton = findViewById(R.id.login);
        mDatabase = FirebaseDatabase.getInstance().getReference();


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }
    private void registerUser(){
        String userName = userN.getText().toString();
        String passWord = passW.getText().toString();

        User user = new User(userName, passWord);


        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data: snapshot.getChildren()){
                    // User exist
                    if (data.child(userName.toLowerCase()).exists()){
                        Toast.makeText(getApplicationContext(), "Username is already taken", Toast.LENGTH_SHORT).show();
                    }
                    // User not exist
                    else{
                        mDatabase.child("users").child(userName.toLowerCase()).setValue(user);
                        Toast.makeText(getApplicationContext(), "Account created successfully", Toast.LENGTH_SHORT).show();
                    }
                };
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        userN.setText("");
        passW.setText("");
    }


}

