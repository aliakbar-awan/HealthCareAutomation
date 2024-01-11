package com.example.healthcareautomation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class SignupActivity extends AppCompatActivity {

    TextView name, username, password, confirmPassword, unionCouncil, code, area;
    RadioButton worker, supervisor;
    Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        name = (TextView) findViewById(R.id.name);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        confirmPassword = (TextView) findViewById(R.id.confirmPassword);
        unionCouncil = (TextView) findViewById(R.id.unionCouncil);
        code = (TextView) findViewById(R.id.code);
        area = (TextView) findViewById(R.id.area);

        worker = (RadioButton) findViewById(R.id.lhw);
        supervisor = (RadioButton) findViewById(R.id.supervisor);
        registerButton = (Button) findViewById(R.id.registerButton);

        worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code.setVisibility(View.VISIBLE);
                area.setVisibility(View.VISIBLE);

                ConstraintLayout constraintLayout = findViewById(R.id.parent_layout);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(constraintLayout);
                constraintSet.connect(R.id.registerButton,ConstraintSet.TOP,R.id.area,ConstraintSet.BOTTOM,20);
                constraintSet.connect(R.id.registerButton,ConstraintSet.RIGHT,R.id.area,ConstraintSet.RIGHT,0);
                constraintSet.applyTo(constraintLayout);

                // Toast.makeText(MainActivity.this, "worker is checked",Toast.LENGTH_LONG).show();
            }
        });

        supervisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code.setVisibility(View.INVISIBLE);
                area.setVisibility(View.INVISIBLE);

                ConstraintLayout constraintLayout = findViewById(R.id.parent_layout);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(constraintLayout);
                constraintSet.connect(R.id.registerButton,ConstraintSet.TOP,R.id.unionCouncil,ConstraintSet.BOTTOM,20);
                constraintSet.connect(R.id.registerButton,ConstraintSet.RIGHT,R.id.unionCouncil,ConstraintSet.RIGHT,0);
                constraintSet.applyTo(constraintLayout);

                //Toast.makeText(MainActivity.this, "Supervisor is checked",Toast.LENGTH_LONG).show();
            }
        });



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Name is empty",Toast.LENGTH_LONG).show();
                }
                else if(username.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Username is empty",Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Password is empty",Toast.LENGTH_LONG).show();
                }
                else if(confirmPassword.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Confirm Password is empty",Toast.LENGTH_LONG).show();
                }
                else if(!password.getText().toString().equals(confirmPassword.getText().toString())){
                    Toast.makeText(SignupActivity.this, "Password and confirm password doesn't match",Toast.LENGTH_LONG).show();
                }
                else if(unionCouncil.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Union Council is empty",Toast.LENGTH_LONG).show();
                }
                else if(code.getVisibility()== View.VISIBLE && code.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Union Council is empty",Toast.LENGTH_LONG).show();
                }
                else if(area.getVisibility()== View.VISIBLE && area.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this, "Union Council is empty",Toast.LENGTH_LONG).show();
                }
                else{
                    // back-end work here

                }
            }
        });



    }

}
