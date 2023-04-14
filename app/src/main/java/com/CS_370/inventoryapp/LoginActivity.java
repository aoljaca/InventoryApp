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
    private Button createAccountButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
}