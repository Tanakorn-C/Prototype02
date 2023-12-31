package com.example.prototype02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class mainCourse extends AppCompatActivity {

    TextView month, day, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);

        month = findViewById(R.id.month);
        day = findViewById(R.id.day);
        year = findViewById(R.id.year);

        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);

        String[] splitDate = formattedDate.split(",");

        Log.d("myLOG", currentTime.toString());
        Log.d("myLOG", formattedDate);

        month.setText(splitDate[1]);
        day.setText(splitDate[0]);
        year.setText(splitDate[2]);

        Log.d("myLOG", splitDate[0].trim());
        Log.d("myLOG", splitDate[1].trim());
        Log.d("myLOG", splitDate[2].trim());

//        ProgressBar simpleProgressBar=(ProgressBar) findViewById(R.id.progressBar); // initiate the progress bar
//        int maxValue=simpleProgressBar.getMax(); // get maximum value of the progress bar

        @SuppressLint("WrongViewCast") MaterialButton courseBtn = findViewById(R.id.courseBtn);

        courseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mainCourse.this, courseSelection.class);
                startActivity(i);
            }
        });

        MaterialButton btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
