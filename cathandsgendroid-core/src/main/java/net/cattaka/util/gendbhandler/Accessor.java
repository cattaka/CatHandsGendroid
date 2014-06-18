
package net.cattaka.util.gendbhandler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Accessor {
    public static byte readPbyteFromParcel(Parcel src) {
        return src.readByte();
    }

    public static void writePbyteToParcel(Parcel dst, byte val) {
        dst.writeByte(val);
    }

    public static byte readPbyteFromCursor(Cursor src, int idx, byte defaultValue) {
        return (!src.isNull(idx)) ? (byte)src.getShort(idx) : defaultValue;
    }

    public static void putPbyteToContentValues(ContentValues dst, String key, byte value) {
        dst.put(key, value);
    }

    public static String toString(byte value) {
        return String.valueOf(value);
    }

    public static short readPshortFromParcel(Parcel src) {
        return (short)src.readInt();
    }

    public static void writePshortToParcel(Parcel dst, short val) {
        dst.writeInt(val);
    }

    public static short readPshortFromCursor(Cursor src, int idx, short defaultValue) {
        return (!src.isNull(idx)) ? src.getShort(idx) : defaultValue;
    }

    public static void putPshortToContentValues(ContentValues dst, String key, short value) {
        dst.put(key, value);
    }

    public static String toString(short value) {
        return String.valueOf(value);
    }

    public static int readPintFromParcel(Parcel src) {
        return src.readInt();
    }

    public static void writePintToParcel(Parcel dst, int val) {
        dst.writeInt(val);
    }

    public static int readPintFromCursor(Cursor src, int idx, int defaultValue) {
        return (!src.isNull(idx)) ? src.getInt(idx) : defaultValue;
    }

    public static void putPintToContentValues(ContentValues dst, String key, int value) {
        dst.put(key, value);
    }

    public static String toString(int value) {
        return String.valueOf(value);
    }

    public static long readPlongFromParcel(Parcel src) {
        return src.readLong();
    }

    public static void writePlongToParcel(Parcel dst, long val) {
        dst.writeLong(val);
    }

    public static long readPlongFromCursor(Cursor src, int idx, long defaultValue) {
        return (!src.isNull(idx)) ? src.getLong(idx) : defaultValue;
    }

    public static void putPlongToContentValues(ContentValues dst, String key, long value) {
        dst.put(key, value);
    }

    public static String toString(long value) {
        return String.valueOf(value);
    }

    public static float readPfloatFromParcel(Parcel src) {
        return src.readFloat();
    }

    public static void writePfloatToParcel(Parcel dst, float val) {
        dst.writeFloat(val);
    }

    public static float readPfloatFromCursor(Cursor src, int idx, float defaultValue) {
        return (!src.isNull(idx)) ? src.getFloat(idx) : defaultValue;
    }

    public static void putPfloatToContentValues(ContentValues dst, String key, float value) {
        dst.put(key, value);
    }

    public static String toString(float value) {
        return String.valueOf(value);
    }

    public static double readPdoubleFromParcel(Parcel src) {
        return src.readDouble();
    }

    public static void writePdoubleToParcel(Parcel dst, double val) {
        dst.writeDouble(val);
    }

    public static double readPdoubleFromCursor(Cursor src, int idx, double defaultValue) {
        return (!src.isNull(idx)) ? src.getDouble(idx) : defaultValue;
    }

    public static void putPdoubleToContentValues(ContentValues dst, String key, double value) {
        dst.put(key, value);
    }

    public static String toString(double value) {
        return String.valueOf(value);
    }

    public static char readPcharFromParcel(Parcel src) {
        return (char)src.readInt();
    }

    public static void writePcharToParcel(Parcel dst, char val) {
        dst.writeInt(val);
    }

    public static char readPcharFromCursor(Cursor src, int idx, char defaultValue) {
        return (!src.isNull(idx)) ? (char)src.getShort(idx) : defaultValue;
    }

    public static void putPcharToContentValues(ContentValues dst, String key, char value) {
        dst.put(key, (short)value);
    }

    public static String toString(char value) {
        return String.valueOf((short)value);
    }

    public static boolean readPbooleanFromParcel(Parcel src) {
        return src.readByte() != 0;
    }

    public static void writePbooleanToParcel(Parcel dst, boolean val) {
        dst.writeByte(val ? (byte)1 : 0);
    }

    public static boolean readPbooleanFromCursor(Cursor src, int idx, boolean defaultValue) {
        return (!src.isNull(idx)) ? (src.getShort(idx) != 0) : defaultValue;
    }

    public static void putPbooleanToContentValues(ContentValues dst, String key, boolean value) {
        dst.put(key, (short)(value ? 1 : 0));
    }

    public static String toString(boolean value) {
        return String.valueOf((short)(value ? 1 : 0));
    }

    public static Byte readByteFromParcel(Parcel src) {
        return (src.readByte() != 0) ? src.readByte() : null;
    }

    public static void writeByteToParcel(Parcel dst, Byte val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeByte(val);
        }
    }

    public static Byte readByteFromCursor(Cursor src, int idx) {
        return (!src.isNull(idx)) ? (byte)src.getShort(idx) : null;
    }

    public static void putByteToContentValues(ContentValues dst, String key, Byte value) {
        dst.put(key, value);
    }

    public static String toString(Byte value) {
        return (value != null) ? String.valueOf(value) : null;
    }

    public static Short readShortFromParcel(Parcel src) {
        return (src.readByte() != 0) ? (short)src.readInt() : null;
    }

    public static void writeShortToParcel(Parcel dst, Short val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeInt(val);
        }
    }

    public static Short readShortFromCursor(Cursor src, int idx) {
        return (!src.isNull(idx)) ? src.getShort(idx) : null;
    }

    public static void putShortToContentValues(ContentValues dst, String key, Short value) {
        dst.put(key, value);
    }

    public static String toString(Short value) {
        return (value != null) ? String.valueOf(value) : null;
    }

    public static Integer readIntegerFromParcel(Parcel src) {
        return (src.readByte() != 0) ? src.readInt() : null;
    }

    public static void writeIntegerToParcel(Parcel dst, Integer val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeInt(val);
        }
    }

    public static Integer readIntegerFromCursor(Cursor src, int idx) {
        return (!src.isNull(idx)) ? src.getInt(idx) : null;
    }

    public static void putIntegerToContentValues(ContentValues dst, String key, Integer value) {
        dst.put(key, value);
    }

    public static String toString(Integer value) {
        return (value != null) ? String.valueOf(value) : null;
    }

    public static Long readLongFromParcel(Parcel src) {
        return (src.readByte() != 0) ? src.readLong() : null;
    }

    public static void writeLongToParcel(Parcel dst, Long val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeLong(val);
        }
    }

    public static Long readLongFromCursor(Cursor src, int idx) {
        return (!src.isNull(idx)) ? src.getLong(idx) : null;
    }

    public static void putLongToContentValues(ContentValues dst, String key, Long value) {
        dst.put(key, value);
    }

    public static String toString(Long value) {
        return (value != null) ? String.valueOf(value) : null;
    }

    public static Float readFloatFromParcel(Parcel src) {
        return (src.readByte() != 0) ? src.readFloat() : null;
    }

    public static void writeFloatToParcel(Parcel dst, Float val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeFloat(val);
        }
    }

    public static Float readFloatFromCursor(Cursor src, int idx) {
        return (!src.isNull(idx)) ? src.getFloat(idx) : null;
    }

    public static void putFloatToContentValues(ContentValues dst, String key, Float value) {
        dst.put(key, value);
    }

    public static String toString(Float value) {
        return (value != null) ? String.valueOf(value) : null;
    }

    public static Double readDoubleFromParcel(Parcel src) {
        return (src.readByte() != 0) ? src.readDouble() : null;
    }

    public static void writeDoubleToParcel(Parcel dst, Double val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeDouble(val);
        }
    }

    public static Double readDoubleFromCursor(Cursor src, int idx) {
        return (!src.isNull(idx)) ? src.getDouble(idx) : null;
    }

    public static void putDoubleToContentValues(ContentValues dst, String key, Double value) {
        dst.put(key, value);
    }

    public static String toString(Double value) {
        return (value != null) ? String.valueOf(value) : null;
    }

    public static Character readCharacterFromParcel(Parcel src) {
        return (src.readByte() != 0) ? (char)src.readInt() : null;
    }

    public static void writeCharacterToParcel(Parcel dst, Character val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeInt(val);
        }
    }

    public static Character readCharacterFromCursor(Cursor src, int idx) {
        return (!src.isNull(idx)) ? (char)src.getShort(idx) : null;
    }

    public static void putCharacterToContentValues(ContentValues dst, String key, Character value) {
        dst.put(key, (value != null) ? (short)value.charValue() : null);
    }

    public static String toString(Character value) {
        return (value != null) ? String.valueOf((short)value.charValue()) : null;
    }

    public static Boolean readBooleanFromParcel(Parcel src) {
        return (src.readByte() != 0) ? (src.readByte() != 0) : null;
    }

    public static void writeBooleanToParcel(Parcel dst, Boolean val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeByte(val ? (byte)1 : 0);
        }
    }

    public static Boolean readBooleanFromCursor(Cursor src, int idx) {
        return (!src.isNull(idx)) ? (src.getShort(idx) != 0) : null;
    }

    public static void putBooleanToContentValues(ContentValues dst, String key, Boolean value) {
        dst.put(key, (value != null) ? (value ? (byte)1 : 0) : null);
    }

    public static String toString(Boolean value) {
        return (value != null) ? String.valueOf(value ? 1 : 0) : null;
    }

    public static String readStringFromParcel(Parcel src) {
        return (src.readByte() != 0) ? src.readString() : null;
    }

    public static void writeStringToParcel(Parcel dst, String val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeString(val);
        }
    }

    public static String readStringFromCursor(Cursor src, int idx) {
        return (!src.isNull(idx)) ? src.getString(idx) : null;
    }

    public static void putStringToContentValues(ContentValues dst, String key, String value) {
        dst.put(key, value);
    }

    public static String toString(String value) {
        return (value != null) ? value : null;
    }

    public static <T extends Enum<T>> T readEnumFromParcel(Parcel src, Class<T> enumType) {
        String name = (src.readByte() != 0) ? src.readString() : null;
        try {
            return (name != null) ? Enum.valueOf(enumType, name) : null;
        } catch (IllegalArgumentException e) {
        }
        return null;
    }

    public static void writeEnumToParcel(Parcel dst, Enum<?> val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeString(val.name());
        }
    }

    public static <T extends Enum<T>> T readEnumFromCursor(Cursor src, int idx, Class<T> enumType) {
        if (!src.isNull(idx)) {
            String name = src.getString(idx);
            try {
                return (name != null) ? Enum.valueOf(enumType, name) : null;
            } catch (IllegalArgumentException e) {
            }
        }
        return null;
    }

    public static void putEnumToContentValues(ContentValues dst, String key, Enum<?> value) {
        dst.put(key, (value != null) ? value.name() : null);
    }

    public static byte[] readBlobFromParcel(Parcel src) {
        int n = src.readInt();
        if (n >= 0) {
            byte[] bs = new byte[n];
            src.readByteArray(bs);
            return bs;
        } else {
            return null;
        }
    }

    public static void writeBlobToParcel(Parcel dst, byte[] val) {
        if (val != null) {
            dst.writeInt(val.length);
            dst.writeByteArray(val);
        } else {
            dst.writeInt(-1);
        }
    }

    public static byte[] readBlobFromCursor(Cursor src, int idx) {
        return (!src.isNull(idx)) ? src.getBlob(idx) : null;
    }

    public static void putBlobToContentValues(ContentValues dst, String key, byte[] value) {
        dst.put(key, value);
    }

    public static Serializable readSerializableFromParcel(Parcel src) {
        if (src.readByte() != 0) {
            return src.readSerializable();
        } else {
            return null;
        }
    }

    public static void writeSerializableToParcel(Parcel dst, Serializable val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeSerializable(val);
        }
    }

    public static Serializable readSerializableFromCursor(Cursor src, int idx) {
        byte[] bs = readBlobFromCursor(src, idx);
        return fromByteArray(bs);
    }

    public static void putSerializableToContentValues(ContentValues dst, String key,
            Serializable value) {
        byte[] bs = toByteArray(value);
        dst.put(key, bs);
    }

    public static Bundle readBundleFromParcel(Parcel src) {
        return (src.readByte() != 0) ? src.readBundle() : null;
    }

    public static void writeBundleToParcel(Parcel dst, Bundle val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeBundle(val);
        }
    }

    public static Bundle readBundleFromCursor(Cursor src, int idx) {
        return (Bundle)readParcelableFromCursor(src, idx, Bundle.class.getClassLoader());
    }

    public static void putBundleToContentValues(ContentValues dst, String key, Bundle value) {
        putParcelableToContentValues(dst, key, value);
    }

    public static Parcelable readParcelableFromParcel(Parcel src, ClassLoader loader) {
        return (src.readByte() != 0) ? src.readParcelable(loader) : null;
    }

    public static void writeParcelableToParcel(Parcel dst, Parcelable val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeParcelable(val, 0);
        }
    }

    public static Parcelable readParcelableFromCursor(Cursor src, int idx, ClassLoader loader) {
        byte[] bs = readBlobFromCursor(src, idx);
        Parcel parcel = Parcel.obtain();
        try {
            parcel.unmarshall(bs, 0, bs.length);
            parcel.setDataPosition(0);
            return parcel.readParcelable(loader);
        } finally {
            parcel.recycle();
        }
    }

    public static void putParcelableToContentValues(ContentValues dst, String key, Parcelable value) {
        byte[] bs;
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeParcelable(value, 0);
            bs = parcel.marshall();
        } finally {
            parcel.recycle();
        }
        dst.put(key, bs);
    }

    public static Date readDateFromParcel(Parcel src) {
        return (src.readByte() != 0) ? new Date(src.readLong()) : null;
    }

    public static void writeDateToParcel(Parcel dst, Date val) {
        dst.writeByte(val != null ? (byte)1 : 0);
        if (val != null) {
            dst.writeLong(val.getTime());
        }
    }

    public static Date readDateFromCursor(Cursor src, int idx) {
        return (!src.isNull(idx)) ? new Date(src.getLong(idx)) : null;
    }

    public static void putDateToContentValues(ContentValues dst, String key, Date value) {
        dst.put(key, (value != null) ? value.getTime() : null);
    }

    public static String toString(Date value) {
        return (value != null) ? String.valueOf(value.getTime()) : null;
    }

    public static String toStringName(Enum<?> value) {
        return (value != null) ? value.name() : null;
    }

    public static String toStringOrder(Enum<?> value) {
        return (value != null) ? String.valueOf(value.ordinal()) : null;
    }

    private static byte[] toByteArray(Serializable src) {
        if (src == null) {
            return null;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(src);
            out.flush();
            return bos.toByteArray();
        } catch (IOException ex) {
            // ignore close exception
            return null;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }

    private static <T> T fromByteArray(byte[] src) {
        if (src == null) {
            return null;
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(src);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            @SuppressWarnings("unchecked")
            T obj = (T)in.readObject();
            return obj;
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
