package com.example.educationalinstitutemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TeacherPannel_main extends AppCompatActivity {

    private TextView b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_pannel_main);
        b1=findViewById(R.id.textView11);
        b2=findViewById(R.id.textView121);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(TeacherPannel_main.this,Put_Result.class);
                startActivity(in);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bb=getIntent().getExtras();
                String ss=bb.getString("NAME");

                Intent in=new Intent(TeacherPannel_main.this,Put_notice.class);
                in.putExtra("NAME",ss);
                startActivity(in);
            }
        });


    }

    public  void ShowS(View view)
    {
        Intent ii=new Intent(TeacherPannel_main.this,ID_show.class);
        ii.putExtra("K_id","Student");
        startActivity(ii);
    }

    public  void Notice(View view)
    {
        Intent ii=new Intent(TeacherPannel_main.this,Show_notice.class);
        startActivity(ii);
    }


    public  void Result1(View view)
    {
        Intent ii=new Intent(TeacherPannel_main.this,Result_show_T.class);
        startActivity(ii);
    }


    public  void STChat(View view)
    {
        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("NAME");
        Intent ii=new Intent(TeacherPannel_main.this,Chat_combiner_stMain.class);
        ii.putExtra("NAME",ss);
        startActivity(ii);
    }





}