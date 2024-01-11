package com.example.healthcareautomation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;
import android.widget.TextView;

public class VaccinationDetails extends AppCompatActivity {

    TextView name, relation, fname, dob, gender, family;
    ListView vaccine_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccination_details);

        vaccine_list = findViewById(R.id.vaccine_list);
        name = findViewById(R.id.child_name);
        fname = findViewById(R.id.child_relation_name);
        gender = findViewById(R.id.child_gender);
        dob = findViewById(R.id.child_dob);
        relation = findViewById(R.id.child_relation);
        family = findViewById(R.id.child_family);

        Intent i = getIntent();
        Person person = (Person) i.getExtras().get("person");
        Parcelable[] parceableVaccine = i.getParcelableArrayExtra("vaccine");

        Vaccine [] vaccine = new Vaccine[parceableVaccine.length];
        for(int x=0;x<parceableVaccine.length;x++){

            vaccine[x] = (Vaccine) parceableVaccine[x];
        }

        name.setText(person.getName());
        fname.setText(person.getFatherName());
        dob.setText(person.getDob());
        int f = person.getFamily_no();
        family.setText(String.valueOf(f));

        if(person.getRelation().equals("son")){
            relation.setText("S/O:");
        }
        else if(person.getRelation().equals("wife")){
            relation.setText("W/O:");
        }
        else if(person.getRelation().equals("daughter")){
            relation.setText("D/O:");
        }

        if(person.getGender().equals("male")){
            gender.setText("M");
        }
        else{
            gender.setText("F");
        }

        VaccinationAdapter adapter = new VaccinationAdapter(this,vaccine);
        vaccine_list.setAdapter(adapter);



    }
}