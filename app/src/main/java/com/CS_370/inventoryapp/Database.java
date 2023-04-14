package com.CS_370.inventoryapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static Database instance;
    private static final String DATABASE_NAME = "data.db";
    private static final int VERSION = 2;
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
                UserTable.COL_PASSWORD + " text)");
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO
    }

    public boolean authenticate(String username, String password) {
        boolean isAuthenticated = false;
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from " + UserTable.TABLE + " WHERE " +
                UserTable.COL_USERNAME + " = ? AND " + UserTable.COL_PASSWORD
                + " = ? ";
        Cursor cursor = db.rawQuery(sql, new String[]{username, password});
        if (cursor.moveToFirst()) {
            isAuthenticated = true;
        }
        return isAuthenticated;
    }

    private static final class UserTable {
        private static final String TABLE = "users";
        private static final String COL_ID = "_id";
        private static final String COL_USERNAME = "username";
        private static final String COL_PASSWORD = "password";
    }
}