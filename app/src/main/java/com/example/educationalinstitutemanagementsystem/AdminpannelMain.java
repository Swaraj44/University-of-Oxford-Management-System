package com.example.educationalinstitutemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminpannelMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpannel_main);
    }

    public void notice(View view)
    {
        Intent in=new Intent(AdminpannelMain.this,Put_notice.class);
        in.putExtra("NAME","Admin");
        startActivity(in);
        // Do something in response to button click
    }

    public void addT(View view)
    {
        Intent in=new Intent(AdminpannelMain.this,Add_info.class);
        in.putExtra("desg","Teacher");
        startActivity(in);
        // Do something in response to button click
    }

    public void addS(View view)
    {
        Intent in=new Intent(AdminpannelMain.this,Add_info.class);
        in.putExtra("desg","Student");
        startActivity(in);
        // Do something in response to button click
    }


    public void UpdateT(View view)
    {
        Intent in=new Intent(AdminpannelMain.this,Update_info.class);
        in.putExtra("desg","Teacher");
        startActivity(in);
        // Do something in response to button click
    }

    public void updateS(View view)
    {
        Intent in=new Intent(AdminpannelMain.this,Update_info.class);
        in.putExtra("desg","Student");
        startActivity(in);
        // Do something in response to button click
    }
    public void LN(View view)
    {
        Intent in=new Intent(AdminpannelMain.this,Put_Website_link.class);
        startActivity(in);
        // Do something in response to button click
    }
}