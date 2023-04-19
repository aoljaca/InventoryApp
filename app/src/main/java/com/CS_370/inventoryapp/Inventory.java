package com.CS_370.inventoryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;
/*public class Inventory extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] localDataSet;

    *//**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     *//*
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    *//**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     *//*
    public CustomAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_inventory, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(localDataSet[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}*/
public class Inventory extends AppCompatActivity {
    private Button addItemButton;
    private List<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        //NotificationManager.initialize(getApplicationContext(), "aoljaca");
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //Fragment fragment = fragmentManager.findFragmentById(R.id.list_fragment_container);
        this.items = InventoryDatabase.getInstance(getApplicationContext()).getItems();
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