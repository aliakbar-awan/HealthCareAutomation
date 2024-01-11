package com.example.healthcareautomation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    ListView l1;
    String [] str = {"SignUp page", "Login page", "Lady Health Worker"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1 = findViewById(R.id.l1);
       // ArrayList <String> list = new ArrayList<String>(Arrays.asList(str));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.simple_list,R.id.textView3,str);
        l1.setAdapter(adapter);

        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this,SignupActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,LoginActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,LhwActivity.class));
                        break;

                }

            }
        });

    }
}