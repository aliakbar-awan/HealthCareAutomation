package com.example.healthcareautomation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ChildrenActivity extends AppCompatActivity {
    ListView l2;
    String [] str = {"View Children list", "Incomplete vaccination List"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.children);

        l2 = findViewById(R.id.childrenList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.simple_list,R.id.textView3,str);
        l2.setAdapter(adapter);

        l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(ChildrenActivity.this,ChildrenList.class));
                }
                else{
                    startActivity(new Intent(ChildrenActivity.this,IncompleteActivity.class));
                }


            }

        });
    }
}