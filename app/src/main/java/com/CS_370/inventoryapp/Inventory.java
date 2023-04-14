package com.CS_370.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inventory extends AppCompatActivity {
    private Button addItemButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        addItemButton = findViewById(R.id.addItemButton);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onAddItemClick(v);
            }
        });
    }
    /** Opens "AddItem" Page
     @param View - Pass in the view
     @returns - void
     **/
    private void onAddItemClick(View view) {
        Intent intent = new Intent(this, AddItem.class);
        startActivity(intent);
    }
}