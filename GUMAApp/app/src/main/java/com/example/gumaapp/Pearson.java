package com.example.gumaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Pearson extends AppCompatActivity {
    private ImageButton imageButton26;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pearson);
        constraintLayout= findViewById(R.id.container);

        imageButton26= (ImageButton) findViewById(R.id.imageButton26);
        imageButton26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pearson.this, Activity3.class);
                startActivity(intent);
                finish();
            }
        });
    }
}