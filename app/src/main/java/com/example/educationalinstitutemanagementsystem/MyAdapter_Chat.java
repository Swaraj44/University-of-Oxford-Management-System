package com.example.educationalinstitutemanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter_Chat extends RecyclerView.Adapter<MyAdapter_Chat.MyViewHolder> {

    ArrayList<Model_chat> mList;
    Context context;

    public MyAdapter_Chat (Context context , ArrayList<Model_chat> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_chat , parent ,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model_chat model1 = mList.get(position);
        holder.date.setText(model1.getDate());
        holder.publisher.setText(model1.getPublisher());
        holder.chat.setText(model1.getMessage());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView date,publisher,chat;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date= itemView.findViewById(R.id.date_chat);
            publisher = itemView.findViewById(R.id.publisher_chat);
            chat= itemView.findViewById(R.id.comment_chat);
        }
    }
}