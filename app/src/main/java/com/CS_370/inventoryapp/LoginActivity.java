package com.CS_370.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button loginButton;
    private Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onLoginClick(v);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onRegisterClick(v);
            }
        });
    }
    /** Opens "Database" Page
     @param View - Pass in the view
     @returns - void
     **/
    private void onLoginClick(View view) {
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();
        if (Database.getInstance(getApplicationContext()).authenticate(usernameValue, passwordValue)) {
            Intent intent = new Intent(this, Inventory.class);
            startActivity(intent);
        }

    }

    private void onRegisterClick(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}