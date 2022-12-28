package com.example.educationalinstitutemanagementsystem;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class Teachers_Pannel_Main extends AppCompatActivity {

    private Button b1,b2;
    ImageView imageView;
    TextView tt ;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_pannel_main);;
        b1=findViewById(R.id.textView1112);
        b2=findViewById(R.id.text1112);

        tt = findViewById(R.id.textView18);


        ////////////////////////////////////////////////

        imageView=findViewById(R.id.imageView232);

        ///////////////////////////////////////////////////////////////////////


        DatabaseReference rootST= db.getReference().child("EIMS").child("Teacher");


        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("NAME");

        rootST.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Model_INFO model = dataSnapshot.getValue(Model_INFO.class);

                    String link=model.getLink();
                    String nm=model.getName();

                    //tt.setText(nm);

                    if(Objects.equals(nm, ss)){
                        tt.setText(nm);
                        Picasso.get().load(link).into(imageView);
                        break;
                    }



                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        //////////////////////////////////////////////////





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Teachers_Pannel_Main.this,Put_Result.class);
                startActivity(in);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bb=getIntent().getExtras();
                String ss=bb.getString("NAME");

                Intent in=new Intent(Teachers_Pannel_Main.this,Put_notice.class);
                in.putExtra("NAME",ss);
                startActivity(in);
            }
        });


    }

    public  void ShowS(View view)
    {
        Intent ii=new Intent(Teachers_Pannel_Main.this,ID_show.class);
        ii.putExtra("K_id","Student");
        startActivity(ii);
    }

    public  void Notice(View view)
    {
        Intent ii=new Intent(Teachers_Pannel_Main.this,Show_notice.class);
        startActivity(ii);
    }


    public  void Result1(View view)
    {
        Intent ii=new Intent(Teachers_Pannel_Main.this,Result_show_T.class);
        startActivity(ii);
    }


    public  void STChat(View view)
    {
        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("NAME");
        Intent ii=new Intent(Teachers_Pannel_Main.this,Chat_combiner_stMain.class);
        ii.putExtra("NAME",ss);
        startActivity(ii);
    }


    public void BK(View view)
    {
        Intent in=new Intent(Teachers_Pannel_Main.this,MainActivity2.class);
        startActivity(in);
        finish();
        // Do something in response to button click
    }



}