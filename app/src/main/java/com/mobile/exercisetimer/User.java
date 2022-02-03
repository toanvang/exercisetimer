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
    private String passWord;
    private List<String> history;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener;
    private static User globalUser = null;
    public User() {

    }

    public User(String username, String password){
        this.userName = username;
        this.passWord = password;
        this.history = new ArrayList<>();
        this.history.add("a");
        this.history.add("b");
        this.history.add("c");
        this.history.add("d");
    }

    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassWord() {
        return this.passWord;
    }
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    public List<String> getHistory() {
        return history;
    }

    public static synchronized User getGlobalUser() {
        return globalUser;
    }

    public static synchronized void setGlobalUser(User user) {
        if (globalUser == user) {
            return;
        }
        globalUser = user;
    }




    private void loadFrom(DataSnapshot userData) {
        history.clear();
        for (DataSnapshot when : userData.child("passWord").getChildren()) {
            history.add(when.getValue(String.class));
        }

        Log.d("loaded", "loaded data from Firebase: " + toString());
    }

    public void syncWith(DataSnapshot userData) {
        loadFrom(userData);
        databaseReference = userData.getRef();
        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                loadFrom(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void unsync() {
        databaseReference.removeEventListener(valueEventListener);
    }



}
