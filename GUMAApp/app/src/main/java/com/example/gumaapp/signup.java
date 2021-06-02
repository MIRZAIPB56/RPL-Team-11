package com.example.gumaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class signup extends AppCompatActivity {
    private ImageButton imageButton41;
    ConstraintLayout ConstraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ConstraintLayout=findViewById(R.id.container);

        imageButton41 = (ImageButton) findViewById(R.id.imageButton41);
        imageButton41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
