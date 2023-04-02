package com.module_three.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button loginButton;
    private Button registerButton;
    private Button createAccountButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // grab instance of nameText
        username = findViewById(R.id.username);
        // grab instance of textGreeting
        password = findViewById(R.id.password);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        // grab instance of say hello button
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        createAccountButton = findViewById(R.id.createAccountButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onLoginClick(v);
            }
        });
    }

    private void onLoginClick(View view) {
        Intent intent = new Intent(this, Database.class);
        startActivity(intent);
    }
}