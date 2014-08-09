
package net.cattaka.util.cathandsgendroid.accessor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.cattaka.util.cathandsgendroid.accessor.Accessors.BlobAccessor;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableAccessor<T extends Parcelable> implements IAccessor<T> {
    private Class<T> clazz;

    public static <T extends Parcelable> IAccessor<T> createAccessor(Class<T> clazz) {
        return new ParcelableAccessor<T>(clazz);
    }

    public ParcelableAccessor(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public T readFromStream(DataInputStream in) throws IOException {
        byte[] bs = BlobAccessor.createAccessor(byte[].class).readFromStream(in);
        if (bs != null) {
            Parcel parcel = Parcel.obtain();
            try {
                parcel.unmarshall(bs, 0, bs.length);
                parcel.setDataPosition(0);
                Object obj = parcel.readParcelable(Accessors.class.getClassLoader());
                if (clazz.isInstance(obj)) {
                    @SuppressWarnings("unchecked")
                    T t = (T)obj;
                    return t;
                }
            } finally {
                parcel.recycle();
            }
        }
        return null;
    }

    @Override
    public void writeToStream(DataOutputStream out, T value) throws IOException {
        byte[] bs = null;
        if (value != null) {
            Parcel parcel = Parcel.obtain();
            try {
                parcel.writeParcelable(value, 0);
                bs = parcel.marshall();
            } finally {
                parcel.recycle();
            }
        }
        BlobAccessor.createAccessor(byte[].class).writeToStream(out, bs);
    }

    @Override
    public T readFromParcel(Parcel p) {
        if (p.readByte() != 0) {
            Object obj = p.readParcelable(Accessors.class.getClassLoader());
            if (clazz.isInstance(obj)) {
                @SuppressWarnings("unchecked")
                T t = (T)obj;
                return t;
            }
        }
        return null;
    }

    @Override
    public void writeToParcel(Parcel p, T value) {
        p.writeByte(value != null ? (byte)1 : 0);
        if (value != null) {
            p.writeParcelable(value, 0);
        }
    }

    @Override
    public T readFromCursor(Cursor c, int idx) {
        byte[] bs = BlobAccessor.createAccessor(byte[].class).readFromCursor(c, idx);
        if (bs != null) {
            Parcel parcel = Parcel.obtain();
            try {
                parcel.unmarshall(bs, 0, bs.length);
                parcel.setDataPosition(0);
                Object obj = parcel.readParcelable(Accessors.class.getClassLoader());
                if (clazz.isInstance(obj)) {
                    @SuppressWarnings("unchecked")
                    T t = (T)obj;
                    return t;
                }
            } finally {
                parcel.recycle();
            }
        }
        return null;
    }

    @Override
    public void putToContentValues(ContentValues values, String columnName, T value) {
        byte[] bs = null;
        if (value != null) {
            Parcel parcel = Parcel.obtain();
            try {
                parcel.writeParcelable(value, 0);
                bs = parcel.marshall();
            } finally {
                parcel.recycle();
            }
        }
        values.put(columnName, bs);
    }

    @Override
    public String stringValue(T value) {
        return (value != null) ? value.toString() : null;
    }
}
