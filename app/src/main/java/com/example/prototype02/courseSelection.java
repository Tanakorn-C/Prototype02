package com.example.prototype02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class courseSelection extends AppCompatActivity {

    MaterialButton btnBack;
    MaterialButton whatIsJava;
    MaterialButton cheatSheetJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_selection);

        btnBack = findViewById(R.id.btnBack);
        whatIsJava = findViewById(R.id.whatIsJava);
        cheatSheetJava = findViewById(R.id.cheatSheetJava); // Assuming cheatSheetJava is the correct ID in your layout

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        whatIsJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(courseSelection.this, Article01.class);
                startActivity(i);
            }
        });

        cheatSheetJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(courseSelection.this, cheatsheet1.class);
                startActivity(z);
            }
        });
    }
}