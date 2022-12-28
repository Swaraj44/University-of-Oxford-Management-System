package com.example.educationalinstitutemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class welcome1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);



        Handler handler=new Handler();           //used to update the main thread from background thread or other than main thread.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent=new Intent(welcome1.this,MainActivity2.class);
                startActivity(homeintent);

                finish();
                //this is used for not to back in this activity;

            }
        },2000);

    }
}