package com.example.healthcareautomation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    TextView username, password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.userName);
        password = findViewById(R.id.passWord);

        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Username is empty!",Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Password is empty!",Toast.LENGTH_LONG).show();
                }
                else{
                    // do the real work
                }
            }
        });
    }
}
