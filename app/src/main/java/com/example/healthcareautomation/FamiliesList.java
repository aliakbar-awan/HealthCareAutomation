package com.example.healthcareautomation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class FamiliesList extends AppCompatActivity {
    ListView l2;
    String [] str = {"1.  Anayat Ali S/O Ahmed", "2.  Saad S/O Hamid Khan","3.  Ahsan Nawaz S/O Khalid Hussain","4.  Awais S/O Bashir Khan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.families_list);

        l2 = findViewById(R.id.l4);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.simple_list,R.id.textView3,str);
        l2.setAdapter(adapter);

        l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(FamiliesList.this,FamilyView.class);
                //i.putExtra()
                startActivity(i);


            }
        });

    }
}
