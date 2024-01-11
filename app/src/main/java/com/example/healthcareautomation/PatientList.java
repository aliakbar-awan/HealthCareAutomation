package com.example.healthcareautomation;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PatientList extends AppCompatActivity {
    ListView patientList;
    ArrayList <Patient> patients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patients_list);

        patientList = (ListView) findViewById(R.id.patient_list);
        patients = new ArrayList<Patient>();
        ArrayList<Medicine> medicines = new ArrayList<Medicine>();
        medicines.add(new Medicine("Paracetamol Tablet",6));
        medicines.add(new Medicine("Calpol syrp",1));
        medicines.add(new Medicine("ORS",1));
        patients.add(new Patient(1,"Ahmed Hassan","Hassan Khan","son","Temperature","04/02/2021",medicines));
        patients.add(new Patient(35,"Ayesha Ahmed","Noor Muhammad","wife","Mild fever","17/01/2021",medicines));
        PatientAdapter adapter = new PatientAdapter(this,patients);
        patientList.setAdapter(adapter);
    }

}
