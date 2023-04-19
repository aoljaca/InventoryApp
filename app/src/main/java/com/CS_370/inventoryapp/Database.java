package com.CS_370.inventoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static Database instance;
    private static final String DATABASE_NAME = "data.db";
    private static final int VERSION = 2;

    private String loggedInUsername;
    public static Database getInstance(Context context) {
        if (instance == null) {
            instance = new Database(context);
        }
        return instance;
    }
    private Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + UserTable.TABLE + " (" +
                UserTable.COL_ID + " integer primary key autoincrement, " +
                UserTable.COL_USERNAME + " text," +
                UserTable.COL_PASSWORD + " text," + " unique (username))");
    }
    /** Username Getter
     @param void
     @returns - String
     **/
    public String getUsername() {
        return this.loggedInUsername;
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO
    }
    /** Authenticate Function
     @param username, password - Pass in the username and password
     @returns - boolean
     **/
    public boolean authenticate(String username, String password) {
        boolean isAuthenticated = false;
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from " + UserTable.TABLE + " WHERE " +
                UserTable.COL_USERNAME + " = ? AND " + UserTable.COL_PASSWORD
                + " = ? ";
        Cursor cursor = db.rawQuery(sql, new String[]{username, password});
        if (cursor.moveToFirst()) {
            loggedInUsername = username;
            isAuthenticated = true;
        }
        return isAuthenticated;
    }

    /** Create User Function
     @param username, password - Pass in the username and password
     @returns - long
     **/
    public long createUser(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Database.UserTable.COL_USERNAME, username);
        values.put(Database.UserTable.COL_PASSWORD, password);
        long newId = db.insert(Database.UserTable.TABLE, null, values);
        return newId;
    }

    private static final class UserTable {
        private static final String TABLE = "users";
        private static final String COL_ID = "_id";
        private static final String COL_USERNAME = "username";
        private static final String COL_PASSWORD = "password";
    }
}