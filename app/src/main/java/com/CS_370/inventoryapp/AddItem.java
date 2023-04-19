package com.CS_370.inventoryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {
    private Button addItemButton;
    private EditText itemName;
    private EditText itemDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        itemName = findViewById(R.id.itemName);
        itemDescription = findViewById(R.id.itemDescription);
        addItemButton = findViewById(R.id.addItemButton);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onAddItemClick(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    /** Add Item Function
     @param View - Pass in the view
     @returns - void
     **/
    private void onAddItemClick(View view) {
        String itemNameValue = itemName.getText().toString();
        String itemDescriptionValue = itemDescription.getText().toString();
        String itemUsername = Database.getInstance(getApplicationContext()).getUsername();
        Item newItem = new Item(0, itemNameValue, itemDescriptionValue, itemUsername);
        InventoryDatabase.getInstance(getApplicationContext()).addItem(newItem);
    }

    /** Item Selected Function
     @param Item - Pass in the item
     @returns - boolean
     **/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_notification) {
            Intent intent = new Intent(this, NotificationScreen .class);
            startActivity(intent);
            return true;
        }
        else if (itemId == R.id.action_logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}