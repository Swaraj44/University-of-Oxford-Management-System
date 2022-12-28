package com.example.educationalinstitutemanagementsystem;




import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class Student_Pannel_Main2 extends AppCompatActivity {

    TextView tt,t1;
    ImageView imageView;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_pannel_main2);

        imageView=findViewById(R.id.imageView222);
        t1 = findViewById(R.id.textView170);

        ///////////////////////////////////////////////////////////////////////


         DatabaseReference rootST= db.getReference().child("EIMS").child("Student");


        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("NAME");

        rootST.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Model_INFO model = dataSnapshot.getValue(Model_INFO.class);

                    String link=model.getLink();

                    String nm=model.getName();

                    if(Objects.equals(nm, ss)){
                        t1.setText(nm);
                        Picasso.get().load(link).into(imageView);
                        break;
                    }



                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        ////////////////////////////////////////////////////////////////////




        tt=findViewById(R.id.textView1112);

        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(Student_Pannel_Main2.this,Show_notice.class);
                startActivity(ii);
            }
        });
    }

    public  void CallNext(View view)
    {
        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("ID");
        Intent ii=new Intent(Student_Pannel_Main2.this,Result_Show.class);
        ii.putExtra("ID",ss);
        startActivity(ii);
    }

    public  void GChat(View view)
    {
        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("NAME");
        Intent ii=new Intent(Student_Pannel_Main2.this,Chat_combine.class);
        ii.putExtra("NAME",ss);
        startActivity(ii);
    }

    public  void ShowT(View view)
    {
        Intent ii=new Intent(Student_Pannel_Main2.this,ID_show.class);
        ii.putExtra("K_id","Teacher");
        startActivity(ii);
    }
    public  void ST1Chat(View view)
    {
        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("NAME");
        Intent ii=new Intent(Student_Pannel_Main2.this,Chat_combiner_stMain.class);
        ii.putExtra("NAME",ss);
        startActivity(ii);
    }
    public void BK(View view)
    {
        Intent in=new Intent(Student_Pannel_Main2.this,MainActivity2.class);
        startActivity(in);
        finish();
        // Do something in response to button click
    }

}