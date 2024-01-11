package com.example.healthcareautomation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class PatientsActivity extends AppCompatActivity {
    ListView l2;
    String [] str = {"Add new patient", "View Patients list"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patients);

        l2 = findViewById(R.id.patientsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.simple_list,R.id.textView3,str);
        l2.setAdapter(adapter);

        l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(PatientsActivity.this,AddPatient.class));
                }
                else{
                    startActivity(new Intent(PatientsActivity.this,PatientList.class));
                }

            }
        });
    }
}
