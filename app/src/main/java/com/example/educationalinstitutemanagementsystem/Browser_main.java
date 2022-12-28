package com.example.educationalinstitutemanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Browser_main extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference rootT= db.getReference().child("EIMS").child("Link");

    String link1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_main);

        rootT.addValueEventListener(new ValueEventListener() {



            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    LINK model = dataSnapshot.getValue(LINK.class);

                    link1=model.getLink();
                    break;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public  void HOME(View view)
    {




        Intent ii=new Intent(Browser_main.this,Browser.class);
        ii.putExtra("LINK",link1);
        startActivity(ii);
    }

    public  void GG(View view)
    {

        Intent ii=new Intent(Browser_main.this,Browser.class);
        ii.putExtra("LINK","https://www.google.com/");
        startActivity(ii);
    }

    public  void YT(View view)
    {

        Intent ii=new Intent(Browser_main.this,Browser.class);
        ii.putExtra("LINK","https://www.youtube.com/");
        startActivity(ii);
    }

    public  void WI(View view)
    {

        Intent ii=new Intent(Browser_main.this,Browser.class);
        ii.putExtra("LINK","https://www.wikipedia.org/");
        startActivity(ii);
    }

    public  void TP(View view)
    {

        Intent ii=new Intent(Browser_main.this,Browser.class);
        ii.putExtra("LINK","https://www.javatpoint.com/");
        startActivity(ii);
    }

    public  void IL(View view)
    {

        Intent ii=new Intent(Browser_main.this,Browser.class);
        ii.putExtra("LINK","https://www.ielts.org/");
        startActivity(ii);
    }



    public  void SR(View view)
    {

        EditText tt=findViewById(R.id.source);

        String sss=tt.getText().toString();

        Intent ii=new Intent(Browser_main.this,Browser.class);
        ii.putExtra("LINK",sss);
        startActivity(ii);
    }

}