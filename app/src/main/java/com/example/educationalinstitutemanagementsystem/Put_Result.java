package com.example.educationalinstitutemanagementsystem;

import androidx.annotation.NonNull;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.HashMap;

public class Put_Result extends AppCompatActivity {

    private EditText rroll,ccode,mmark;

    private Button button ;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_result);

        rroll= findViewById(R.id.Roll);
        ccode = findViewById(R.id.CCode);
        mmark = findViewById(R.id.Mark);


        button = findViewById(R.id.publish);
       // button2 = findViewById(R.id.button2);
        //bb=findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String roll1 = rroll.getText().toString();
                String ccode1 = ccode.getText().toString();
                String marks1 = mmark.getText().toString();


                /////////////////////////////////////////////////////////////////////
                HashMap<String , String> userMap = new HashMap<>();

                userMap.put("roll" , roll1);
                userMap.put("course_code" , ccode1);
                userMap.put("mark" , marks1);

                root.child("EIMS").child("Result").child("Student").push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Put_Result.this, "Data Saved", Toast.LENGTH_SHORT).show();
                    }
                });

               // root.child(dd).child("Student").push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                //    @Override
               //     public void onComplete(@NonNull Task<Void> task) {
               //         Toast.makeText(Put_Result.this, "Data Saved", Toast.LENGTH_SHORT).show();
                //    }
                //});


                //root.child("CSE").child("Result").push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                  //  @Override
                  //  public void onComplete(@NonNull Task<Void> task) {
                  //      Toast.makeText(Put_Result.this, "Data Saved", Toast.LENGTH_SHORT).show();
                  //  }
               // });


            }
        });





    }
}