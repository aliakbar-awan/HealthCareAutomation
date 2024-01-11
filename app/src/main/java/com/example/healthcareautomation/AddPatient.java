package com.example.healthcareautomation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddPatient extends AppCompatActivity {
    Spinner spinner, membersSpinner;
    String [] familyArray;
    ListView medicineList;
    Spinner medicineSpinner;
    Button addMedicine;

    String [] membersArray = {"-- select person --","Ahsan Ali", "Muhammad Khan","Aadil Habib","Ahsan Khan","Abdullah Hafeez"};
    String []array = {"-- select medicine --","Paracetamol Syrp", "Paracetamol Tablet","Polifex","Calpol Syrp","Zinq Syrp","ORS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_patient);

        familyArray = new String[100];
        familyArray[0] = "-- select family --";
        for(int i=1;i<100;i++){
            familyArray[i] = String.valueOf(i);
        }

        spinner = (Spinner) findViewById(R.id.familySpinner);
        membersSpinner = (Spinner) findViewById(R.id.personSpinner);
        medicineList = (ListView) findViewById(R.id.medicineList) ;
        medicineSpinner = (Spinner) findViewById(R.id.medicineSpinner);
        addMedicine = (Button) findViewById(R.id.addMedicine);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, familyArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        membersSpinner.setEnabled(false);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!spinner.getSelectedItem().toString().equals("-- select family --")){
                    membersSpinner.setEnabled(true);
                }
                else{
                    membersSpinner.setEnabled(false);
                    //Toast.makeText(getApplicationContext(),"Select family first",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,membersArray);
        membersSpinner.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,array);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medicineSpinner.setAdapter(adapter3);


        ArrayList <Medicine> med = new ArrayList<Medicine>();
        med.add(new Medicine("Paracetamol Syrp",1));
        med.add(new Medicine("Paracetamol Tablets",6));
        med.add(new Medicine("Zinq Syrp",1));
        MedicineAdapter medicineAdapter = new MedicineAdapter(this,med,true);
        medicineList.setAdapter(medicineAdapter);

        addMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Medicine m;
                if(medicineSpinner.getSelectedItem().toString().equals("Paracetamol Tablet")){
                    m = new Medicine(medicineSpinner.getSelectedItem().toString(),6);
                }
                else{
                    m = new Medicine(medicineSpinner.getSelectedItem().toString(),1);
                }
                medicineAdapter.addItem(m);
                medicineSpinner.setSelection(0);
            }
        });




    }
}
