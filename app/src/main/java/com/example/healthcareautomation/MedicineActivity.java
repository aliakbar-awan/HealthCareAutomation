package com.example.healthcareautomation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MedicineActivity extends AppCompatActivity {

    ListView l2;
    String [] str = {"Add Medicine to stock", "View medicine stock"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine);

        l2 = findViewById(R.id.l3);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.simple_list,R.id.textView3,str);
        l2.setAdapter(adapter);

        l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MedicineActivity.this,AddMedicine.class));
                        break;
                    case 1:
                        startActivity(new Intent(MedicineActivity.this,MedicineStock.class));
                        break;

                }

            }
        });


    }
}
