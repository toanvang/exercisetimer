package com.mobile.exercisetimer;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<String> s1, s2, s3;
    TypedArray images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView = findViewById(R.id.recyclerView);

        //images.recycle();

        if (User.getGlobalUser() == null) {
            Toast.makeText(getApplicationContext(), "Please log in to keep track of your history", Toast.LENGTH_SHORT).show();
            return;
        }
        s1 = User.getGlobalUser().getHistoryDate();
        s2 = User.getGlobalUser().getHistoryExercise();
        s3 = User.getGlobalUser().getHistoryRest();

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, s3);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
