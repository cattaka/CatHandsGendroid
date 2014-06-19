
package net.cattaka.gendbhandler.test;

import static org.junit.Assert.*;

import java.util.Date;

import net.cattaka.gendbhandler.test.model.FullModel;
import net.cattaka.gendbhandler.test.model.FullModel.TinyEnum;
import net.cattaka.gendbhandler.test.model.TinySerializable;
import net.cattaka.gendbhandler.test.model.handler.FullModelHandler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowParcel;
import org.robolectric.shadows.ShadowSQLiteDatabase;

import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.test.MoreAsserts;

@RunWith(RobolectricTestRunner.class)
public class FullModelTest {
    @Test
    public void testDbFunc() {
        SQLiteDatabase db = ShadowSQLiteDatabase.create(null);
        db.execSQL(FullModelHandler.SQL_CREATE_TABLE);
        FullModel model = new FullModel();
        { // Insert
            model.setKey(567);
            model.setBlobValue(new byte[] {
                    1, 2, 3, 4
            });
            model.setBooleanValue(Boolean.TRUE);
            model.setByteValue((byte)12);
            model.setCharacterValue('C');
            model.setDateValue(new Date());
            model.setDoubleValue(12.34);
            model.setFloatValue((float)56.78);
            model.setIntegerValue(234);
            model.setLongValue(987L);
            // model.setParcelableValue(new TinyParcelable(333));
            model.setPBooleanValue(true);
            model.setPByteValue((byte)13);
            model.setPCharValue('B');
            model.setPDoubleValue(43.21);
            model.setPFloatValue((float)76.54);
            model.setPIntValue(345);
            model.setPLongValue(876L);
            model.setPShortValue((short)132);
            model.setSerializable(new TinySerializable(444));
            model.setShortValue((short)243);
            model.setStringValue("This is it");
            model.setTinyEnum(TinyEnum.A);
            FullModelHandler.insert(db, model);
        }
        {// compare
            FullModel t = FullModelHandler.findByKey(db, model.getKey());
            assertEqualsArray(model.getBlobValue(), t.getBlobValue());
            assertEquals(model.getBooleanValue(), t.getBooleanValue());
            assertEquals(model.getByteValue(), t.getByteValue());
            assertEquals(model.getCharacterValue(), t.getCharacterValue());
            assertEquals(model.getDateValue(), t.getDateValue());
            assertEquals(model.getDoubleValue(), t.getDoubleValue());
            assertEquals(model.getFloatValue(), t.getFloatValue());
            assertEquals(model.getIntegerValue(), t.getIntegerValue());
            assertEquals(model.getKey(), t.getKey());
            assertEquals(model.getLongValue(), t.getLongValue());
            // assertEquals(model.getParcelableValue().getData(),
            // t.getParcelableValue().getData());
            assertEquals(model.getPBooleanValue(), t.getPBooleanValue());
            assertEquals(model.getPByteValue(), t.getPByteValue());
            assertEquals(model.getPCharValue(), t.getPCharValue());
            assertEquals(model.getPDoubleValue(), t.getPDoubleValue(), 0);
            assertEquals(model.getPFloatValue(), t.getPFloatValue(), 0);
            assertEquals(model.getPIntValue(), t.getPIntValue());
            assertEquals(model.getPLongValue(), t.getPLongValue());
            assertEquals(model.getPShortValue(), t.getPShortValue());
            assertEquals(model.getSerializable().getData(), t.getSerializable().getData());
            assertEquals(model.getShortValue(), t.getShortValue());
            assertEquals(model.getStringValue(), t.getStringValue());
            assertEquals(model.getTinyEnum(), t.getTinyEnum());
        }
        {
            assertEquals(1, FullModelHandler.findByBooleanValue(db, 0, model.getBooleanValue())
                    .size());
            assertEquals(1, FullModelHandler.findByByteValue(db, 0, model.getByteValue()).size());
            assertEquals(1, FullModelHandler.findByCharacterValue(db, 0, model.getCharacterValue())
                    .size());
            assertEquals(1, FullModelHandler.findByDateValue(db, 0, model.getDateValue()).size());
            assertEquals(1, FullModelHandler.findByDoubleValue(db, 0, model.getDoubleValue())
                    .size());
            // assertEquals(1,FullModelHandler.findByFloatValue(db, 0,
            // model.getFloatValue()).size());
            assertEquals(1, FullModelHandler.findByIntegerValue(db, 0, model.getIntegerValue())
                    .size());
            assertNotNull(FullModelHandler.findByKey(db, model.getKey()));
            assertEquals(1, FullModelHandler.findByLongValue(db, 0, model.getLongValue()).size());
            assertEquals(1, FullModelHandler.findByPBooleanValue(db, 0, model.getPBooleanValue())
                    .size());
            assertEquals(1, FullModelHandler.findByPByteValue(db, 0, model.getPByteValue()).size());
            assertEquals(1, FullModelHandler.findByPCharValue(db, 0, model.getPCharValue()).size());
            assertEquals(1, FullModelHandler.findByPDoubleValue(db, 0, model.getPDoubleValue())
                    .size());
            // assertEquals(1,FullModelHandler.findByPFloatValue(db, 0,
            // model.getPFloatValue()).size());
            assertEquals(1, FullModelHandler.findByPIntValue(db, 0, model.getPIntValue()).size());
            assertEquals(1, FullModelHandler.findByPLongValue(db, 0, model.getPLongValue()).size());
            assertEquals(1, FullModelHandler.findByPShortValue(db, 0, model.getPShortValue())
                    .size());
            assertEquals(1, FullModelHandler.findByShortValue(db, 0, model.getShortValue()).size());
            assertEquals(1, FullModelHandler.findByStringValue(db, 0, model.getStringValue())
                    .size());
            assertEquals(1, FullModelHandler.findByTinyEnum(db, 0, model.getTinyEnum()).size());
        }
        FullModel model2 = new FullModel();
        { // Update
            model2.setKey(model.getKey());
            model2.setBlobValue(new byte[] {
                    5, 6, 7, 8
            });
            model2.setBooleanValue(Boolean.FALSE);
            model2.setByteValue((byte)112);
            model2.setCharacterValue('D');
            model2.setDateValue(new Date(model.getDateValue().getTime() + 1000));
            model2.setDoubleValue(23.45);
            model2.setFloatValue((float)67.89);
            model2.setIntegerValue(345);
            model2.setLongValue(876L);
            // model2.setParcelableValue(new TinyParcelable(222));
            model2.setPBooleanValue(false);
            model2.setPByteValue((byte)14);
            model2.setPCharValue('A');
            model2.setPDoubleValue(54.32);
            model2.setPFloatValue((float)65.43);
            model2.setPIntValue(456);
            model2.setPLongValue(765L);
            model2.setPShortValue((short)465);
            model2.setSerializable(new TinySerializable(555));
            model2.setShortValue((short)867);
            model2.setStringValue("What's that?");
            model2.setTinyEnum(TinyEnum.B);
            FullModelHandler.update(db, model2);
        }
        {// compare
            FullModel t = FullModelHandler.findByKey(db, model.getKey());
            assertEqualsArray(model2.getBlobValue(), t.getBlobValue());
            assertEquals(model2.getBooleanValue(), t.getBooleanValue());
            assertEquals(model2.getByteValue(), t.getByteValue());
            assertEquals(model2.getCharacterValue(), t.getCharacterValue());
            assertEquals(model2.getDateValue(), t.getDateValue());
            assertEquals(model2.getDoubleValue(), t.getDoubleValue());
            assertEquals(model2.getFloatValue(), t.getFloatValue());
            assertEquals(model2.getIntegerValue(), t.getIntegerValue());
            assertEquals(model2.getKey(), t.getKey());
            assertEquals(model2.getLongValue(), t.getLongValue());
            // assertEquals(model2.getParcelableValue().getData(),
            // t.getParcelableValue().getData());
            assertEquals(model2.getPBooleanValue(), t.getPBooleanValue());
            assertEquals(model2.getPByteValue(), t.getPByteValue());
            assertEquals(model2.getPCharValue(), t.getPCharValue());
            assertEquals(model2.getPDoubleValue(), t.getPDoubleValue(), 0);
            assertEquals(model2.getPFloatValue(), t.getPFloatValue(), 0);
            assertEquals(model2.getPIntValue(), t.getPIntValue());
            assertEquals(model2.getPLongValue(), t.getPLongValue());
            assertEquals(model2.getPShortValue(), t.getPShortValue());
            assertEquals(model2.getSerializable().getData(), t.getSerializable().getData());
            assertEquals(model2.getShortValue(), t.getShortValue());
            assertEquals(model2.getStringValue(), t.getStringValue());
            assertEquals(model2.getTinyEnum(), t.getTinyEnum());
        }
        { // delete
            assertEquals(1, FullModelHandler.delete(db, model.getKey()));
            FullModel t = FullModelHandler.findByKey(db, model.getKey());
            assertNull(t);
        }

        db.close();
    }

    @Test
    public void testDbFunc_null() {
        SQLiteDatabase db = ShadowSQLiteDatabase.create(null);
        db.execSQL(FullModelHandler.SQL_CREATE_TABLE);
        FullModel model = new FullModel();
        { // Insert
            model.setKey(567);
            FullModelHandler.insert(db, model);
        }
        {// compare
            FullModel t = FullModelHandler.findByKey(db, model.getKey());
            assertEquals(model.getBlobValue(), t.getBlobValue());
            assertEquals(model.getBooleanValue(), t.getBooleanValue());
            assertEquals(model.getByteValue(), t.getByteValue());
            assertEquals(model.getCharacterValue(), t.getCharacterValue());
            assertEquals(model.getDateValue(), t.getDateValue());
            assertEquals(model.getDoubleValue(), t.getDoubleValue());
            assertEquals(model.getFloatValue(), t.getFloatValue());
            assertEquals(model.getIntegerValue(), t.getIntegerValue());
            assertEquals(model.getKey(), t.getKey());
            assertEquals(model.getLongValue(), t.getLongValue());
            // assertEquals(model.getParcelableValue(), t.getParcelableValue());
            assertEquals(model.getPBooleanValue(), t.getPBooleanValue());
            assertEquals(model.getPByteValue(), t.getPByteValue());
            assertEquals(model.getPCharValue(), t.getPCharValue());
            assertEquals(model.getPDoubleValue(), t.getPDoubleValue(), 0);
            assertEquals(model.getPFloatValue(), t.getPFloatValue(), 0);
            assertEquals(model.getPIntValue(), t.getPIntValue());
            assertEquals(model.getPLongValue(), t.getPLongValue());
            assertEquals(model.getPShortValue(), t.getPShortValue());
            assertEquals(model.getSerializable(), t.getSerializable());
            assertEquals(model.getShortValue(), t.getShortValue());
            assertEquals(model.getStringValue(), t.getStringValue());
            assertEquals(model.getTinyEnum(), t.getTinyEnum());
        }
    }

    @Test
    public void testParcelFunc() {
        FullModel model = new FullModel();
        { // create
            model.setKey(567);
            model.setBlobValue(new byte[] {
                    1, 2, 3, 4
            });
            model.setBooleanValue(Boolean.TRUE);
            model.setByteValue((byte)12);
            model.setCharacterValue('C');
            model.setDateValue(new Date());
            model.setDoubleValue(12.34);
            model.setFloatValue((float)56.78);
            model.setIntegerValue(234);
            model.setLongValue(987L);
            // model.setParcelableValue(new TinyParcelable(333));
            model.setPBooleanValue(true);
            model.setPByteValue((byte)13);
            model.setPCharValue('B');
            model.setPDoubleValue(43.21);
            model.setPFloatValue((float)76.54);
            model.setPIntValue(345);
            model.setPLongValue(876L);
            model.setPShortValue((short)132);
            model.setSerializable(new TinySerializable(444));
            model.setShortValue((short)243);
            model.setStringValue("This is it");
            model.setTinyEnum(TinyEnum.A);
        }

        Parcel parcel;
        {
            parcel = Robolectric.newInstanceOf(Parcel.class);
            parcel.writeParcelable(model, 0);
        }
        {
            FullModel t = parcel.readParcelable(this.getClass().getClassLoader());
            parcel.recycle();
            assertEqualsArray(model.getBlobValue(), t.getBlobValue());
            assertEquals(model.getBooleanValue(), t.getBooleanValue());
            assertEquals(model.getByteValue(), t.getByteValue());
            assertEquals(model.getCharacterValue(), t.getCharacterValue());
            assertEquals(model.getDateValue(), t.getDateValue());
            assertEquals(model.getDoubleValue(), t.getDoubleValue());
            assertEquals(model.getFloatValue(), t.getFloatValue());
            assertEquals(model.getIntegerValue(), t.getIntegerValue());
            assertEquals(model.getKey(), t.getKey());
            assertEquals(model.getLongValue(), t.getLongValue());
            // assertEquals(model.getParcelableValue().getData(),
            // t.getParcelableValue().getData());
            assertEquals(model.getPBooleanValue(), t.getPBooleanValue());
            assertEquals(model.getPByteValue(), t.getPByteValue());
            assertEquals(model.getPCharValue(), t.getPCharValue());
            assertEquals(model.getPDoubleValue(), t.getPDoubleValue(), 0);
            assertEquals(model.getPFloatValue(), t.getPFloatValue(), 0);
            assertEquals(model.getPIntValue(), t.getPIntValue());
            assertEquals(model.getPLongValue(), t.getPLongValue());
            assertEquals(model.getPShortValue(), t.getPShortValue());
            assertEquals(model.getSerializable().getData(), t.getSerializable().getData());
            assertEquals(model.getShortValue(), t.getShortValue());
            assertEquals(model.getStringValue(), t.getStringValue());
            assertEquals(model.getTinyEnum(), t.getTinyEnum());
        }
    }

    @Test
    public void testParcelFunc_null() {
        FullModel model = new FullModel();

        Parcel parcel;
        {
            parcel = ShadowParcel.obtain();
            parcel.writeParcelable(model, 0);
        }
        {
            parcel.setDataPosition(0);
            FullModel t = parcel.readParcelable(this.getClass().getClassLoader());
            parcel.recycle();
            assertEquals(model.getBlobValue(), t.getBlobValue());
            assertEquals(model.getBooleanValue(), t.getBooleanValue());
            assertEquals(model.getByteValue(), t.getByteValue());
            assertEquals(model.getCharacterValue(), t.getCharacterValue());
            assertEquals(model.getDateValue(), t.getDateValue());
            assertEquals(model.getDoubleValue(), t.getDoubleValue());
            assertEquals(model.getFloatValue(), t.getFloatValue());
            assertEquals(model.getIntegerValue(), t.getIntegerValue());
            assertEquals(model.getKey(), t.getKey());
            assertEquals(model.getLongValue(), t.getLongValue());
            // assertEquals(model.getParcelableValue(), t.getParcelableValue());
            assertEquals(model.getPBooleanValue(), t.getPBooleanValue());
            assertEquals(model.getPByteValue(), t.getPByteValue());
            assertEquals(model.getPCharValue(), t.getPCharValue());
            assertEquals(model.getPDoubleValue(), t.getPDoubleValue(), 0);
            assertEquals(model.getPFloatValue(), t.getPFloatValue(), 0);
            assertEquals(model.getPIntValue(), t.getPIntValue());
            assertEquals(model.getPLongValue(), t.getPLongValue());
            assertEquals(model.getPShortValue(), t.getPShortValue());
            assertEquals(model.getSerializable(), t.getSerializable());
            assertEquals(model.getShortValue(), t.getShortValue());
            assertEquals(model.getStringValue(), t.getStringValue());
            assertEquals(model.getTinyEnum(), t.getTinyEnum());
        }
    }
    private void assertEqualsArray(byte[] b1, byte[] b2) {
    	if (b1 == b2) {
    		// ok
    	} else if (b1 != null) {
    		if (b2 != null) {
    			if (b1.length == b2.length) {
    				for (int i=0;i<b1.length;i++) {
    					if (b1[i] == b2[i]) {
    						// ok
    					} else {
    	        	    	fail();
    					}
    				}
    			} else {
        	    	fail();
    			}
    		} else {
    	    	fail();
    		}
    	} else {
    		if (b2 != null) {
    	    	fail();
    		} else {
    			// ok
    		}
    	}
    }
}
