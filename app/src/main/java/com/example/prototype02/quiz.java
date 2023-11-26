package com.example.prototype02;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class quiz extends AppCompatActivity {
    private MaterialButton btnBack;  // Added initialization for btnBack
    private String currentAnswer;
    private int currentQuestionIndex = 0;
    private int userScore = 0;
    private int totalQuestions;

    // Define your questions and answers here
    private String[] questions = {
            "Question 1: What is missing from this Java program?\n" +
                    "\n" +
                    "public class LanguageFacts {\n" +
                    "\n" +
                    "  // Covers the history of the Java programming language\n" +
                    "  \n" +
                    "}\n",
            "Question 2: In Java, what is the purpose of leaving comments in code?",
            "Question 3: Java is a compiled language, meaning the code we write is translated by another program into a language the computer understands.",
            // Add more questions as needed
    };

    private String[] correctAnswers = {
            "The main() method: public static void main(String[] args) {}",
            "They provide human-readable notes that clarify thinking.",
            "True."
    };

    private String[][] choices = {
            {"The curly braces that mark the scope of the class.", "The main() method: public static void main(String[] args) {}", "The line to compile code: javac LanguageFacts.java", "A single-line comment."},
            {"They are how words are printed to the screen.", "They provide human-readable notes that clarify thinking.", "They are only present in compiled code.", "They provide checks that the compiler must pass."},
            {"False.", "True.", "Java is not a compiled language", "none of the above"},
            // Add more choices as needed
    };

    private TextView questionTextView;
    private RadioGroup choicesRadioGroup;
    private MaterialButton submitButton;  // Changed to MaterialButton
    private TextView scoreTextView;
    private MaterialButton restartButton;  // Changed to MaterialButton



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        btnBack = findViewById(R.id.btnBack);  // Initialize btnBack

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        questionTextView = findViewById(R.id.questionTextView);
        choicesRadioGroup = findViewById(R.id.choicesRadioGroup);
        submitButton = findViewById(R.id.submitButton);
        scoreTextView = findViewById(R.id.scoreTextView);
        restartButton = findViewById(R.id.restartButton);


        totalQuestions = questions.length;

        // Load the first question
        loadQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartQuiz();
            }
        });
    }

    private void loadQuestion() {
        if (currentQuestionIndex < totalQuestions) {
            // Set the question text
            questionTextView.setText(questions[currentQuestionIndex]);

            // Clear previous choices
            choicesRadioGroup.clearCheck();
            choicesRadioGroup.removeAllViews();

            // Add new choices
            for (int i = 0; i < choices[currentQuestionIndex].length; i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(choices[currentQuestionIndex][i]);
                radioButton.setId(i);
                choicesRadioGroup.addView(radioButton);

                radioButton.setTextColor(0xFF989BBD);


            }

            // Set the correct answer
            currentAnswer = correctAnswers[currentQuestionIndex];
        } else {
            // Quiz finished
            showScoreSummary();
        }

    }

    private void checkAnswer() {
        int selectedId = choicesRadioGroup.getCheckedRadioButtonId();

        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            String selectedAnswer = selectedRadioButton.getText().toString();

            if (selectedAnswer.equals(currentAnswer)) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                userScore++;
            } else {
                Toast.makeText(this, "Incorrect! ", Toast.LENGTH_SHORT).show();
            }

            // Move to the next question or show the score
            currentQuestionIndex++;
            loadQuestion();
        } else {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScoreSummary() {
        // Display the user's score
        //Toast.makeText(this, "Your Score: " + userScore + " out of " + totalQuestions, Toast.LENGTH_LONG).show();
        scoreTextView.setText("Your Score: " + userScore + " out of " + totalQuestions);

//        scoreTextView.setGravity(Gravity.BOTTOM | Gravity.BOTTOM);
    }

    private void restartQuiz() {
        // Reset variables and load the first question
        currentQuestionIndex = 0;
        userScore = 0;
        loadQuestion();
        scoreTextView.setText("");
    }
}
