package com.example.educationalinstitutemanagementsystem;

import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.annotation.SuppressLint;
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

        import java.util.ArrayList;
import java.util.Objects;

public class Result_Show extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    //private DatabaseReference rootST= db.getReference().child("CSE_DEPT").child("Student");
    private DatabaseReference rootST= db.getReference().child("EIMS").child("Result").child("Student");

    EditText ee;
    String sid="";

    private MyAdapter adapter;
    private ArrayList<Model> list;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_show);








        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SHOW();



    }

    void SHOW(){

        ee=findViewById(R.id.ee123);
        String CR =ee.getText().toString();

        list = new ArrayList<>();
        adapter = new MyAdapter(this ,list );

        recyclerView.setAdapter(adapter);

        rootST.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Model model = dataSnapshot.getValue(Model.class);

                    String Course =model.getCourse_code();
                    String IDD =model.getRoll();
                    //String Name =model.getCourse_code();

                    if(sid.equals("")){
                        if(Course.equals(CR)){
                            list.add(model);
                        }
                        else if(CR.equals("")){
                            list.add(model);
                        }
                    }
                    else {

                        if(IDD.equals(sid)){
                            list.add(model);
                        }

                    }




                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


    public void Filter(View view)
    {
        SHOW();
       // finish();
       // startActivity(getIntent());

    }

    public void FilterMine(View view)
    {
        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("ID");
        sid=ss;
        SHOW();
        // finish();
        // startActivity(getIntent());

    }
}
