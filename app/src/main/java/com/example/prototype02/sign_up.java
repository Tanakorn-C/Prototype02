package com.example.prototype02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        MaterialButton regbtn = findViewById(R.id.regbtn);


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (regbtn.performClick()){ 
                    Toast.makeText(sign_up.this, "ACCOUNT CREATED!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(sign_up.this, signIn.class);
                    startActivity(i);
                } else {
                Intent i = new Intent(sign_up.this, signIn.class);
                startActivity(i);
            }
        }
    });
        TextView loginbtn_signup =(TextView)findViewById(R.id.loginbtn_signup);
        loginbtn_signup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(sign_up.this, signIn.class);
                startActivity(i);
            }
        });
    }
}