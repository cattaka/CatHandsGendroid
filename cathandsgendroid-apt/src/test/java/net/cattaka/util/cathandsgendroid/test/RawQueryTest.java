package net.cattaka.util.cathandsgendroid.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.cattaka.util.cathandsgendroid.test.model.StringKvModel;
import net.cattaka.util.cathandsgendroid.test.model.StringKvModelCatHands;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowSQLiteDatabase;

import android.database.sqlite.SQLiteDatabase;

@RunWith(RobolectricTestRunner.class)
public class RawQueryTest {
    @Test
    public void testRawQuery() {
        SQLiteDatabase db = ShadowSQLiteDatabase.create(null);
        db.execSQL(StringKvModelCatHands.SQL_CREATE_TABLE);
        {
            StringKvModelCatHands.insert(db, new StringKvModel("key1", "apple"));
            StringKvModelCatHands.insert(db, new StringKvModel("key2", "apple"));
            StringKvModelCatHands.insert(db, new StringKvModel("key3", "banana"));
            StringKvModelCatHands.insert(db, new StringKvModel("key4", "orange"));
        }
        {
            List<StringKvModel> result = StringKvModelCatHands.findByDistinct(db);
            Set<String> values = pickValues(result);
            assertEquals(3, values.size());
            assertTrue(values.contains("apple"));
            assertTrue(values.contains("banana"));
            assertTrue(values.contains("orange"));
        }
        {
            List<StringKvModel> result = StringKvModelCatHands.findByQueryKey(db, "key3");
            assertEquals(1, result.size());
            assertEquals("banana", result.get(0).getValue());
        }
        {
            List<StringKvModel> result = StringKvModelCatHands.findByQueryValue(db, "apple");
            Set<String> values = pickValues(result);
            assertEquals(2, values.size());
            assertTrue(values.contains("key1"));
            assertTrue(values.contains("key2"));
        }
    }
    private Set<String> pickValues(List<StringKvModel> models) {
        Set<String> values = new HashSet<String>();
        for (StringKvModel model : models) {
            values.add(model.getValue());
        }
        return values;
    }
}
