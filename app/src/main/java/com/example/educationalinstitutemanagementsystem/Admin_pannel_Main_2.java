package com.example.educationalinstitutemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;

public class Admin_pannel_Main_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pannel_main2);
    }

    public void notice(View view)
    {
        Intent in=new Intent(Admin_pannel_Main_2.this,Put_notice.class);
        in.putExtra("NAME","Admin");
        startActivity(in);
        // Do something in response to button click
    }

    public void addT(View view)
    {
        Intent in=new Intent(Admin_pannel_Main_2.this,Add_info.class);
        in.putExtra("desg","Teacher");
        startActivity(in);
        // Do something in response to button click
    }

    public void addS(View view)
    {
        Intent in=new Intent(Admin_pannel_Main_2.this,Add_info.class);
        in.putExtra("desg","Student");
        startActivity(in);
        // Do something in response to button click
    }


    public void UpdateT(View view)
    {
        Intent in=new Intent(Admin_pannel_Main_2.this,Update_info.class);
        in.putExtra("desg","Teacher");
        startActivity(in);
        // Do something in response to button click
    }

    public void updateS(View view)
    {
        Intent in=new Intent(Admin_pannel_Main_2.this,Update_info.class);
        in.putExtra("desg","Student");
        startActivity(in);
        // Do something in response to button click
    }
    public void LN(View view)
    {
        Intent in=new Intent(Admin_pannel_Main_2.this,Put_Website_link.class);
        startActivity(in);
        // Do something in response to button click
    }

    public void BK(View view)
    {
        Intent in=new Intent(Admin_pannel_Main_2.this,MainActivity2.class);
        startActivity(in);
        finish();
        // Do something in response to button click
    }
}