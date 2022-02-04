package com.mobile.exercisetimer;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<String> data1, data2, data3;
    Context context;
    public MyAdapter(Context ct, List<String> s1, List<String> s2, List<String> s3){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        // store the inflater into view
        View view = inflater.inflate(R.layout.row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText("Date: " + data1.get(position));
        holder.text2.setText("Exercise Time: " + data2.get(position) + " minutes");
        holder.text3.setText("Rest Time: " + data3.get(position) + " minutes");
    }

    @Override
    public int getItemCount() {
        return data3.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text1, text2, text3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.date);
            text2 = itemView.findViewById(R.id.extime);
            text3 = itemView.findViewById(R.id.retime);
        }
    }
}
