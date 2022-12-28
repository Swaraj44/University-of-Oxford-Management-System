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

        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Calendar;
        import java.util.Date;
        import java.util.HashMap;
        import java.util.Locale;

public class Put_notice extends AppCompatActivity{

    private EditText date121,notice121;

    private Button button ;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_notice);


        notice121 = findViewById(R.id.notice11);


        button = findViewById(R.id.publish21);
        Bundle bb=getIntent().getExtras();
        String ss=bb.getString("NAME");




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String date1 = date121.getText().toString();
                String publisher1 = ss;
                String notice1 =notice121.getText().toString();


                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                String date = df.format(c);


                /////////////////////////////////////////////////////////////////////
                HashMap<String , String> userMap = new HashMap<>();

                userMap.put("date" , date);
                userMap.put("publisher" , publisher1);
                userMap.put("notice" , notice1);

                root.child("EIMS").child("Notice").push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Put_notice.this, "Data Saved", Toast.LENGTH_SHORT).show();
                    }
                });




            }
        });





    }
}