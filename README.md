CatHandsGendroid
================

Lightweight utility generator for Android.
I'm a pain it is to create the some accessor in Android.
When you add annotations to your class, CatHandsGendroid simply create some accessor.
This provide follow utility classes.

* Generate DB, Parcel utility classes.
* Generate Utility classes for handler

## Documents

[Please look at Wiki](https://github.com/cattaka/CatHandsGendroid/wiki)

## Sample Application

[FastCheckList](https://github.com/cattaka/FastCheckList)

## Generate DB, Parcel utility classes.
When you have following class, it has @DataModel and @DataModelAttr annotations.
```java
package net.cattaka.util.cathandsgendroid.test.model;

import java.util.Date;
import java.util.List;

import net.cattaka.util.cathandsgendroid.accessor.EnumOrderAccessor;
import net.cattaka.util.cathandsgendroid.annotation.DataModel;
import net.cattaka.util.cathandsgendroid.annotation.DataModelAttrs;

@DataModel(find = {
        "id", "username", "team:role+,id", "team:id-", ":id", "authority:id+"
}, unique = {
    "username"
})
public class UserModel {
    public enum Role {
        PROGRAMMER, DESIGNNER, MANAGER
    }

    public enum Authority {
        USER, ADMIN
    }

    @DataModelAttrs(primaryKey = true)
    private Long id;

    private String username;

    @DataModelAttrs(version = 2)
    private String nickname;

    @DataModelAttrs(version = 2)
    private String team;

    private Role role;

    private Date createdAt;

    private List<String> tags;

    @DataModelAttrs(version = 3, accessor = EnumOrderAccessor.class)
    private Authority authority;

    @DataModelAttrs(ignore = true)
    private Object userData;

    private byte[] blob;

    private Boolean booleanData;

    private Byte byteData;

    private Character charData;

    public UserModel() {
    }

    /** Getters and Setters */
}
```

Following utility class is generated by APT.
```java

package net.cattaka.util.cathandsgendroid.test.model;
import net.cattaka.util.cathandsgendroid.accessor.IAccessor;
import net.cattaka.util.cathandsgendroid.accessor.Accessors;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * This class is auto-generated by APT; please do not edit by hand.
 */
public class UserModelCatHands {
    public static final IAccessor<Long> ACCESSOR_ID;
    public static final IAccessor<String> ACCESSOR_USERNAME;
    public static final IAccessor<String> ACCESSOR_NICKNAME;
    public static final IAccessor<String> ACCESSOR_TEAM;
    public static final IAccessor<net.cattaka.util.cathandsgendroid.test.model.UserModel.Role> ACCESSOR_ROLE;
    public static final IAccessor<java.util.Date> ACCESSOR_CREATED_AT;
    public static final IAccessor<java.util.List<String>> ACCESSOR_TAGS;
    public static final IAccessor<net.cattaka.util.cathandsgendroid.test.model.UserModel.Authority> ACCESSOR_AUTHORITY;
    public static final IAccessor<byte[]> ACCESSOR_BLOB;
    public static final IAccessor<Boolean> ACCESSOR_BOOLEAN_DATA;
    public static final IAccessor<Byte> ACCESSOR_BYTE_DATA;
    public static final IAccessor<Character> ACCESSOR_CHAR_DATA;
    static {
        ACCESSOR_ID = Accessors.LongAccessor.createAccessor(Long.class);
        ACCESSOR_USERNAME = Accessors.StringAccessor.createAccessor(String.class);
        ACCESSOR_NICKNAME = Accessors.StringAccessor.createAccessor(String.class);
        ACCESSOR_TEAM = Accessors.StringAccessor.createAccessor(String.class);
        ACCESSOR_ROLE = net.cattaka.util.cathandsgendroid.accessor.EnumNameAccessor
                .createAccessor(net.cattaka.util.cathandsgendroid.test.model.UserModel.Role.class);
        ACCESSOR_CREATED_AT = Accessors.DateAccessor.createAccessor(java.util.Date.class);
        ACCESSOR_TAGS = Accessors.createListAccessor(Accessors.StringAccessor
                .createAccessor(String.class));
        ACCESSOR_AUTHORITY = net.cattaka.util.cathandsgendroid.accessor.EnumOrderAccessor
                .createAccessor(net.cattaka.util.cathandsgendroid.test.model.UserModel.Authority.class);
        ACCESSOR_BLOB = Accessors.BlobAccessor.createAccessor(byte[].class);
        ACCESSOR_BOOLEAN_DATA = Accessors.BooleanAccessor.createAccessor(Boolean.class);
        ACCESSOR_BYTE_DATA = Accessors.ByteAccessor.createAccessor(Byte.class);
        ACCESSOR_CHAR_DATA = Accessors.CharacterAccessor.createAccessor(Character.class);
    }
    public static final String SQL_CREATE_TABLE = "CREATE TABLE userModel(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,nickname TEXT,team TEXT,role TEXT,createdAt INTEGER,tags BLOB,authority INTEGER,blob BLOB,booleanData INTEGER,byteData INTEGER,charData INTEGER)";
    public static final String[] SQL_ALTER_TABLE_1_TO_2 = new String[] {
            "ALTER TABLE userModel ADD COLUMN nickname TEXT",
            "ALTER TABLE userModel ADD COLUMN team TEXT",
    };
    public static final String[] SQL_ALTER_TABLE_2_TO_3 = new String[] {
        "ALTER TABLE userModel ADD COLUMN authority INTEGER",
    };
    public static void upgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            for (String sql : SQL_ALTER_TABLE_1_TO_2) {
                db.execSQL(sql);
            }
        }
        if (oldVersion < 3) {
            for (String sql : SQL_ALTER_TABLE_2_TO_3) {
                db.execSQL(sql);
            }
        }
    };
    public static final String TABLE_NAME = "userModel";
    public static final String COLUMNS = "id,username,nickname,team,role,createdAt,tags,authority,blob,booleanData,byteData,charData";
    public static final String[] COLUMNS_ARRAY = new String[] {
            "id", "username", "nickname", "team", "role", "createdAt", "tags", "authority", "blob",
            "booleanData", "byteData", "charData"
    };
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

        dest.setId(ACCESSOR_ID.readFromCursor(cursor, 0));
        dest.setUsername(ACCESSOR_USERNAME.readFromCursor(cursor, 1));
        dest.setNickname(ACCESSOR_NICKNAME.readFromCursor(cursor, 2));
        dest.setTeam(ACCESSOR_TEAM.readFromCursor(cursor, 3));
        dest.setRole(ACCESSOR_ROLE.readFromCursor(cursor, 4));
        dest.setCreatedAt(ACCESSOR_CREATED_AT.readFromCursor(cursor, 5));
        dest.setTags(ACCESSOR_TAGS.readFromCursor(cursor, 6));
        dest.setAuthority(ACCESSOR_AUTHORITY.readFromCursor(cursor, 7));
        dest.setBlob(ACCESSOR_BLOB.readFromCursor(cursor, 8));
        dest.setBooleanData(ACCESSOR_BOOLEAN_DATA.readFromCursor(cursor, 9));
        dest.setByteData(ACCESSOR_BYTE_DATA.readFromCursor(cursor, 10));
        dest.setCharData(ACCESSOR_CHAR_DATA.readFromCursor(cursor, 11));
    }

    public static UserModel readCursorByIndex(Cursor cursor) {
        UserModel result = new UserModel();
        readCursorByIndex(cursor, result);
        return result;
    }

    public static void readCursorByName(Cursor cursor, UserModel dest) {
        int idx;

        idx = cursor.getColumnIndex("id");
        dest.setId(ACCESSOR_ID.readFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("username");
        dest.setUsername(ACCESSOR_USERNAME.readFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("nickname");
        dest.setNickname(ACCESSOR_NICKNAME.readFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("team");
        dest.setTeam(ACCESSOR_TEAM.readFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("role");
        dest.setRole(ACCESSOR_ROLE.readFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("createdAt");
        dest.setCreatedAt(ACCESSOR_CREATED_AT.readFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("tags");
        dest.setTags(ACCESSOR_TAGS.readFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("authority");
        dest.setAuthority(ACCESSOR_AUTHORITY.readFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("blob");
        dest.setBlob(ACCESSOR_BLOB.readFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("booleanData");
        dest.setBooleanData(ACCESSOR_BOOLEAN_DATA.readFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("byteData");
        dest.setByteData(ACCESSOR_BYTE_DATA.readFromCursor(cursor, idx));
        idx = cursor.getColumnIndex("charData");
        dest.setCharData(ACCESSOR_CHAR_DATA.readFromCursor(cursor, idx));
    }

    public static UserModel readCursorByName(Cursor cursor) {
        UserModel result = new UserModel();
        readCursorByName(cursor, result);
        return result;
    }

    public static void putToContentValues(ContentValues dest, UserModel model,
            boolean withPrimaryKey) {
        if (withPrimaryKey) {
            ACCESSOR_ID.putToContentValues(dest, "id", model.getId());
        }

        ACCESSOR_USERNAME.putToContentValues(dest, "username", model.getUsername());
        ACCESSOR_NICKNAME.putToContentValues(dest, "nickname", model.getNickname());
        ACCESSOR_TEAM.putToContentValues(dest, "team", model.getTeam());
        ACCESSOR_ROLE.putToContentValues(dest, "role", model.getRole());
        ACCESSOR_CREATED_AT.putToContentValues(dest, "createdAt", model.getCreatedAt());
        ACCESSOR_TAGS.putToContentValues(dest, "tags", model.getTags());
        ACCESSOR_AUTHORITY.putToContentValues(dest, "authority", model.getAuthority());
        ACCESSOR_BLOB.putToContentValues(dest, "blob", model.getBlob());
        ACCESSOR_BOOLEAN_DATA.putToContentValues(dest, "booleanData", model.getBooleanData());
        ACCESSOR_BYTE_DATA.putToContentValues(dest, "byteData", model.getByteData());
        ACCESSOR_CHAR_DATA.putToContentValues(dest, "charData", model.getCharData());
    }

    public static long insert(SQLiteDatabase db, UserModel model) {
        ContentValues values = new ContentValues();
        putToContentValues(values, model, false);
        long key = db.insert(TABLE_NAME, null, values);
        model.setId((long)key);
        return key;
    }

    public static int update(SQLiteDatabase db, UserModel model) {
        ContentValues values = new ContentValues();
        String whereClause = "id=?";
        String[] whereArgs = new String[] {
            ACCESSOR_ID.stringValue(model.getId())
        };
        putToContentValues(values, model, false);
        return db.update(TABLE_NAME, values, whereClause, whereArgs);
    }

    public static int delete(SQLiteDatabase db, Long key) {
        String whereClause = "id=?";
        String[] whereArgs = new String[] {
            ACCESSOR_ID.stringValue(key)
        };
        return db.delete(TABLE_NAME, whereClause, whereArgs);
    }

    public static UserModel findById(SQLiteDatabase db, Long id) {
        Cursor cursor = findCursorById(db, id);
        UserModel model = (cursor.moveToNext()) ? readCursorByIndex(cursor) : null;
        cursor.close();
        return model;
    }

    public static Cursor findCursorById(SQLiteDatabase db, Long id) {
        String selection = "id=?";
        String[] selectionArgs = new String[] {

            ACCESSOR_ID.stringValue(id),
        };
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null);
    }

    public static UserModel findByUsername(SQLiteDatabase db, String username) {
        Cursor cursor = findCursorByUsername(db, username);
        UserModel model = (cursor.moveToNext()) ? readCursorByIndex(cursor) : null;
        cursor.close();
        return model;
    }

    public static Cursor findCursorByUsername(SQLiteDatabase db, String username) {
        String selection = "username=?";
        String[] selectionArgs = new String[] {

            ACCESSOR_USERNAME.stringValue(username),
        };
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, null);
    }

    public static java.util.List<UserModel> findByTeamOrderByRoleAscAndIdAsc(SQLiteDatabase db,
            int limit, String team) {
        Cursor cursor = findCursorByTeamOrderByRoleAscAndIdAsc(db, limit, team);
        java.util.List<UserModel> result = new java.util.ArrayList<UserModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }

    public static Cursor findCursorByTeamOrderByRoleAscAndIdAsc(SQLiteDatabase db, int limit,
            String team) {
        String selection = "team=?";
        String[] selectionArgs = new String[] {

            ACCESSOR_TEAM.stringValue(team),
        };
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;

        String orderBy = "role asc,id asc";
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, orderBy,
                limitStr);

    }

    public static java.util.List<UserModel> findByTeamOrderByIdDesc(SQLiteDatabase db, int limit,
            String team) {
        Cursor cursor = findCursorByTeamOrderByIdDesc(db, limit, team);
        java.util.List<UserModel> result = new java.util.ArrayList<UserModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }

    public static Cursor findCursorByTeamOrderByIdDesc(SQLiteDatabase db, int limit, String team) {
        String selection = "team=?";
        String[] selectionArgs = new String[] {

            ACCESSOR_TEAM.stringValue(team),
        };
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;

        String orderBy = "id desc";
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, orderBy,
                limitStr);

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

    public static Cursor findCursorOrderByIdAsc(SQLiteDatabase db, int limit) {
        String selection = "";
        String[] selectionArgs = new String[] {

        };
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;

        String orderBy = "id asc";
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, orderBy,
                limitStr);

    }

    public static java.util.List<UserModel> findByAuthorityOrderByIdAsc(SQLiteDatabase db,
            int limit, net.cattaka.util.cathandsgendroid.test.model.UserModel.Authority authority) {
        Cursor cursor = findCursorByAuthorityOrderByIdAsc(db, limit, authority);
        java.util.List<UserModel> result = new java.util.ArrayList<UserModel>();
        while (cursor.moveToNext()) {
            result.add(readCursorByIndex(cursor));
        }
        cursor.close();
        return result;
    }

    public static Cursor findCursorByAuthorityOrderByIdAsc(SQLiteDatabase db, int limit,
            net.cattaka.util.cathandsgendroid.test.model.UserModel.Authority authority) {
        String selection = "authority=?";
        String[] selectionArgs = new String[] {

            ACCESSOR_AUTHORITY.stringValue(authority),
        };
        String limitStr = (limit > 0) ? String.valueOf(limit) : null;

        String orderBy = "id asc";
        return db.query(TABLE_NAME, COLUMNS_ARRAY, selection, selectionArgs, null, null, orderBy,
                limitStr);

    }
}
```

This utility class has following features.

* SQL_CREATE_TABLE
* Upgrade table function about added columns
* insert/update/delete function
* find functions. If you indicated key columns for find, return type become single type, otherwise it become list type.
* Some constants about table and columns.

CatHandsGendroid also have other function
* Generate parcelable funcions, android.os.Parcelable.Creator CREATOR, readFromParcel and writeToParcel.
* Interface wrapper, It provides when method of interface is called from non UIThread, it react from UIThread.

## License
```
Copyright 2011 Takao Sumitomo

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
