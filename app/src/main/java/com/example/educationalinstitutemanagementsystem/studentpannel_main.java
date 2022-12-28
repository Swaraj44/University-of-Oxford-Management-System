package com.example.educationalinstitutemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class studentpannel_main extends AppCompatActivity {

    TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentpannel_main);

        tt=findViewById(R.id.textView1112);

        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(studentpannel_main.this,Show_notice.class);
                startActivity(ii);
            }
        });
    }

    public  void CallNext(View view)
    {
        Intent ii=new Intent(studentpannel_main.this,Result_Show.class);
        startActivity(ii);
    }

    public  void GChat(View view)
    {
        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("NAME");
        Intent ii=new Intent(studentpannel_main.this,Chat_combine.class);
        ii.putExtra("NAME",ss);
        startActivity(ii);
    }

    public  void ShowT(View view)
    {
        Intent ii=new Intent(studentpannel_main.this,ID_show.class);
        ii.putExtra("K_id","Teacher");
        startActivity(ii);
    }
    public  void ST1Chat(View view)
    {
        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("NAME");
        Intent ii=new Intent(studentpannel_main.this,Chat_combiner_stMain.class);
        ii.putExtra("NAME",ss);
        startActivity(ii);
    }

}