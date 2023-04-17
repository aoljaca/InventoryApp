package com.CS_370.inventoryapp;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.CS_370.inventoryapp", appContext.getPackageName());
        Item vase = new Item(1, "Vase", "Glass Vase", "aoljaca");
        long itemId = InventoryDatabase.getInstance(appContext).addItem(vase);
        assertTrue(itemId != -1);
        assertTrue(InventoryDatabase.getInstance(appContext).getItems().size() > 0);

        Item updatedVase = new Item(itemId, "Vase", "Ceramic Vase", "aoljaca");
        boolean updated = InventoryDatabase.getInstance(appContext).editItem(itemId, updatedVase);
        assertTrue(updated);

        boolean deleted = InventoryDatabase.getInstance(appContext).deleteItem(itemId);
        assertTrue(deleted);
    }
}