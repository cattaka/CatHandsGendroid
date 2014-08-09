
package net.cattaka.util.cathandsgendroid.accessor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.cattaka.util.cathandsgendroid.annotation.AccessorAttrs;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;

/**
 * Interface for accessor, Implements class of this specifies the way to access
 * for each datatype.
 * 
 * @author cattaka
 * @param <T> Data type which datatype is used by this implements class.
 * @see AccessorAttrs
 */
public interface IAccessor<T> {
    /**
     * The way to read from DataInputStream.
     * 
     * @param in datasource
     * @return result of read.
     * @throws IOException if an I/O error occurs.
     */
    public T readFromStream(DataInputStream in) throws IOException;

    /**
     * The way to write to DataInputStream.
     * 
     * @param out destination
     * @param value the value to write
     * @throws IOException if an I/O error occurs.
     */
    public void writeToStream(DataOutputStream out, T value) throws IOException;

    /**
     * The way to read from Parcel.
     * 
     * @param p datasource
     * @return result of read.
     */
    public T readFromParcel(Parcel p);

    /**
     * The way to write to Parcel.
     * 
     * @param p destination
     * @param value the value to write
     */
    public void writeToParcel(Parcel p, T value);

    /**
     * The way to read from Cursor.
     * 
     * @param c datasource
     * @param idx the zero-based index of the target column.
     * @return result of read.
     */
    public T readFromCursor(Cursor c, int idx);

    /**
     * The way to put to ContentValues.
     * 
     * @param values destination
     * @param columnName the name of the value to put
     * @param value the data for the value to put
     */
    public void putToContentValues(ContentValues values, String columnName, T value);

    /**
     * Make string representation of given value. this method is used in WHERE
     * phrase of find of DB.
     * 
     * @param value input value
     * @return string representation.
     */
    public String stringValue(T value);
}
