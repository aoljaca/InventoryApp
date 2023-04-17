package com.CS_370.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class InventoryDatabase extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "inventory.db";

    private static InventoryDatabase instance;

    private InventoryDatabase(Context context) {super(context, DATABASE_NAME, null, VERSION);}

    public static InventoryDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new InventoryDatabase(context);
        }

        return instance;
    }

    private static final class InventoryTable {
        private static final String TABLE = "inventory";
        private static final String COL_ID = "_id";
        private static final String COL_NAME = "name";
        private static final String COL_DESCRIPTION = "description";
        private static final String COL_USERNAME = "username";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + InventoryDatabase.InventoryTable.TABLE + " (" +
                InventoryDatabase.InventoryTable.COL_ID + " integer primary key autoincrement, " +
                InventoryDatabase.InventoryTable.COL_USERNAME + " text," +
                InventoryDatabase.InventoryTable.COL_DESCRIPTION + " text," +
                InventoryDatabase.InventoryTable.COL_NAME + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + InventoryTable.TABLE);
    }

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + InventoryTable.TABLE;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getInt(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                String username = cursor.getString(3);
                Item item = new Item(id, name, description, username);
                items.add(item);
            } while (cursor.moveToNext());
        }
        return items;
    }

    public Item getItem(long itemId) {
        Item item = null;
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + InventoryTable.TABLE + " WHERE " + InventoryTable.COL_ID + " = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{Long.toString(itemId)});
        if (cursor.moveToFirst()) {
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            String username = cursor.getString(3);
            item = new Item(itemId, name, description, username);
        }
        return item;
    }

    public long addItem(Item item) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InventoryTable.COL_NAME, item.getName());
        values.put(InventoryTable.COL_DESCRIPTION, item.getDescription());
        values.put(InventoryTable.COL_USERNAME, item.getUsername());
        long newId = db.insert(InventoryTable.TABLE, null, values);
        return newId;
    }

    public boolean editItem(long id, Item item) {
        boolean isEdited = false;
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InventoryTable.COL_ID, id);
        values.put(InventoryTable.COL_NAME, item.getName());
        values.put(InventoryTable.COL_DESCRIPTION, item.getDescription());
        values.put(InventoryTable.COL_USERNAME, item.getUsername());
        long result = db.update(InventoryTable.TABLE, values, InventoryTable.COL_ID + " = " + id + " AND " + InventoryTable.COL_USERNAME + " = '" + item.getUsername()+"'", null);
        return result == 1;
    }

    public boolean deleteItem(long id) {
        SQLiteDatabase db = getWritableDatabase();
        int result = db.delete(InventoryTable.TABLE, InventoryTable.COL_ID + " = " + id, null);
        return result == 1;
    }
}