package com.example.healthcareautomation;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyView extends AppCompatActivity {

    ListView l2;
    PersonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family_view);

        l2 = findViewById(R.id.listView);

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Anayat Ali","Ahmed","Male","12/12/1986","Self",5));
        list.add(new Person("Saad","Anayat Ali","Male","09/12/1997","Son",10));
        list.add(new Person("Ahsan Nawaz","Anayat Ali","Male","12/07/2001","Son",55));
        adapter = new PersonAdapter(this,list);
        l2.setAdapter(adapter);
    }

}
