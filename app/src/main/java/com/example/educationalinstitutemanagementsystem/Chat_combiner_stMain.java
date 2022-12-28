package com.example.educationalinstitutemanagementsystem;


import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.annotation.SuppressLint;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Calendar;
        import java.util.Date;
        import java.util.HashMap;
        import java.util.Locale;

public class Chat_combiner_stMain extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference rootST= db.getReference().child("EIMS").child("Chat").child("Teacher");


    private ImageView button;
    private EditText cmesg;


    // private String date;


    private MyAdapter_Chat adapter;
    private ArrayList<Model_chat> list;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_combiner_st_main);

        recyclerView = findViewById(R.id.recyclerview112);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new MyAdapter_Chat(this ,list );

        recyclerView.setAdapter(adapter);

        rootST.addValueEventListener(new ValueEventListener() {



            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Model_chat model = dataSnapshot.getValue(Model_chat.class);

                    list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });











        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String date = df.format(c);








        button = findViewById(R.id.imagebut2);
        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("NAME");

        cmesg=findViewById(R.id.mess1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String date1 = date;
                String publisher1 = ss;
                String msg =cmesg.getText().toString();


                /////////////////////////////////////////////////////////////////////
                HashMap<String , String> userMap = new HashMap<>();

                userMap.put("date" , date1);
                userMap.put("publisher" , publisher1);
                userMap.put("message" , msg);

                rootST.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(Chat_combiner_stMain.this, "Sent!", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(getIntent());
                    }
                });




            }
        });


    }
}
