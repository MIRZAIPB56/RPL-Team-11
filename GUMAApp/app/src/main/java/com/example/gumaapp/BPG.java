package com.example.gumaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BPG extends AppCompatActivity {
    private ImageButton imageButton14;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_p_g);
        constraintLayout= findViewById(R.id.container);

        imageButton14= (ImageButton) findViewById(R.id.imageButton14);
        imageButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BPG.this, Activity3.class);
                startActivity(intent);
                finish();
            }
        });
    }
}