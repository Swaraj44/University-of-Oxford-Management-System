package com.example.educationalinstitutemanagementsystem;

import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
        import android.os.Bundle;
        import android.util.Patterns;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.OnSuccessListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;


public class Teacher_login extends AppCompatActivity {



    private EditText mEmail , mPass;
    private TextView mTextView;
    private Button signInBtn;
    String st;
    String ss;
    String sname;
    int done=0;
    int ck=0;

    ProgressDialog progressDialog;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        mEmail = findViewById(R.id.email_signin);
        mPass = findViewById(R.id.passsignin);

        signInBtn = findViewById(R.id.singin_btn);


        mAuth = FirebaseAuth.getInstance();

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(Teacher_login.this);
                progressDialog.setTitle("Signing in...");
                progressDialog.show();


                ss=mEmail.getText().toString();
                search(ss);
            }
        });

    }




    public void search(String email19){
         FirebaseDatabase db = FirebaseDatabase.getInstance();
        //DatabaseReference rootTe= db.getReference().child("CSE_DEPT").child("Teacher");
         DatabaseReference rootTe= db.getReference().child("EIMS").child("Teacher");


        ck=0;


        rootTe.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Model_INFO model = dataSnapshot.getValue(Model_INFO.class);

                    st=model.getEmail();
                    sname=model.getName();
                    if (Objects.equals(st, email19)){
                        ck=1;
                        loginUser();
                        return;
                        //Toast.makeText(Teacher_login.this, "HHHHHHHHHHHHHHHHHH !!", Toast.LENGTH_SHORT).show();

                    }

                }
                progressDialog.dismiss();
                Toast.makeText(Teacher_login.this, "Only for Teachers !!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }




    private void loginUser(){
        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if (!pass.isEmpty()){
                mAuth.signInWithEmailAndPassword(email , pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {

                                progressDialog.dismiss();

                                Toast.makeText(Teacher_login.this, "Login Successfully !!", Toast.LENGTH_SHORT).show();
                                Intent ii=new Intent(Teacher_login.this , Teachers_Pannel_Main.class);
                                ii.putExtra("NAME",sname);
                                startActivity(ii);

                                //startActivity(new Intent(Teacher_login.this , TeacherPannel_main.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.dismiss();
                                Toast.makeText(Teacher_login.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }else{

                progressDialog.dismiss();

                mPass.setError("Empty Fields Are not Allowed !");
            }
        }else if(email.isEmpty()){
            progressDialog.dismiss();
            mEmail.setError("Empty Fields Are not Allowed !");
        }else{
            progressDialog.dismiss();
            mEmail.setError("Enter Correct Email !");
        }
    }


    public void SIGNUP(View view)
    {
        Intent in=new Intent(Teacher_login.this,SignUpForEveryone.class);
        startActivity(in);
        // Do something in response to button click
    }

}