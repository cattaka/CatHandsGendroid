package net.cattaka.util.cathandsgendroid.test;


import android.content.ContentValues;
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
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;

import android.database.sqlite.SQLiteDatabase;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;

@RunWith(RobolectricTestRunner.class)
public class AutoIncrementTest {
	@Test
    public void testPint() {
        SQLiteDatabase db = Mockito.spy(SQLiteDatabase.create(null));
        db.execSQL(PintKeyAiModelCatHands.SQL_CREATE_TABLE);

        PintKeyAiModel m1 = new PintKeyAiModel();
        PintKeyAiModel m2 = new PintKeyAiModel();

        doReturn(1L).when(db).insert(anyString(), isNull(), any(ContentValues.class));
        PintKeyAiModelCatHands.insert(db, m1);
        doReturn(2L).when(db).insert(anyString(), isNull(), any(ContentValues.class));
        PintKeyAiModelCatHands.insert(db, m2);
        
        assertEquals(1, m1.getKey());
        assertEquals(2, m2.getKey());
    }

	@Test
    public void testPlong() {
        SQLiteDatabase db = Mockito.spy(SQLiteDatabase.create(null));
        db.execSQL(PlongKeyAiModelCatHands.SQL_CREATE_TABLE);
        
        PlongKeyAiModel m1 = new PlongKeyAiModel();
        PlongKeyAiModel m2 = new PlongKeyAiModel();

        doReturn(1L).when(db).insert(anyString(), isNull(), any(ContentValues.class));
        PlongKeyAiModelCatHands.insert(db, m1);
        doReturn(2L).when(db).insert(anyString(), isNull(), any(ContentValues.class));
        PlongKeyAiModelCatHands.insert(db, m2);
        
        assertEquals(1, m1.getKey());
        assertEquals(2, m2.getKey());
    }

	@Test
    public void testInt() {
        SQLiteDatabase db = Mockito.spy(SQLiteDatabase.create(null));
        db.execSQL(IntKeyAiModelCatHands.SQL_CREATE_TABLE);
        
        IntKeyAiModel m1 = new IntKeyAiModel();
        IntKeyAiModel m2 = new IntKeyAiModel();

        doReturn(1L).when(db).insert(anyString(), isNull(), any(ContentValues.class));
        IntKeyAiModelCatHands.insert(db, m1);
        doReturn(2L).when(db).insert(anyString(), isNull(), any(ContentValues.class));
        IntKeyAiModelCatHands.insert(db, m2);
        
        assertEquals(Integer.valueOf(1), m1.getKey());
        assertEquals(Integer.valueOf(2), m2.getKey());
    }

	@Test
    public void testLong() {
        SQLiteDatabase db = Mockito.spy(SQLiteDatabase.create(null));
        db.execSQL(LongKeyAiModelCatHands.SQL_CREATE_TABLE);
        
        LongKeyAiModel m1 = new LongKeyAiModel();
        LongKeyAiModel m2 = new LongKeyAiModel();

        doReturn(1L).when(db).insert(anyString(), isNull(), any(ContentValues.class));
        LongKeyAiModelCatHands.insert(db, m1);
        doReturn(2L).when(db).insert(anyString(), isNull(), any(ContentValues.class));
        LongKeyAiModelCatHands.insert(db, m2);
        
        assertEquals(Long.valueOf(1), m1.getKey());
        assertEquals(Long.valueOf(2), m2.getKey());
    }
}
