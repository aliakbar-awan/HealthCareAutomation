package com.example.healthcareautomation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PatientDetails extends AppCompatActivity {

    TextView name, relation, relation_name, date, reason, familyNo;
    ListView medicineList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_details);

        name = findViewById(R.id.patient_details_name);
        relation = findViewById(R.id.patient_details_relation);
        relation_name = findViewById(R.id.patient_details_relation_name);
        date = findViewById(R.id.patient_details_date);
        reason = findViewById(R.id.patient_details_reason);
        familyNo = findViewById(R.id.patient_details_family);
        medicineList = findViewById(R.id.patient_details_list);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("patient");

        name.setText(bundle.getString("name"));
        relation.setText(bundle.getString("relation")+":");
        relation_name.setText(bundle.getString("fname"));
        date.setText(bundle.getString("date"));
        reason.setText(bundle.getString("reason"));
        familyNo.setText(String.valueOf(bundle.getInt("family")));
        ArrayList<Medicine> medicines = bundle.getParcelableArrayList("medicine");

        MedicineAdapter medicineAdapter = new MedicineAdapter(this,medicines,false);
        medicineList.setAdapter(medicineAdapter);

    }

}
