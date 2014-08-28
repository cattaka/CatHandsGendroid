package net.cattaka.util.cathandsgendroid.test;


import net.cattaka.util.cathandsgendroid.test.model.IntKeyAiModel;
import net.cattaka.util.cathandsgendroid.test.model.IntKeyAiModelCatHands;
import net.cattaka.util.cathandsgendroid.test.model.LongKeyAiModel;
import net.cattaka.util.cathandsgendroid.test.model.LongKeyAiModelCatHands;
import net.cattaka.util.cathandsgendroid.test.model.PintKeyAiModel;
import net.cattaka.util.cathandsgendroid.test.model.PintKeyAiModelCatHands;
import net.cattaka.util.cathandsgendroid.test.model.PlongKeyAiModel;
import net.cattaka.util.cathandsgendroid.test.model.PlongKeyAiModelCatHands;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowSQLiteDatabase;

import android.database.sqlite.SQLiteDatabase;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class AutoIncrementTest {
	@Test
    public void testPint() {
        SQLiteDatabase db = ShadowSQLiteDatabase.create(null);
        db.execSQL(PintKeyAiModelCatHands.SQL_CREATE_TABLE);
        
        PintKeyAiModel m1 = new PintKeyAiModel();
        PintKeyAiModel m2 = new PintKeyAiModel();
        
        PintKeyAiModelCatHands.insert(db, m1);
        PintKeyAiModelCatHands.insert(db, m2);
        
        assertEquals(1, m1.getKey());
        assertEquals(2, m2.getKey());
    }

	@Test
    public void testPlong() {
        SQLiteDatabase db = ShadowSQLiteDatabase.create(null);
        db.execSQL(PlongKeyAiModelCatHands.SQL_CREATE_TABLE);
        
        PlongKeyAiModel m1 = new PlongKeyAiModel();
        PlongKeyAiModel m2 = new PlongKeyAiModel();
        
        PlongKeyAiModelCatHands.insert(db, m1);
        PlongKeyAiModelCatHands.insert(db, m2);
        
        assertEquals(1, m1.getKey());
        assertEquals(2, m2.getKey());
    }

	@Test
    public void testInt() {
        SQLiteDatabase db = ShadowSQLiteDatabase.create(null);
        db.execSQL(IntKeyAiModelCatHands.SQL_CREATE_TABLE);
        
        IntKeyAiModel m1 = new IntKeyAiModel();
        IntKeyAiModel m2 = new IntKeyAiModel();
        
        IntKeyAiModelCatHands.insert(db, m1);
        IntKeyAiModelCatHands.insert(db, m2);
        
        assertEquals(Integer.valueOf(1), m1.getKey());
        assertEquals(Integer.valueOf(2), m2.getKey());
    }

	@Test
    public void testLong() {
        SQLiteDatabase db = ShadowSQLiteDatabase.create(null);
        db.execSQL(LongKeyAiModelCatHands.SQL_CREATE_TABLE);
        
        LongKeyAiModel m1 = new LongKeyAiModel();
        LongKeyAiModel m2 = new LongKeyAiModel();
        
        LongKeyAiModelCatHands.insert(db, m1);
        LongKeyAiModelCatHands.insert(db, m2);
        
        assertEquals(Long.valueOf(1), m1.getKey());
        assertEquals(Long.valueOf(2), m2.getKey());
    }
}
