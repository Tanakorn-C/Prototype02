package com.example.prototype02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        MaterialButton regbtn = findViewById(R.id.reg_btn);


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(sign_up.this, signIn.class);
                startActivity(i);
            }

    });
        TextView login_signup =(TextView)findViewById(R.id.login_signup);
        login_signup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(sign_up.this, signIn.class);
                startActivity(i);
            }
        });
    }
}