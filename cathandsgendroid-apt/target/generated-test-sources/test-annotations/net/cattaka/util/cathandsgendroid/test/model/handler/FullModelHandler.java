package net.cattaka.util.cathandsgendroid.test.model.handler;
import net.cattaka.util.cathandsgendroid.Accessor;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import net.cattaka.util.cathandsgendroid.test.model.FullModel;

public class FullModelHandler {
    public static final String SQL_CREATE_TABLE = "CREATE TABLE fullModel(key INTEGER PRIMARY KEY,blobValue BLOB,booleanValue INTEGER,byteValue INTEGER,characterValue INTEGER,dateValue INTEGER,doubleValue REAL,tinyEnum TEXT,floatValue REAL,integerValue INTEGER,longValue INTEGER,pBooleanValue INTEGER,pByteValue INTEGER,pCharValue INTEGER,pDoubleValue REAL,pFloatValue REAL,pIntValue INTEGER,pLongValue INTEGER,pShortValue INTEGER,serializable BLOB,shortValue INTEGER,stringValue TEXT)";
    public static final String TABLE_NAME = "fullModel";
    public static final String COLUMNS = "key,blobValue,booleanValue,byteValue,characterValue,dateValue,doubleValue,tinyEnum,floatValue,integerValue,longValue,pBooleanValue,pByteValue,pCharValue,pDoubleValue,pFloatValue,pIntValue,pLongValue,pShortValue,serializable,shortValue,stringValue";
    public static final String[] COLUMNS_ARRAY = new String[] {"key", "blobValue", "booleanValue", "byteValue", "characterValue", "dateValue", "doubleValue", "tinyEnum", "floatValue", "integerValue", "longValue", "pBooleanValue", "pByteValue", "pCharValue", "pDoubleValue", "pFloatValue", "pIntValue", "pLongValue", "pShortValue", "serializable", "shortValue", "stringValue"};
    public static final int COL_INDEX_KEY = 0;
    public static final int COL_INDEX_BLOB_VALUE = 1;
    public static final int COL_INDEX_BOOLEAN_VALUE = 2;
    public static final int COL_INDEX_BYTE_VALUE = 3;
    public static final int COL_INDEX_CHARACTER_VALUE = 4;
    public static final int COL_INDEX_DATE_VALUE = 5;
    public static final int COL_INDEX_DOUBLE_VALUE = 6;
    public static final int COL_INDEX_TINY_ENUM = 7;
    public static final int COL_INDEX_FLOAT_VALUE = 8;
    public static final int COL_INDEX_INTEGER_VALUE = 9;
    public static final int COL_INDEX_LONG_VALUE = 10;
    public static final int COL_INDEX_P_BOOLEAN_VALUE = 11;
    public static final int COL_INDEX_P_BYTE_VALUE = 12;
    public static final int COL_INDEX_P_CHAR_VALUE = 13;
    public static final int COL_INDEX_P_DOUBLE_VALUE = 14;
    public static final int COL_INDEX_P_FLOAT_VALUE = 15;
    public static final int COL_INDEX_P_INT_VALUE = 16;
    public static final int COL_INDEX_P_LONG_VALUE = 17;
    public static final int COL_INDEX_P_SHORT_VALUE = 18;
    public static final int COL_INDEX_SERIALIZABLE = 19;
    public static final int COL_INDEX_SHORT_VALUE = 20;
    public static final int COL_INDEX_STRING_VALUE = 21;
    public static final String COL_NAME_KEY = "key";
    public static final String COL_NAME_BLOB_VALUE = "blobValue";
    public static final String COL_NAME_BOOLEAN_VALUE = "booleanValue";
    public static final String COL_NAME_BYTE_VALUE = "byteValue";
    public static final String COL_NAME_CHARACTER_VALUE = "characterValue";
    public static final String COL_NAME_DATE_VALUE = "dateValue";
    public static final String COL_NAME_DOUBLE_VALUE = "doubleValue";
    public static final String COL_NAME_TINY_ENUM = "tinyEnum";
    public static final String COL_NAME_FLOAT_VALUE = "floatValue";
    public static final String COL_NAME_INTEGER_VALUE = "integerValue";
    public static final String COL_NAME_LONG_VALUE = "longValue";
    public static final String COL_NAME_P_BOOLEAN_VALUE = "pBooleanValue";
    public static final String COL_NAME_P_BYTE_VALUE = "pByteValue";
    public static final String COL_NAME_P_CHAR_VALUE = "pCharValue";
    public static final String COL_NAME_P_DOUBLE_VALUE = "pDoubleValue";
    public static final String COL_NAME_P_FLOAT_VALUE = "pFloatValue";
    public static final String COL_NAME_P_INT_VALUE = "pIntValue";
    public static final String COL_NAME_P_LONG_VALUE = "pLongValue";
    public static final String COL_NAME_P_SHORT_VALUE = "pShortValue";
    public static final String COL_NAME_SERIALIZABLE = "serializable";
    public static final String COL_NAME_SHORT_VALUE = "shortValue";
    public static final String COL_NAME_STRING_VALUE = "stringValue";
    public static void readCursorByIndex(Cursor cursor, FullModel dest) {
        dest.setKey(Accessor.readPlongFromCursor(cursor, 0, (long)0));
        dest.setBlobValue(Accessor.readBlobFromCursor(cursor, 1));
        dest.setBooleanValue(Accessor.readBooleanFromCursor(cursor, 2));
        dest.setByteValue(Accessor.readByteFromCursor(cursor, 3));
        dest.setCharacterValue(Accessor.readCharacterFromCursor(cursor, 4));
        dest.setDateValue(Accessor.readDateFromCursor(cursor, 5));
        dest.setDoubleValue(Accessor.readDoubleFromCursor(cursor, 6));
        dest.setTinyEnum(Accessor.readEnumFromCursor(cursor, 7, net.cattaka.util.cathandsgendroid.test.model.FullModel.TinyEnum.class));
        dest.setFloatValue(Accessor.readFloatFromCursor(cursor, 8));
        dest.setIntegerValue(Accessor.readIntegerFromCursor(cursor, 9));
        dest.setLongValue(Accessor.readLongFromCursor(cursor, 10));
        dest.setPBooleanValue(Accessor.readPbooleanFromCursor(cursor, 11, false));
        dest.setPByteValue(Accessor.readPbyteFromCursor(cursor, 12, (byte)0));
        dest.setPCharValue(Accessor.readPcharFromCursor(cursor, 13, (char)0));
        dest.setPDoubleValue(Accessor.readPdoubleFromCursor(cursor, 14, 0));
        dest.setPFloatValue(Accessor.readPfloatFromCursor(cursor, 15, (float)0));
        dest.setPIntValue(Accessor.readPintFromCursor(cursor, 16, 0));
        dest.setPLongValue(Accessor.readPlongFromCursor(cursor, 17, (long)0));
        dest.setPShortValue(Accessor.readPshortFromCursor(cursor, 18, (short)0));
        dest.setSerializable(((net.cattaka.util.cathandsgendroid.test.model.TinySerializable)Accessor.readSerializableFromCursor(cursor, 19)));
        dest.setShortValue(Accessor.readShortFromCursor(cursor, 20));
        dest.setStringValue(Accessor.readStringFromCursor(cursor, 21));
    }
    public static FullModel readCursorByIndex(Cursor cursor) {
        FullModel result = new FullModel();
        readCursorByIndex(cursor, result);
        return result;
    }
    public static void readCursorByName(Cursor cursor, FullModel dest) {
        int idx;
        idx = cursor.getColumnIndex("key");
        dest.setKey(Accessor.readPlongFromCursor(cursor, idx, (long)0));
        idx = cursor.getColumnIndex("blobValue");
        dest.setBlobValue(Accessor.readBlobFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("booleanValue");
        dest.setBooleanValue(Accessor.readBooleanFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("byteValue");
        dest.setByteValue(Accessor.readByteFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("characterValue");
        dest.setCharacterValue(Accessor.readCharacterFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("dateValue");
        dest.setDateValue(Accessor.readDateFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("doubleValue");
        dest.setDoubleValue(Accessor.readDoubleFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("tinyEnum");
        dest.setTinyEnum(Accessor.readEnumFromCursor(cursor, idx, net.cattaka.util.cathandsgendroid.test.model.FullModel.TinyEnum.class));
        idx = cursor.getColumnIndex("floatValue");
        dest.setFloatValue(Accessor.readFloatFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("integerValue");
        dest.setIntegerValue(Accessor.readIntegerFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("longValue");
        dest.setLongValue(Accessor.readLongFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("pBooleanValue");
        dest.setPBooleanValue(Accessor.readPbooleanFromCursor(cursor, idx, false));
        idx = cursor.getColumnIndex("pByteValue");
        dest.setPByteValue(Accessor.readPbyteFromCursor(cursor, idx, (byte)0));
        idx = cursor.getColumnIndex("pCharValue");
        dest.setPCharValue(Accessor.readPcharFromCursor(cursor, idx, (char)0));
        idx = cursor.getColumnIndex("pDoubleValue");
        dest.setPDoubleValue(Accessor.readPdoubleFromCursor(cursor, idx, 0));
        idx = cursor.getColumnIndex("pFloatValue");
        dest.setPFloatValue(Accessor.readPfloatFromCursor(cursor, idx, (float)0));
        idx = cursor.getColumnIndex("pIntValue");
        dest.setPIntValue(Accessor.readPintFromCursor(cursor, idx, 0));
        idx = cursor.getColumnIndex("pLongValue");
        dest.setPLongValue(Accessor.readPlongFromCursor(cursor, idx, (long)0));
        idx = cursor.getColumnIndex("pShortValue");
        dest.setPShortValue(Accessor.readPshortFromCursor(cursor, idx, (short)0));
        idx = cursor.getColumnIndex("serializable");
        dest.setSerializable(((net.cattaka.util.cathandsgendroid.test.model.TinySerializable)Accessor.readSerializableFromCursor(cursor, idx)));
        idx = cursor.getColumnIndex("shortValue");
        dest.setShortValue(Accessor.readShortFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("stringValue");
        dest.setStringValue(Accessor.readStringFromCursor(cursor, idx));
    }
    public static FullModel readCursorByName(Cursor cursor) {
        FullModel result = new FullModel();
        readCursorByName(cursor, result);
        return result;
    }
    public static String toStringValue(Object arg) {
        return (arg != null) ? arg.toString() : null;
    }
    public static long insert(SQLiteDatabase db, FullModel model) {
        ContentValues values = new ContentValues();
        Accessor.putPlongToContentValues(values, "key", model.getKey());
        Accessor.putBlobToContentValues(values, "blobValue", model.getBlobValue());
        Accessor.putBooleanToContentValues(values, "booleanValue", model.getBooleanValue());
        Accessor.putByteToContentValues(values, "byteValue", model.getByteValue());
        Accessor.putCharacterToContentValues(values, "characterValue", model.getCharacterValue());
        Accessor.putDateToContentValues(values, "dateValue", model.getDateValue());
        Accessor.putDoubleToContentValues(values, "doubleValue", model.getDoubleValue());
        Accessor.putEnumToContentValues(values, "tinyEnum", model.getTinyEnum());
        Accessor.putFloatToContentValues(values, "floatValue", model.getFloatValue());
        Accessor.putIntegerToContentValues(values, "integerValue", model.getIntegerValue());
        Accessor.putLongToContentValues(values, "longValue", model.getLongValue());
        Accessor.putPbooleanToContentValues(values, "pBooleanValue", model.getPBooleanValue());
        Accessor.putPbyteToContentValues(values, "pByteValue", model.getPByteValue());
        Accessor.putPcharToContentValues(values, "pCharValue", model.getPCharValue());
        Accessor.putPdoubleToContentValues(values, "pDoubleValue", model.getPDoubleValue());
        Accessor.putPfloatToContentValues(values, "pFloatValue", model.getPFloatValue());
        Accessor.putPintToContentValues(values, "pIntValue", model.getPIntValue());
        Accessor.putPlongToContentValues(values, "pLongValue", model.getPLongValue());
        Accessor.putPshortToContentValues(values, "pShortValue", model.getPShortValue());
        Accessor.putSerializableToContentValues(values, "serializable", model.getSerializable());
        Accessor.putShortToContentValues(values, "shortValue", model.getShortValue());
        Accessor.putStringToContentValues(values, "stringValue", model.getStringValue());
        long key = db.insert(TABLE_NAME, null, values);
        return key;
    }
    public static int update(SQLiteDatabase db, FullModel model) {
        ContentValues values = new ContentValues();
        String whereClause = "key=?";
        String[] whereArgs = new String[]{String.valueOf(model.getKey())};
        Accessor.putBlobToContentValues(values, "blobValue", model.getBlobValue());
        Accessor.putBooleanToContentValues(values, "booleanValue", model.getBooleanValue());
        Accessor.putByteToContentValues(values, "byteValue", model.getByteValue());
        Accessor.putCharacterToContentValues(values, "characterValue", model.getCharacterValue());
        Accessor.putDateToContentValues(values, "dateValue", model.getDateValue());
        Accessor.putDoubleToContentValues(values, "doubleValue", model.getDoubleValue());
        Accessor.putEnumToContentValues(values, "tinyEnum", model.getTinyEnum());
        Accessor.putFloatToContentValues(values, "floatValue", model.getFloatValue());
        Accessor.putIntegerToContentValues(values, "integerValue", model.getIntegerValue());
        Accessor.putLongToContentValues(values, "longValue", model.getLongValue());
        Accessor.putPbooleanToContentValues(values, "pBooleanValue", model.getPBooleanValue());
        Accessor.putPbyteToContentValues(values, "pByteValue", model.getPByteValue());
        Accessor.putPcharToContentValues(values, "pCharValue", model.getPCharValue());
        Accessor.putPdoubleToContentValues(values, "pDoubleValue", model.getPDoubleValue());
        Accessor.putPfloatToContentValues(values, "pFloatValue", model.getPFloatValue());
        Accessor.putPintToContentValues(values, "pIntValue", model.getPIntValue());
        Accessor.putPlongToContentValues(values, "pLongValue", model.getPLongValue());
        Accessor.putPshortToContentValues(values, "pShortValue", model.getPShortValue());
        Accessor.putSerializableToContentValues(values, "serializable", model.getSerializable());
        Accessor.putShortToContentValues(values, "shortValue", model.getShortValue());
        Accessor.putStringToContentValues(values, "stringValue", model.getStringValue());
        return db.update(TABLE_NAME, values, whereClause, whereArgs);
    }
    public static int delete(SQLiteDatabase db, long key) {
        String whereClause = "key=?";
        String[] whereArgs = new String[]{String.valueOf(key)};
        return db.delete(TABLE_NAME, whereClause, whereArgs);
    }
    public static java.util.List<FullModel> findByBooleanValue(SQLiteDatabase db, int limit, java.lang.Boolean booleanValue) {
        Cursor cursor = findCursorByBooleanValue(db, limit, booleanValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByByteValue(SQLiteDatabase db, int limit, java.lang.Byte byteValue) {
        Cursor cursor = findCursorByByteValue(db, limit, byteValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByCharacterValue(SQLiteDatabase db, int limit, java.lang.Character characterValue) {
        Cursor cursor = findCursorByCharacterValue(db, limit, characterValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByDateValue(SQLiteDatabase db, int limit, java.util.Date dateValue) {
        Cursor cursor = findCursorByDateValue(db, limit, dateValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByDoubleValue(SQLiteDatabase db, int limit, java.lang.Double doubleValue) {
        Cursor cursor = findCursorByDoubleValue(db, limit, doubleValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByFloatValue(SQLiteDatabase db, int limit, java.lang.Float floatValue) {
        Cursor cursor = findCursorByFloatValue(db, limit, floatValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByIntegerValue(SQLiteDatabase db, int limit, java.lang.Integer integerValue) {
        Cursor cursor = findCursorByIntegerValue(db, limit, integerValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static FullModel findByKey(SQLiteDatabase db, long key) {
        Cursor cursor = findCursorByKey(db, key);
        FullModel model = (cursor.moveToNext()) ? readCursorByIndex(cursor) : null;
        cursor.close();
        return model;
    }
    public static java.util.List<FullModel> findByLongValue(SQLiteDatabase db, int limit, java.lang.Long longValue) {
        Cursor cursor = findCursorByLongValue(db, limit, longValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPBooleanValue(SQLiteDatabase db, int limit, boolean pBooleanValue) {
        Cursor cursor = findCursorByPBooleanValue(db, limit, pBooleanValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPByteValue(SQLiteDatabase db, int limit, byte pByteValue) {
        Cursor cursor = findCursorByPByteValue(db, limit, pByteValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPCharValue(SQLiteDatabase db, int limit, char pCharValue) {
        Cursor cursor = findCursorByPCharValue(db, limit, pCharValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPDoubleValue(SQLiteDatabase db, int limit, double pDoubleValue) {
        Cursor cursor = findCursorByPDoubleValue(db, limit, pDoubleValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPFloatValue(SQLiteDatabase db, int limit, float pFloatValue) {
        Cursor cursor = findCursorByPFloatValue(db, limit, pFloatValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPIntValue(SQLiteDatabase db, int limit, int pIntValue) {
        Cursor cursor = findCursorByPIntValue(db, limit, pIntValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPLongValue(SQLiteDatabase db, int limit, long pLongValue) {
        Cursor cursor = findCursorByPLongValue(db, limit, pLongValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPShortValue(SQLiteDatabase db, int limit, short pShortValue) {
        Cursor cursor = findCursorByPShortValue(db, limit, pShortValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByShortValue(SQLiteDatabase db, int limit, java.lang.Short shortValue) {
        Cursor cursor = findCursorByShortValue(db, limit, shortValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByStringValue(SQLiteDatabase db, int limit, java.lang.String stringValue) {
        Cursor cursor = findCursorByStringValue(db, limit, stringValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByTinyEnum(SQLiteDatabase db, int limit, net.cattaka.util.cathandsgendroid.test.model.FullModel.TinyEnum tinyEnum) {
        Cursor cursor = findCursorByTinyEnum(db, limit, tinyEnum);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static Cursor findCursorByBooleanValue(SQLiteDatabase db, int limit, java.lang.Boolean booleanValue) {
        String selection = "booleanValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(booleanValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByByteValue(SQLiteDatabase db, int limit, java.lang.Byte byteValue) {
        String selection = "byteValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(byteValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByCharacterValue(SQLiteDatabase db, int limit, java.lang.Character characterValue) {
        String selection = "characterValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(characterValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByDateValue(SQLiteDatabase db, int limit, java.util.Date dateValue) {
        String selection = "dateValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(dateValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByDoubleValue(SQLiteDatabase db, int limit, java.lang.Double doubleValue) {
        String selection = "doubleValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(doubleValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByFloatValue(SQLiteDatabase db, int limit, java.lang.Float floatValue) {
        String selection = "floatValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(floatValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByIntegerValue(SQLiteDatabase db, int limit, java.lang.Integer integerValue) {
        String selection = "integerValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(integerValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByKey(SQLiteDatabase db, long key) {
        String selection = "key=?";
        String[] selectionArgs = new String[]{Accessor.toString(key)};
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null);
    }
    public static Cursor findCursorByLongValue(SQLiteDatabase db, int limit, java.lang.Long longValue) {
        String selection = "longValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(longValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByPBooleanValue(SQLiteDatabase db, int limit, boolean pBooleanValue) {
        String selection = "pBooleanValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(pBooleanValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByPByteValue(SQLiteDatabase db, int limit, byte pByteValue) {
        String selection = "pByteValue=?";
        String[] selectionArgs = new String[]{String.valueOf(pByteValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByPCharValue(SQLiteDatabase db, int limit, char pCharValue) {
        String selection = "pCharValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(pCharValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByPDoubleValue(SQLiteDatabase db, int limit, double pDoubleValue) {
        String selection = "pDoubleValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(pDoubleValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByPFloatValue(SQLiteDatabase db, int limit, float pFloatValue) {
        String selection = "pFloatValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(pFloatValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByPIntValue(SQLiteDatabase db, int limit, int pIntValue) {
        String selection = "pIntValue=?";
        String[] selectionArgs = new String[]{String.valueOf(pIntValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByPLongValue(SQLiteDatabase db, int limit, long pLongValue) {
        String selection = "pLongValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(pLongValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByPShortValue(SQLiteDatabase db, int limit, short pShortValue) {
        String selection = "pShortValue=?";
        String[] selectionArgs = new String[]{String.valueOf(pShortValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByShortValue(SQLiteDatabase db, int limit, java.lang.Short shortValue) {
        String selection = "shortValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(shortValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByStringValue(SQLiteDatabase db, int limit, java.lang.String stringValue) {
        String selection = "stringValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(stringValue)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Cursor findCursorByTinyEnum(SQLiteDatabase db, int limit, net.cattaka.util.cathandsgendroid.test.model.FullModel.TinyEnum tinyEnum) {
        String selection = "tinyEnum=?";
        String[] selectionArgs = new String[]{Accessor.toStringName(tinyEnum)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null, limitStr);
    }
    public static Uri insert(ContentResolver resolver, Uri uri, FullModel model) {
        ContentValues values = new ContentValues();
        Accessor.putPlongToContentValues(values, "key", model.getKey());
        Accessor.putBlobToContentValues(values, "blobValue", model.getBlobValue());
        Accessor.putBooleanToContentValues(values, "booleanValue", model.getBooleanValue());
        Accessor.putByteToContentValues(values, "byteValue", model.getByteValue());
        Accessor.putCharacterToContentValues(values, "characterValue", model.getCharacterValue());
        Accessor.putDateToContentValues(values, "dateValue", model.getDateValue());
        Accessor.putDoubleToContentValues(values, "doubleValue", model.getDoubleValue());
        Accessor.putEnumToContentValues(values, "tinyEnum", model.getTinyEnum());
        Accessor.putFloatToContentValues(values, "floatValue", model.getFloatValue());
        Accessor.putIntegerToContentValues(values, "integerValue", model.getIntegerValue());
        Accessor.putLongToContentValues(values, "longValue", model.getLongValue());
        Accessor.putPbooleanToContentValues(values, "pBooleanValue", model.getPBooleanValue());
        Accessor.putPbyteToContentValues(values, "pByteValue", model.getPByteValue());
        Accessor.putPcharToContentValues(values, "pCharValue", model.getPCharValue());
        Accessor.putPdoubleToContentValues(values, "pDoubleValue", model.getPDoubleValue());
        Accessor.putPfloatToContentValues(values, "pFloatValue", model.getPFloatValue());
        Accessor.putPintToContentValues(values, "pIntValue", model.getPIntValue());
        Accessor.putPlongToContentValues(values, "pLongValue", model.getPLongValue());
        Accessor.putPshortToContentValues(values, "pShortValue", model.getPShortValue());
        Accessor.putSerializableToContentValues(values, "serializable", model.getSerializable());
        Accessor.putShortToContentValues(values, "shortValue", model.getShortValue());
        Accessor.putStringToContentValues(values, "stringValue", model.getStringValue());
        return resolver.insert(uri, values);
    }
    public static int update(ContentResolver resolver, Uri uri, FullModel model) {
        ContentValues values = new ContentValues();
        String whereClause = "key=?";
        String[] whereArgs = new String[]{String.valueOf(model.getKey())};
        Accessor.putBlobToContentValues(values, "blobValue", model.getBlobValue());
        Accessor.putBooleanToContentValues(values, "booleanValue", model.getBooleanValue());
        Accessor.putByteToContentValues(values, "byteValue", model.getByteValue());
        Accessor.putCharacterToContentValues(values, "characterValue", model.getCharacterValue());
        Accessor.putDateToContentValues(values, "dateValue", model.getDateValue());
        Accessor.putDoubleToContentValues(values, "doubleValue", model.getDoubleValue());
        Accessor.putEnumToContentValues(values, "tinyEnum", model.getTinyEnum());
        Accessor.putFloatToContentValues(values, "floatValue", model.getFloatValue());
        Accessor.putIntegerToContentValues(values, "integerValue", model.getIntegerValue());
        Accessor.putLongToContentValues(values, "longValue", model.getLongValue());
        Accessor.putPbooleanToContentValues(values, "pBooleanValue", model.getPBooleanValue());
        Accessor.putPbyteToContentValues(values, "pByteValue", model.getPByteValue());
        Accessor.putPcharToContentValues(values, "pCharValue", model.getPCharValue());
        Accessor.putPdoubleToContentValues(values, "pDoubleValue", model.getPDoubleValue());
        Accessor.putPfloatToContentValues(values, "pFloatValue", model.getPFloatValue());
        Accessor.putPintToContentValues(values, "pIntValue", model.getPIntValue());
        Accessor.putPlongToContentValues(values, "pLongValue", model.getPLongValue());
        Accessor.putPshortToContentValues(values, "pShortValue", model.getPShortValue());
        Accessor.putSerializableToContentValues(values, "serializable", model.getSerializable());
        Accessor.putShortToContentValues(values, "shortValue", model.getShortValue());
        Accessor.putStringToContentValues(values, "stringValue", model.getStringValue());
        return resolver.update(uri, values, whereClause, whereArgs);
    }
    public static int delete(ContentResolver resolver, Uri uri, long key) {
        String whereClause = "key=?";
        String[] whereArgs = new String[]{String.valueOf(key)};
        return resolver.delete(uri, whereClause, whereArgs);
    }
    public static java.util.List<FullModel> findByBooleanValue(ContentResolver resolver, Uri uri, java.lang.Boolean booleanValue) {
        Cursor cursor = findCursorByBooleanValue(resolver, uri, booleanValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByByteValue(ContentResolver resolver, Uri uri, java.lang.Byte byteValue) {
        Cursor cursor = findCursorByByteValue(resolver, uri, byteValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByCharacterValue(ContentResolver resolver, Uri uri, java.lang.Character characterValue) {
        Cursor cursor = findCursorByCharacterValue(resolver, uri, characterValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByDateValue(ContentResolver resolver, Uri uri, java.util.Date dateValue) {
        Cursor cursor = findCursorByDateValue(resolver, uri, dateValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByDoubleValue(ContentResolver resolver, Uri uri, java.lang.Double doubleValue) {
        Cursor cursor = findCursorByDoubleValue(resolver, uri, doubleValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByFloatValue(ContentResolver resolver, Uri uri, java.lang.Float floatValue) {
        Cursor cursor = findCursorByFloatValue(resolver, uri, floatValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByIntegerValue(ContentResolver resolver, Uri uri, java.lang.Integer integerValue) {
        Cursor cursor = findCursorByIntegerValue(resolver, uri, integerValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static FullModel findByKey(ContentResolver resolver, Uri uri, long key) {
        Cursor cursor = findCursorByKey(resolver, uri, key);
        FullModel model = (cursor.moveToNext()) ? readCursorByIndex(cursor) : null;
        cursor.close();
        return model;
    }
    public static java.util.List<FullModel> findByLongValue(ContentResolver resolver, Uri uri, java.lang.Long longValue) {
        Cursor cursor = findCursorByLongValue(resolver, uri, longValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPBooleanValue(ContentResolver resolver, Uri uri, boolean pBooleanValue) {
        Cursor cursor = findCursorByPBooleanValue(resolver, uri, pBooleanValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPByteValue(ContentResolver resolver, Uri uri, byte pByteValue) {
        Cursor cursor = findCursorByPByteValue(resolver, uri, pByteValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPCharValue(ContentResolver resolver, Uri uri, char pCharValue) {
        Cursor cursor = findCursorByPCharValue(resolver, uri, pCharValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPDoubleValue(ContentResolver resolver, Uri uri, double pDoubleValue) {
        Cursor cursor = findCursorByPDoubleValue(resolver, uri, pDoubleValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPFloatValue(ContentResolver resolver, Uri uri, float pFloatValue) {
        Cursor cursor = findCursorByPFloatValue(resolver, uri, pFloatValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPIntValue(ContentResolver resolver, Uri uri, int pIntValue) {
        Cursor cursor = findCursorByPIntValue(resolver, uri, pIntValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPLongValue(ContentResolver resolver, Uri uri, long pLongValue) {
        Cursor cursor = findCursorByPLongValue(resolver, uri, pLongValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByPShortValue(ContentResolver resolver, Uri uri, short pShortValue) {
        Cursor cursor = findCursorByPShortValue(resolver, uri, pShortValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByShortValue(ContentResolver resolver, Uri uri, java.lang.Short shortValue) {
        Cursor cursor = findCursorByShortValue(resolver, uri, shortValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByStringValue(ContentResolver resolver, Uri uri, java.lang.String stringValue) {
        Cursor cursor = findCursorByStringValue(resolver, uri, stringValue);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<FullModel> findByTinyEnum(ContentResolver resolver, Uri uri, net.cattaka.util.cathandsgendroid.test.model.FullModel.TinyEnum tinyEnum) {
        Cursor cursor = findCursorByTinyEnum(resolver, uri, tinyEnum);
        java.util.List<FullModel> result = new java.util.ArrayList<FullModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static Cursor findCursorByBooleanValue(ContentResolver resolver, Uri uri, java.lang.Boolean booleanValue) {
        String selection = "booleanValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(booleanValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByByteValue(ContentResolver resolver, Uri uri, java.lang.Byte byteValue) {
        String selection = "byteValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(byteValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByCharacterValue(ContentResolver resolver, Uri uri, java.lang.Character characterValue) {
        String selection = "characterValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(characterValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByDateValue(ContentResolver resolver, Uri uri, java.util.Date dateValue) {
        String selection = "dateValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(dateValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByDoubleValue(ContentResolver resolver, Uri uri, java.lang.Double doubleValue) {
        String selection = "doubleValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(doubleValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByFloatValue(ContentResolver resolver, Uri uri, java.lang.Float floatValue) {
        String selection = "floatValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(floatValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByIntegerValue(ContentResolver resolver, Uri uri, java.lang.Integer integerValue) {
        String selection = "integerValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(integerValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByKey(ContentResolver resolver, Uri uri, long key) {
        String selection = "key=?";
        String[] selectionArgs = new String[]{Accessor.toString(key)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByLongValue(ContentResolver resolver, Uri uri, java.lang.Long longValue) {
        String selection = "longValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(longValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByPBooleanValue(ContentResolver resolver, Uri uri, boolean pBooleanValue) {
        String selection = "pBooleanValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(pBooleanValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByPByteValue(ContentResolver resolver, Uri uri, byte pByteValue) {
        String selection = "pByteValue=?";
        String[] selectionArgs = new String[]{String.valueOf(pByteValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByPCharValue(ContentResolver resolver, Uri uri, char pCharValue) {
        String selection = "pCharValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(pCharValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByPDoubleValue(ContentResolver resolver, Uri uri, double pDoubleValue) {
        String selection = "pDoubleValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(pDoubleValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByPFloatValue(ContentResolver resolver, Uri uri, float pFloatValue) {
        String selection = "pFloatValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(pFloatValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByPIntValue(ContentResolver resolver, Uri uri, int pIntValue) {
        String selection = "pIntValue=?";
        String[] selectionArgs = new String[]{String.valueOf(pIntValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByPLongValue(ContentResolver resolver, Uri uri, long pLongValue) {
        String selection = "pLongValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(pLongValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByPShortValue(ContentResolver resolver, Uri uri, short pShortValue) {
        String selection = "pShortValue=?";
        String[] selectionArgs = new String[]{String.valueOf(pShortValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByShortValue(ContentResolver resolver, Uri uri, java.lang.Short shortValue) {
        String selection = "shortValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(shortValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByStringValue(ContentResolver resolver, Uri uri, java.lang.String stringValue) {
        String selection = "stringValue=?";
        String[] selectionArgs = new String[]{Accessor.toString(stringValue)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static Cursor findCursorByTinyEnum(ContentResolver resolver, Uri uri, net.cattaka.util.cathandsgendroid.test.model.FullModel.TinyEnum tinyEnum) {
        String selection = "tinyEnum=?";
        String[] selectionArgs = new String[]{Accessor.toStringName(tinyEnum)};
        return resolver.query(uri, COLUMNS_ARRAY, selection, selectionArgs, null);
    }
    public static final Parcelable.Creator<FullModel> CREATOR = new Parcelable.Creator<FullModel>() {
        @Override
        public FullModel createFromParcel(Parcel in) {
            FullModel dest = new FullModel();
            readFromParcel(dest, in);
            return dest;
        }
        @Override
        public FullModel[] newArray(int size) {
            return new FullModel[size];
        }
    };
    public static void readFromParcel(FullModel dest, Parcel in) {
                dest.setKey(Accessor.readPlongFromParcel(in));
                dest.setBlobValue(Accessor.readBlobFromParcel(in));
                dest.setBooleanValue(Accessor.readBooleanFromParcel(in));
                dest.setByteValue(Accessor.readByteFromParcel(in));
                dest.setCharacterValue(Accessor.readCharacterFromParcel(in));
                dest.setDateValue(Accessor.readDateFromParcel(in));
                dest.setDoubleValue(Accessor.readDoubleFromParcel(in));
                dest.setTinyEnum(Accessor.readEnumFromParcel(in, net.cattaka.util.cathandsgendroid.test.model.FullModel.TinyEnum.class));
                dest.setFloatValue(Accessor.readFloatFromParcel(in));
                dest.setIntegerValue(Accessor.readIntegerFromParcel(in));
                dest.setLongValue(Accessor.readLongFromParcel(in));
                dest.setPBooleanValue(Accessor.readPbooleanFromParcel(in));
                dest.setPByteValue(Accessor.readPbyteFromParcel(in));
                dest.setPCharValue(Accessor.readPcharFromParcel(in));
                dest.setPDoubleValue(Accessor.readPdoubleFromParcel(in));
                dest.setPFloatValue(Accessor.readPfloatFromParcel(in));
                dest.setPIntValue(Accessor.readPintFromParcel(in));
                dest.setPLongValue(Accessor.readPlongFromParcel(in));
                dest.setPShortValue(Accessor.readPshortFromParcel(in));
                dest.setSerializable(((net.cattaka.util.cathandsgendroid.test.model.TinySerializable)Accessor.readSerializableFromParcel(in)));
                dest.setShortValue(Accessor.readShortFromParcel(in));
                dest.setStringValue(Accessor.readStringFromParcel(in));
    }
    public static void writeToParcel(FullModel src, Parcel out, int flags) {
        Accessor.writePlongToParcel(out, src.getKey());
        Accessor.writeBlobToParcel(out, src.getBlobValue());
        Accessor.writeBooleanToParcel(out, src.getBooleanValue());
        Accessor.writeByteToParcel(out, src.getByteValue());
        Accessor.writeCharacterToParcel(out, src.getCharacterValue());
        Accessor.writeDateToParcel(out, src.getDateValue());
        Accessor.writeDoubleToParcel(out, src.getDoubleValue());
        Accessor.writeEnumToParcel(out, src.getTinyEnum());
        Accessor.writeFloatToParcel(out, src.getFloatValue());
        Accessor.writeIntegerToParcel(out, src.getIntegerValue());
        Accessor.writeLongToParcel(out, src.getLongValue());
        Accessor.writePbooleanToParcel(out, src.getPBooleanValue());
        Accessor.writePbyteToParcel(out, src.getPByteValue());
        Accessor.writePcharToParcel(out, src.getPCharValue());
        Accessor.writePdoubleToParcel(out, src.getPDoubleValue());
        Accessor.writePfloatToParcel(out, src.getPFloatValue());
        Accessor.writePintToParcel(out, src.getPIntValue());
        Accessor.writePlongToParcel(out, src.getPLongValue());
        Accessor.writePshortToParcel(out, src.getPShortValue());
        Accessor.writeSerializableToParcel(out, src.getSerializable());
        Accessor.writeShortToParcel(out, src.getShortValue());
        Accessor.writeStringToParcel(out, src.getStringValue());
    }
}
