package net.cattaka.util.cathandsgendroid.test.model.handler;
import net.cattaka.util.cathandsgendroid.Accessor;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import net.cattaka.util.cathandsgendroid.test.model.UserModel;

public class UserModelHandler {
    public static final String SQL_CREATE_TABLE = "CREATE TABLE userModel(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,nickname TEXT,team TEXT,role TEXT,createdAt INTEGER,tags BLOB,authority INTEGER,blob BLOB,booleanData INTEGER,byteData INTEGER,charData INTEGER,UNIQUE(username))";
    public static final String[] SQL_ALTER_TABLE_1_TO_2 = new String[] {
        "ALTER TABLE userModel ADD COLUMN nickname TEXT",
        "ALTER TABLE userModel ADD COLUMN team TEXT",
    };
    public static final String[] SQL_ALTER_TABLE_2_TO_3 = new String[] {
        "ALTER TABLE userModel ADD COLUMN authority INTEGER",
    };
    public static final String TABLE_NAME = "userModel";
    public static final String COLUMNS = "id,username,nickname,team,role,createdAt,tags,authority,blob,booleanData,byteData,charData";
    public static final String[] COLUMNS_ARRAY = new String[] {"id", "username", "nickname", "team", "role", "createdAt", "tags", "authority", "blob", "booleanData", "byteData", "charData"};
    public static final int COL_INDEX_ID = 0;
    public static final int COL_INDEX_USERNAME = 1;
    public static final int COL_INDEX_NICKNAME = 2;
    public static final int COL_INDEX_TEAM = 3;
    public static final int COL_INDEX_ROLE = 4;
    public static final int COL_INDEX_CREATED_AT = 5;
    public static final int COL_INDEX_TAGS = 6;
    public static final int COL_INDEX_AUTHORITY = 7;
    public static final int COL_INDEX_BLOB = 8;
    public static final int COL_INDEX_BOOLEAN_DATA = 9;
    public static final int COL_INDEX_BYTE_DATA = 10;
    public static final int COL_INDEX_CHAR_DATA = 11;
    public static final String COL_NAME_ID = "id";
    public static final String COL_NAME_USERNAME = "username";
    public static final String COL_NAME_NICKNAME = "nickname";
    public static final String COL_NAME_TEAM = "team";
    public static final String COL_NAME_ROLE = "role";
    public static final String COL_NAME_CREATED_AT = "createdAt";
    public static final String COL_NAME_TAGS = "tags";
    public static final String COL_NAME_AUTHORITY = "authority";
    public static final String COL_NAME_BLOB = "blob";
    public static final String COL_NAME_BOOLEAN_DATA = "booleanData";
    public static final String COL_NAME_BYTE_DATA = "byteData";
    public static final String COL_NAME_CHAR_DATA = "charData";
    public static void readCursorByIndex(Cursor cursor, UserModel dest) {
        dest.setId(Accessor.readLongFromCursor(cursor, 0));
        dest.setUsername(Accessor.readStringFromCursor(cursor, 1));
        dest.setNickname(Accessor.readStringFromCursor(cursor, 2));
        dest.setTeam(Accessor.readStringFromCursor(cursor, 3));
        dest.setRole(Accessor.readEnumFromCursor(cursor, 4, net.cattaka.util.cathandsgendroid.test.model.UserModel.Role.class));
        dest.setCreatedAt(Accessor.readDateFromCursor(cursor, 5));
        dest.setTags(net.cattaka.util.cathandsgendroid.test.model.coder.StringArrayCoder.decode(Accessor.readBlobFromCursor(cursor, 6)));
        dest.setAuthority(net.cattaka.util.cathandsgendroid.test.model.coder.AuthorityCoder.decode(Accessor.readIntegerFromCursor(cursor, 7)));
        dest.setBlob(Accessor.readBlobFromCursor(cursor, 8));
        dest.setBooleanData(Accessor.readBooleanFromCursor(cursor, 9));
        dest.setByteData(Accessor.readByteFromCursor(cursor, 10));
        dest.setCharData(Accessor.readCharacterFromCursor(cursor, 11));
    }
    public static UserModel readCursorByIndex(Cursor cursor) {
        UserModel result = new UserModel();
        readCursorByIndex(cursor, result);
        return result;
    }
    public static void readCursorByName(Cursor cursor, UserModel dest) {
        int idx;
        idx = cursor.getColumnIndex("id");
        dest.setId(Accessor.readLongFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("username");
        dest.setUsername(Accessor.readStringFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("nickname");
        dest.setNickname(Accessor.readStringFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("team");
        dest.setTeam(Accessor.readStringFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("role");
        dest.setRole(Accessor.readEnumFromCursor(cursor, idx, net.cattaka.util.cathandsgendroid.test.model.UserModel.Role.class));
        idx = cursor.getColumnIndex("createdAt");
        dest.setCreatedAt(Accessor.readDateFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("tags");
        dest.setTags(net.cattaka.util.cathandsgendroid.test.model.coder.StringArrayCoder.decode(Accessor.readBlobFromCursor(cursor, idx)));
        idx = cursor.getColumnIndex("authority");
        dest.setAuthority(net.cattaka.util.cathandsgendroid.test.model.coder.AuthorityCoder.decode(Accessor.readIntegerFromCursor(cursor, idx)));
        idx = cursor.getColumnIndex("blob");
        dest.setBlob(Accessor.readBlobFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("booleanData");
        dest.setBooleanData(Accessor.readBooleanFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("byteData");
        dest.setByteData(Accessor.readByteFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("charData");
        dest.setCharData(Accessor.readCharacterFromCursor(cursor, idx));
    }
    public static UserModel readCursorByName(Cursor cursor) {
        UserModel result = new UserModel();
        readCursorByName(cursor, result);
        return result;
    }
    public static String toStringValue(Object arg) {
        return (arg != null) ? arg.toString() : null;
    }
    public static long insert(SQLiteDatabase db, UserModel model) {
        ContentValues values = new ContentValues();
        Accessor.putStringToContentValues(values, "username", model.getUsername());
        Accessor.putStringToContentValues(values, "nickname", model.getNickname());
        Accessor.putStringToContentValues(values, "team", model.getTeam());
        Accessor.putEnumToContentValues(values, "role", model.getRole());
        Accessor.putDateToContentValues(values, "createdAt", model.getCreatedAt());
        Accessor.putBlobToContentValues(values, "tags", net.cattaka.util.cathandsgendroid.test.model.coder.StringArrayCoder.encode(model.getTags()));
        Accessor.putIntegerToContentValues(values, "authority", net.cattaka.util.cathandsgendroid.test.model.coder.AuthorityCoder.encode(model.getAuthority()));
        Accessor.putBlobToContentValues(values, "blob", model.getBlob());
        Accessor.putBooleanToContentValues(values, "booleanData", model.getBooleanData());
        Accessor.putByteToContentValues(values, "byteData", model.getByteData());
        Accessor.putCharacterToContentValues(values, "charData", model.getCharData());
        long key = db.insert(TABLE_NAME, null, values);
        model.setId((java.lang.Long)key);
        return key;
    }
    public static int update(SQLiteDatabase db, UserModel model) {
        ContentValues values = new ContentValues();
        String whereClause = "id=?";
        String[] whereArgs = new String[]{String.valueOf(model.getId())};
        Accessor.putStringToContentValues(values, "username", model.getUsername());
        Accessor.putStringToContentValues(values, "nickname", model.getNickname());
        Accessor.putStringToContentValues(values, "team", model.getTeam());
        Accessor.putEnumToContentValues(values, "role", model.getRole());
        Accessor.putDateToContentValues(values, "createdAt", model.getCreatedAt());
        Accessor.putBlobToContentValues(values, "tags", net.cattaka.util.cathandsgendroid.test.model.coder.StringArrayCoder.encode(model.getTags()));
        Accessor.putIntegerToContentValues(values, "authority", net.cattaka.util.cathandsgendroid.test.model.coder.AuthorityCoder.encode(model.getAuthority()));
        Accessor.putBlobToContentValues(values, "blob", model.getBlob());
        Accessor.putBooleanToContentValues(values, "booleanData", model.getBooleanData());
        Accessor.putByteToContentValues(values, "byteData", model.getByteData());
        Accessor.putCharacterToContentValues(values, "charData", model.getCharData());
        return db.update(TABLE_NAME, values, whereClause, whereArgs);
    }
    public static int delete(SQLiteDatabase db, java.lang.Long key) {
        String whereClause = "id=?";
        String[] whereArgs = new String[]{String.valueOf(key)};
        return db.delete(TABLE_NAME, whereClause, whereArgs);
    }
    public static UserModel findById(SQLiteDatabase db, java.lang.Long id) {
        Cursor cursor = findCursorById(db, id);
        UserModel model = (cursor.moveToNext()) ? readCursorByIndex(cursor) : null;
        cursor.close();
        return model;
    }
    public static UserModel findByUsername(SQLiteDatabase db, java.lang.String username) {
        Cursor cursor = findCursorByUsername(db, username);
        UserModel model = (cursor.moveToNext()) ? readCursorByIndex(cursor) : null;
        cursor.close();
        return model;
    }
    public static java.util.List<UserModel> findByTeamOrderByRoleAscAndIdAsc(SQLiteDatabase db, int limit, java.lang.String team) {
        Cursor cursor = findCursorByTeamOrderByRoleAscAndIdAsc(db, limit, team);
        java.util.List<UserModel> result = new java.util.ArrayList<UserModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<UserModel> findByTeamOrderByIdDesc(SQLiteDatabase db, int limit, java.lang.String team) {
        Cursor cursor = findCursorByTeamOrderByIdDesc(db, limit, team);
        java.util.List<UserModel> result = new java.util.ArrayList<UserModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<UserModel> findOrderByIdAsc(SQLiteDatabase db, int limit) {
        Cursor cursor = findCursorOrderByIdAsc(db, limit);
        java.util.List<UserModel> result = new java.util.ArrayList<UserModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static java.util.List<UserModel> findByAuthorityOrderByIdAsc(SQLiteDatabase db, int limit, net.cattaka.util.cathandsgendroid.test.model.UserModel.Authority authority) {
        Cursor cursor = findCursorByAuthorityOrderByIdAsc(db, limit, authority);
        java.util.List<UserModel> result = new java.util.ArrayList<UserModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }
    public static Cursor findCursorById(SQLiteDatabase db, java.lang.Long id) {
        String selection = "id=?";
        String[] selectionArgs = new String[]{Accessor.toString(id)};
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null);
    }
    public static Cursor findCursorByUsername(SQLiteDatabase db, java.lang.String username) {
        String selection = "username=?";
        String[] selectionArgs = new String[]{Accessor.toString(username)};
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null);
    }
    public static Cursor findCursorByTeamOrderByRoleAscAndIdAsc(SQLiteDatabase db, int limit, java.lang.String team) {
        String selection = "team=?";
        String[] selectionArgs = new String[]{Accessor.toString(team)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        String orderBy = "role asc, id asc";
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, orderBy, limitStr);
    }
    public static Cursor findCursorByTeamOrderByIdDesc(SQLiteDatabase db, int limit, java.lang.String team) {
        String selection = "team=?";
        String[] selectionArgs = new String[]{Accessor.toString(team)};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        String orderBy = "id desc";
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, orderBy, limitStr);
    }
    public static Cursor findCursorOrderByIdAsc(SQLiteDatabase db, int limit) {
        String selection = "";
        String[] selectionArgs = new String[]{};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        String orderBy = "id asc";
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, orderBy, limitStr);
    }
    public static Cursor findCursorByAuthorityOrderByIdAsc(SQLiteDatabase db, int limit, net.cattaka.util.cathandsgendroid.test.model.UserModel.Authority authority) {
        String selection = "authority=?";
        String[] selectionArgs = new String[]{Accessor.toString(net.cattaka.util.cathandsgendroid.test.model.coder.AuthorityCoder.encode(authority))};
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;
        String orderBy = "id asc";
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, orderBy, limitStr);
    }
}
