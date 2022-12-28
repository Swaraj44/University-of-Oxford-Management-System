package com.example.educationalinstitutemanagementsystem;


import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button admin,teacher,student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        admin=findViewById(R.id.button_ad);
        teacher=findViewById(R.id.button_te);
        student=findViewById(R.id.button_St);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity2.this,Admin_login.class);
                startActivity(in);
            }
        });

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity2.this,Teacher_login.class);
                startActivity(in);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity2.this,Student_login.class);
                startActivity(in);
            }
        });


    }

    public void SIGNUP(View view)
    {
        Intent in=new Intent(MainActivity2.this,SignUpForEveryone.class);
        startActivity(in);
    }

    public void WB(View view)
    {
        Intent in=new Intent(MainActivity2.this,Browser_main.class);
        startActivity(in);
    }
}
