package com.example.healthcareautomation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class FamilyActivity extends AppCompatActivity {

    ListView l2;
    String [] str = {"Add new family", "Search a family", "View Families list"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family);

        l2 = findViewById(R.id.l2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.simple_list,R.id.textView3,str);
        l2.setAdapter(adapter);

        l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(FamilyActivity.this,NewFamily.class));
                        break;
                    case 1:
                        startActivity(new Intent(FamilyActivity.this,SearchFamily.class));
                        break;
                    case 2:
                        startActivity(new Intent(FamilyActivity.this,FamiliesList.class));
                        break;

                }

            }
        });


    }

}
