package com.module_three.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Database extends AppCompatActivity {
    private Button addItemButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        addItemButton = findViewById(R.id.addItemButton);
    }
}