package com.CS_370.inventoryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Inventory extends AppCompatActivity {
    private Button addItemButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        //NotificationManager.initialize(getApplicationContext(), "aoljaca");
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //Fragment fragment = fragmentManager.findFragmentById(R.id.list_fragment_container);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

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
    public void onItemSelected(int itemId) {
        Intent intent = new Intent(this, DetailsActivity.class);
        //intent.putExtra(DetailsActivity.EXTRA_BAND_ID, bandId);
        //startActivity(intent);
    }
}