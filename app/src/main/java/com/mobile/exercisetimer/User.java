package com.mobile.exercisetimer;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;

    public User(String username){
        this.userName = username;
    }

    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }


}
