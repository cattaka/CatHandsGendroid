package net.cattaka.util.cathandsgendroid.test;

import net.cattaka.util.cathandsgendroid.test.model.StringKvModel;
import net.cattaka.util.cathandsgendroid.test.model.StringKvModelCatHands;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import android.database.sqlite.SQLiteDatabase;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@Config(sdk = 8)
@RunWith(RobolectricTestRunner.class)
public class StringKvModelTest {
	@Test
    public void testRun() {
        SQLiteDatabase db = SQLiteDatabase.create(null);
        db.execSQL(StringKvModelCatHands.SQL_CREATE_TABLE);
		
        StringKvModelCatHands.insert(db, new StringKvModel("Cat","Fish"));
        StringKvModelCatHands.insert(db, new StringKvModel("Dog","Meat"));
        StringKvModelCatHands.insert(db, new StringKvModel("Frog","Bug"));
        
        {
	        assertEquals("Fish", StringKvModelCatHands.findByKey(db, "Cat").getValue());
	        assertEquals("Meat", StringKvModelCatHands.findByKey(db, "Dog").getValue());
	        assertEquals("Bug", StringKvModelCatHands.findByKey(db, "Frog").getValue());
        }
        
        assertEquals(1, StringKvModelCatHands.delete(db, "Dog"));
        {
	        assertEquals("Fish", StringKvModelCatHands.findByKey(db, "Cat").getValue());
	        assertNull(StringKvModelCatHands.findByKey(db, "Dog"));
	        assertEquals("Bug", StringKvModelCatHands.findByKey(db, "Frog").getValue());
        }
        
        assertEquals(1, StringKvModelCatHands.update(db, new StringKvModel("Frog", "Snake")));
        {
	        assertEquals("Fish", StringKvModelCatHands.findByKey(db, "Cat").getValue());
	        assertNull(StringKvModelCatHands.findByKey(db, "Dog"));
	        assertEquals("Snake", StringKvModelCatHands.findByKey(db, "Frog").getValue());
        }
        
	}
}
