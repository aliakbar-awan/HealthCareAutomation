package com.example.healthcareautomation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SearchFamily extends AppCompatActivity {

    RadioButton searchByName, searchByNumber;
    EditText textBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_family);

        searchByName = findViewById(R.id.searchByName);
        searchByNumber = findViewById(R.id.searchByID);
        textBox = findViewById(R.id.familySearchBox);

        searchByNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBox.setHint("Enter family number");
            }
        });

        searchByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBox.setHint("Enter a family member's name");
            }
        });
    }

    }
