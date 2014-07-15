package net.cattaka.cathandsgendroid;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;

public interface IAccessor<T> {
    public T readFromStream(DataInputStream in) throws IOException;
    public void writeToStream(DataOutputStream out, T value) throws IOException;
    public T readFromParcel(Parcel p);
    public void writeToParcel(Parcel p, T value);
    public T readFromCursor(Cursor c, int idx, T defaultValue);
    public void putToContentValues(ContentValues values, String columnName, T value);
    public String stringValue(T value);
}
