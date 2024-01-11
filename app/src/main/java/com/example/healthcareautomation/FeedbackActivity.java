package com.example.healthcareautomation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {
    EditText feedback;
    Button feedbackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_layout);

        feedback = (EditText)findViewById(R.id.feedbackText);
        feedbackButton = findViewById(R.id.feedbackButton);

        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedbackActivity.this,IncompleteActivity.class));
            }
        });


    }
}
