package com.example.gumaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class signup extends AppCompatActivity implements View.OnClickListener {
    private TextView btn_signup;
    private EditText editTextNama, editTextNIM, editTextEmail, editTextPassword;
    private ImageButton imageButton41;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(this);

        editTextNama = (EditText) findViewById(R.id.textInputEditText1);
        editTextNIM = (EditText) findViewById(R.id.textInputEditText2);
        editTextEmail = (EditText) findViewById(R.id.textInputEditText6);
        editTextPassword = (EditText) findViewById(R.id.textInputEditText);

        imageButton41 = (ImageButton) findViewById(R.id.imageButton41);
        imageButton41.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButton41:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.btn_signup:
                btn_signup();
                break;
        }
    }

    private void btn_signup() {
        String textInputEditText1 = editTextNama.getText().toString().trim();
        String textInputEditText2 = editTextNIM.getText().toString().trim();
        String textInputEditText6 = editTextEmail.getText().toString().trim();
        String textInputEditText = editTextPassword.getText().toString().trim();

        if(textInputEditText1.isEmpty()){
            editTextNama.setError("Silakan masukkan nama!");
            editTextNama.requestFocus();
            return;
        }
        if(textInputEditText2.isEmpty()){
            editTextNIM.setError("Silakan masukkan NIM!");
            editTextNIM.requestFocus();
            return;
        }
        if(textInputEditText6.isEmpty()){
            editTextEmail.setError("Silakan masukkan email!");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(textInputEditText6).matches()){
            editTextEmail.setError("Email tidak valid!");
            editTextEmail.requestFocus();
            return;
        }
        if(textInputEditText.isEmpty()){
            editTextPassword.setError("Silakan masukkan password!");
            editTextPassword.requestFocus();
            return;
        }
        if(textInputEditText.length() < 6){
            editTextPassword.setError("Password harus terdiri minimal 6 karakter!");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(textInputEditText6, textInputEditText)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(textInputEditText1,textInputEditText2,textInputEditText6);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(signup.this,"User telah ditambahkan!",Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(signup.this,"Gagal menambahkan user, silakan coba lagi!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(signup.this,"Gagal menambahkan user, silakan coba lagi!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}