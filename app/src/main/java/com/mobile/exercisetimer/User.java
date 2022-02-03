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
    private List<String> historyExercise;
    private List<String> historyRest;
    private List<String> historyDate;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener;
    private static User globalUser = null;
    public User() {

    }

    public User(String username, String password){
        this.userName = username;
        this.passWord = password;
        this.historyExercise = new ArrayList<>();
        this.historyDate = new ArrayList<>();
        this.historyRest = new ArrayList<>();
        historyDate.add("05/04/1994");
        historyExercise.add("10 mins");
        historyRest.add("5 mins");

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

    public List<String> getHistoryExercise() {
        return this.historyExercise;
    }

    public List<String> getHistoryRest() {
        return this.historyRest;
    }
    public List<String> getHistoryDate() {
        return this.historyDate;
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
        historyExercise.clear();
        historyDate.clear();
        historyRest.clear();
        for (DataSnapshot when : userData.child("historyExercise").getChildren()) {
            historyExercise.add(when.getValue(String.class));
        }
        for (DataSnapshot when : userData.child("historyRest").getChildren()) {
            historyRest.add(when.getValue(String.class));
        }
        for (DataSnapshot when : userData.child("historyDate").getChildren()) {
            historyDate.add(when.getValue(String.class));
        }
        Log.d("TAG", "loaded data from Firebase: " + toString());
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
