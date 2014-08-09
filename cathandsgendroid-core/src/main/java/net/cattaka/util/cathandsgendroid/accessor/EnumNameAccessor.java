
package net.cattaka.util.cathandsgendroid.accessor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.cattaka.util.cathandsgendroid.annotation.AccessorAttrs;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;

/**
 * The accessor for Enum. This uses "name" for representation of datatype.
 */
@AccessorAttrs(dbDataType="TEXT")
public class EnumNameAccessor<T extends Enum<T>> implements IAccessor<T> {

    /**
     * Create the accessor for enum.
     * 
     * @param child accessor for inherited datatype. 
     * @return created accessor
     */
    public static <T extends Enum<T>> IAccessor<T> createAccessor(Class<T> clazz) {
        return new EnumNameAccessor<T>(clazz);
    }

    private Class<T> enumType;

    private EnumNameAccessor(Class<T> enumType) {
        super();
        this.enumType = enumType;
    }

    @Override
    public T readFromStream(DataInputStream in) throws IOException {
        String name = (in.readBoolean()) ? in.readUTF() : null;
        try {
            return (name != null) ? Enum.valueOf(enumType, name) : null;
        } catch (IllegalArgumentException e) {
        }
        return null;
    }

    @Override
    public void writeToStream(DataOutputStream out, T value) throws IOException {
        out.writeBoolean(value != null);
        if (value != null) {
            out.writeUTF(value.name());
        }
    }

    @Override
    public T readFromParcel(Parcel p) {
        String name = (p.readByte() != 0) ? p.readString() : null;
        try {
            return (name != null) ? Enum.valueOf(enumType, name) : null;
        } catch (IllegalArgumentException e) {
        }
        return null;
    }

    @Override
    public void writeToParcel(Parcel p, T value) {
        p.writeByte(value != null ? (byte)1 : 0);
        if (value != null) {
            p.writeString(value.name());
        }
    }

    @Override
    public T readFromCursor(Cursor c, int idx) {
        if (!c.isNull(idx)) {
            String name = c.getString(idx);
            try {
                return (name != null) ? Enum.valueOf(enumType, name) : null;
            } catch (IllegalArgumentException e) {
            }
        }
        return null;
    }

    @Override
    public void putToContentValues(ContentValues values, String columnName, T value) {
        values.put(columnName, (value != null) ? value.name() : null);
    }

    @Override
    public String stringValue(T value) {
        return (value != null) ? value.name() : null;
    }
}
