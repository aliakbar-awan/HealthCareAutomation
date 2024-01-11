package com.example.healthcareautomation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ChildrenList extends AppCompatActivity {

    ListView children_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.children_list);

        children_list = findViewById(R.id.children_list);
        ArrayList<Child> children = new ArrayList<Child>();
        children.add(new Child("Ahmed Ali","Ali Raza","male","23/12/2019","son",23));
        children.add(new Child("M Nasir","M Sabir","male","23/12/2017","son",122));
        children.add(new Child("Tariq Mehmood","Mehmood Khan","male","13/06/2010","son",51));
        children.add(new Child("Ayesha Khan","Basit Afzal","female","10/09/2020","daughter",51));
        ChildAdapter adapter = new ChildAdapter(this,children);
        children_list.setAdapter(adapter);
    }
}