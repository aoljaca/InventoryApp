package com.CS_370.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class NotificationManager {

    private static SharedPreferences sharedPref;
    private static SharedPreferences.Editor editor;
    private static final String INFO = "notification_prefs";
    private static NotificationManager instance;

    private String username;

    private NotificationManager(Context context, String username) {
        this.username = username;
        sharedPref = context.getSharedPreferences(INFO, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.apply();
    }

    public static void initialize(Context context, String username) {
        if (instance == null) {
            instance = new NotificationManager(context, username);
        }
    }

    public static NotificationManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Notification Manager Has Not Been Initialized");
        }
        return instance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void saveNotificationPreference(boolean isEnabled) {
        editor.putBoolean(username, isEnabled);
        editor.apply();
    }

    public boolean getNotificationPreference() {
        return sharedPref.getBoolean(username, false);
    }

    public void removeNotificationPreference() {
        if (sharedPref.contains(username)) {
            editor.remove(username);
            editor.apply();
        }
    }
}