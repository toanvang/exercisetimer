package com.mobile.exercisetimer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class SignupActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);




        Button registerButton = findViewById(R.id.register);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User("aaa");
                mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
                mDatabase.push().setValue("sfdsdfsdfs");
//                rootNode = FirebaseDatabase.getInstance();
//                reference = rootNode.getReference("Users");
//                reference.setValue(user);
//                mDatabase.child("users").child("USERS12345").setValue(user);
//                Toast.makeText(getApplicationContext(), "Account created successfully", Toast.LENGTH_SHORT).show();
            }
        });



    }


}

