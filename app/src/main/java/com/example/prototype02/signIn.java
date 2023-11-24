package com.example.prototype02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class signIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password_toggle);

        MaterialButton loginbtn = findViewById(R.id.login_btn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    // Correct credentials
                    Toast.makeText(signIn.this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(signIn.this, mainCourse.class);
                    startActivity(i);
                } else {
                    // Incorrect credentials
                    Toast.makeText(signIn.this, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(signIn.this, mainCourse.class);
                    startActivity(i);
                }
            }
        });

                TextView create_acc =(TextView)findViewById(R.id.create_acc);
        create_acc.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        Intent i = new Intent(signIn.this, sign_up.class);
                        startActivity(i);
                    }
                });
    }
}

