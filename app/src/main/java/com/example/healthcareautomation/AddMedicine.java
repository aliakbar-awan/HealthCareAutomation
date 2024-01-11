package com.example.healthcareautomation;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AddMedicine extends AppCompatActivity {
    Spinner spinner;
    String []array = {"Paracetamol Syrp", "Paracetamol Tablet","Polifex","Calpol Syrp","Zinq Syrp","ORS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_medicine);

        spinner = findViewById(R.id.spinner1);
        ArrayAdapter <String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}
