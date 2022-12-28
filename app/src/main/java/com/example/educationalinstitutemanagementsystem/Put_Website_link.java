package com.example.educationalinstitutemanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Put_Website_link extends AppCompatActivity {

    private EditText e1,e2;
    private Button b1;
    private TextView tt;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference rootTe= db.getReference().child("EIMS").child("Link").child("Link");
    DatabaseReference rootT= db.getReference().child("EIMS").child("Link");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_website_link);

        e1=findViewById(R.id.link11);
        //e2=findViewById(R.id.link166);
        b1=findViewById(R.id.publish221);
        tt=findViewById(R.id.textView130);


        ///////////////////////////////////////////////////////////


        rootT.addValueEventListener(new ValueEventListener() {



            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    LINK model = dataSnapshot.getValue(LINK.class);

                    String link1=model.getLink();
                    //e2.setText(link1);
                    tt.setText(link1);
                    break;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ////////////////////////////////////////////////////////////



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LINK ll=new LINK();
                String ss=e1.getText().toString();

                ll.setLink(ss);
                rootTe.setValue(ll);

                Toast.makeText(Put_Website_link.this, "Done!", Toast.LENGTH_SHORT).show();

                finish();
                startActivity(getIntent());


            }
        });

    }
}