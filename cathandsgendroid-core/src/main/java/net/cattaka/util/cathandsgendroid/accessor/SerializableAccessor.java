
package net.cattaka.util.cathandsgendroid.accessor;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import net.cattaka.util.cathandsgendroid.accessor.Accessors.BlobAccessor;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;

public class SerializableAccessor<T extends Serializable> implements IAccessor<T> {
    private Class<T> clazz;

    public static <T extends Serializable> IAccessor<T> createAccessor(
            Class<T> clazz) {
        return new SerializableAccessor<T>(clazz);
    }

    public SerializableAccessor(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public T readFromStream(DataInputStream in) throws IOException {
        if (in.readBoolean()) {
            ObjectInputStream oin = new ObjectInputStream(in);
            try {
                Object obj = oin.readObject();
                if (clazz.isInstance(obj)) {
                    @SuppressWarnings("unchecked")
                    T t = (T)obj;
                    return t;
                }
            } catch (ClassNotFoundException e) {
                // ignore
            }
        }
        return null;
    }

    @Override
    public void writeToStream(DataOutputStream out, T value) throws IOException {
        if (value != null) {
            out.writeBoolean(true);
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(value);
            oout.flush();
        } else {
            out.writeBoolean(false);
        }
    }

    @Override
    public T readFromParcel(Parcel p) {
        if (p.readByte() != 0) {
            Object obj = p.readSerializable();
            if (clazz.isInstance(obj)) {
                @SuppressWarnings("unchecked")
                T t = (T)obj;
                return t;
            }
        }
        return null;
    }

    @Override
    public void writeToParcel(Parcel p, Serializable value) {
        p.writeByte(value != null ? (byte)1 : 0);
        if (value != null) {
            p.writeSerializable(value);
        }
    }

    @Override
    public T readFromCursor(Cursor c, int idx) {
        byte[] bs = BlobAccessor.createAccessor(byte[].class).readFromCursor(c, idx);
        if (bs != null) {
            Object obj = fromByteArray(bs);
            if (clazz.isInstance(obj)) {
                @SuppressWarnings("unchecked")
                T t = (T)obj;
                return t;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public void putToContentValues(ContentValues values, String columnName, Serializable value) {
        byte[] bs = Accessors.toByteArray(value);
        values.put(columnName, bs);
    }

    @Override
    public String stringValue(Serializable value) {
        return (value != null) ? value.toString() : null;
    }

    static Object fromByteArray(byte[] src) {
        if (src == null) {
            return null;
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(src);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            return in.readObject();
        } catch (ClassNotFoundException ex) {
            // ignore close exception
            return null;
        } catch (IOException ex) {
            // ignore close exception
            return null;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
            try {
                bis.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }
}
