
package net.cattaka.util.cathandsgendroid.accessor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;

public class EnumOrderAccessor<T extends Enum<T>> implements IAccessor<T> {

    public static <T extends Enum<T>> IAccessor<T> createAccessor(Class<T> clazz) {
        return new EnumOrderAccessor<T>(clazz);
    }

    private Class<T> enumType;

    private EnumOrderAccessor(Class<T> enumType) {
        super();
        this.enumType = enumType;
    }

    @Override
    public T readFromStream(DataInputStream in) throws IOException {
        int order = (in.readBoolean()) ? in.readInt() : -1;
        T[] values = enumType.getEnumConstants();
        if (0 <= order && order <= values.length) {
            return values[order];
        }
        return null;
    }

    @Override
    public void writeToStream(DataOutputStream out, T value) throws IOException {
        out.writeBoolean(value != null);
        if (value != null) {
            out.writeInt(value.ordinal());
        }
    }

    @Override
    public T readFromParcel(Parcel p) {
        int order = (p.readByte() != 0) ? p.readInt() : -1;
        T[] values = enumType.getEnumConstants();
        if (0 <= order && order <= values.length) {
            return values[order];
        }
        return null;
    }

    @Override
    public void writeToParcel(Parcel p, T value) {
        p.writeByte(value != null ? (byte)1 : 0);
        if (value != null) {
            p.writeInt(value.ordinal());
        }
    }

    @Override
    public T readFromCursor(Cursor c, int idx) {
        if (!c.isNull(idx)) {
            int order = c.getInt(idx);
            T[] values = enumType.getEnumConstants();
            if (0 <= order && order <= values.length) {
                return values[order];
            }
        }
        return null;
    }

    @Override
    public void putToContentValues(ContentValues values, String columnName, T value) {
        values.put(columnName, (value != null) ? value.ordinal() : null);
    }

    @Override
    public String stringValue(T value) {
        return (value != null) ? String.valueOf(value.ordinal()) : null;
    }
}
