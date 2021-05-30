package com.example.gumaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Mantissa extends AppCompatActivity {
    private ImageButton imageButton22;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantissa);
        constraintLayout= findViewById(R.id.container);

        imageButton22= (ImageButton) findViewById(R.id.imageButton22);
        imageButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mantissa.this, Activity3.class);
                startActivity(intent);
                finish();
            }
        });
    }
}