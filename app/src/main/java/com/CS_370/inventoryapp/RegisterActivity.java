package com.CS_370.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button registerButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        registerButton = findViewById(R.id.registerButton);
        backButton = findViewById(R.id.backButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onRegisterClick(v);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackClick(v);
            }
        });
    }

    private void onRegisterClick(View view) {
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();
        Database.getInstance(getApplicationContext()).createUser(usernameValue, passwordValue);
    }

    private void onBackClick(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}