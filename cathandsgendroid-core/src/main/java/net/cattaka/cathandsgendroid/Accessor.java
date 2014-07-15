
package net.cattaka.cathandsgendroid;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Accessor {
    public static final IAccessor<Byte> P_BYTE = new IAccessor<Byte>() {
        @Override
        public Byte readFromStream(DataInputStream in) throws IOException {
            return in.readByte();
        }
        @Override
        public void writeToStream(DataOutputStream out, Byte value) throws IOException {
            out.writeByte(value);
        }
        
        @Override
        public Byte readFromParcel(Parcel p) {
            return p.readByte();
        }

        @Override
        public void writeToParcel(Parcel p, Byte value) {
            p.writeByte(value);
        }

        @Override
        public Byte readFromCursor(Cursor c, int idx, Byte defaultValue) {
            return (c.isNull(idx) ? defaultValue : (byte)c.getShort(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Byte value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Byte value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Short> P_SHORT = new IAccessor<Short>() {
        @Override
        public Short readFromStream(DataInputStream in) throws IOException {
            return (short)in.readInt();
        }
        @Override
        public void writeToStream(DataOutputStream out, Short value) throws IOException {
            out.writeInt(value);
        }
        @Override
        public Short readFromParcel(Parcel p) {
            return (short)p.readInt();
        }

        @Override
        public void writeToParcel(Parcel p, Short value) {
            p.writeInt(value);
        }

        @Override
        public Short readFromCursor(Cursor c, int idx, Short defaultValue) {
            return (c.isNull(idx) ? defaultValue : c.getShort(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Short value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Short value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Integer> P_INTEGER = new IAccessor<Integer>() {
        @Override
        public Integer readFromStream(DataInputStream in) throws IOException {
            return in.readInt();
        };
        @Override
        public void writeToStream(DataOutputStream out, Integer value) throws IOException {
            out.writeInt(value);
        }
        @Override
        public Integer readFromParcel(Parcel p) {
            return p.readInt();
        }

        @Override
        public void writeToParcel(Parcel p, Integer value) {
            p.writeInt(value);
        }

        @Override
        public Integer readFromCursor(Cursor c, int idx, Integer defaultValue) {
            return (c.isNull(idx) ? defaultValue : c.getInt(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Integer value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Integer value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Long> P_LONG = new IAccessor<Long>() {
        @Override
        public Long readFromStream(DataInputStream in) throws IOException {
            return in.readLong();
        }
        @Override
        public void writeToStream(DataOutputStream out, Long value) throws IOException {
            out.writeLong(value);
        }
        @Override
        public Long readFromParcel(Parcel p) {
            return p.readLong();
        }

        @Override
        public void writeToParcel(Parcel p, Long value) {
            p.writeLong(value);
        }

        @Override
        public Long readFromCursor(Cursor c, int idx, Long defaultValue) {
            return (c.isNull(idx) ? defaultValue : c.getLong(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Long value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Long value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Float> P_FLOAT = new IAccessor<Float>() {
        @Override
        public Float readFromStream(DataInputStream in) throws IOException {
            return in.readFloat();
        }
        @Override
        public void writeToStream(DataOutputStream out, Float value) throws IOException {
            out.writeFloat(value);
        }
        @Override
        public Float readFromParcel(Parcel p) {
            return p.readFloat();
        }

        @Override
        public void writeToParcel(Parcel p, Float value) {
            p.writeFloat(value);
        }

        @Override
        public Float readFromCursor(Cursor c, int idx, Float defaultValue) {
            return (c.isNull(idx) ? defaultValue : c.getFloat(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Float value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Float value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Double> P_DOUBLE = new IAccessor<Double>() {
        @Override
        public Double readFromStream(DataInputStream in) throws IOException {
            return in.readDouble();
        }
        @Override
        public void writeToStream(DataOutputStream out, Double value) throws IOException {
            out.writeDouble(value);
        }
        @Override
        public Double readFromParcel(Parcel p) {
            return p.readDouble();
        }

        @Override
        public void writeToParcel(Parcel p, Double value) {
            p.writeDouble(value);
        }

        @Override
        public Double readFromCursor(Cursor c, int idx, Double defaultValue) {
            return (c.isNull(idx) ? defaultValue : c.getDouble(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Double value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Double value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Character> P_CHARACTER = new IAccessor<Character>() {
        @Override
        public Character readFromStream(DataInputStream in) throws IOException {
            return in.readChar();
        }
        @Override
        public void writeToStream(DataOutputStream out, Character value) throws IOException {
            out.writeChar(value);
        }
        @Override
        public Character readFromParcel(Parcel p) {
            return (char)p.readInt();
        }

        @Override
        public void writeToParcel(Parcel p, Character value) {
            p.writeInt(value);
        }

        @Override
        public Character readFromCursor(Cursor c, int idx, Character defaultValue) {
            return (c.isNull(idx) ? defaultValue : (char)c.getShort(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Character value) {
            values.put(columnName, (value != null) ? (short)value.charValue() : null);
        }

        @Override
        public String stringValue(Character value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Boolean> P_BOOLEAN = new IAccessor<Boolean>() {
        @Override
        public Boolean readFromStream(DataInputStream in) throws IOException {
            return in.readBoolean();
        }
        @Override
        public void writeToStream(DataOutputStream out, Boolean value) throws IOException {
            out.writeBoolean(value);
        }
        @Override
        public Boolean readFromParcel(Parcel p) {
            return p.readByte() != 0;
        }

        @Override
        public void writeToParcel(Parcel p, Boolean value) {
            p.writeByte(value ? (byte)1 : 0);
        }

        @Override
        public Boolean readFromCursor(Cursor c, int idx, Boolean defaultValue) {
            return (c.isNull(idx) ? defaultValue : (c.getShort(idx) != 0));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Boolean value) {
            values.put(columnName, (value != null) ? (short)(value ? 1 : 0) : null);
        }

        @Override
        public String stringValue(Boolean value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Byte> BYTE = new IAccessor<Byte>() {
        @Override
        public Byte readFromStream(DataInputStream in) throws IOException {
            return (in.readBoolean()) ? in.readByte() : null;
        }
        @Override
        public void writeToStream(DataOutputStream out, Byte value) throws IOException {
            out.writeBoolean(value != null);
            if (value != null) {
                out.writeByte(value);
            }
        }
        @Override
        public Byte readFromParcel(Parcel p) {
            return (p.readByte() != 0) ? p.readByte() : null;
        }

        @Override
        public void writeToParcel(Parcel p, Byte value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeByte(value);
            }
        }

        @Override
        public Byte readFromCursor(Cursor c, int idx, Byte defaultValue) {
            return (byte)(c.isNull(idx) ? defaultValue : c.getInt(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Byte value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Byte value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Short> SHORT = new IAccessor<Short>() {
        @Override
        public Short readFromStream(DataInputStream in) throws IOException {
            return (in.readBoolean()) ? in.readShort() : null;
        }
        @Override
        public void writeToStream(DataOutputStream out, Short value) throws IOException {
            out.writeBoolean(value != null);
            if (value != null) {
                out.writeShort(value);
            }
        }
        @Override
        public Short readFromParcel(Parcel p) {
            return (p.readByte() != 0) ? (short)p.readInt() : null;
        }

        @Override
        public void writeToParcel(Parcel p, Short value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeInt(value);
            }
        }

        @Override
        public Short readFromCursor(Cursor c, int idx, Short defaultValue) {
            return (c.isNull(idx)) ? defaultValue : c.getShort(idx);
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Short value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Short value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Integer> INTEGER = new IAccessor<Integer>() {
        @Override
        public Integer readFromStream(DataInputStream in) throws IOException {
            return (in.readBoolean()) ? in.readInt() : null;
        }
        @Override
        public void writeToStream(DataOutputStream out, Integer value) throws IOException {
            out.writeBoolean(value != null);
            if (value != null) {
                out.writeInt(value);
            }
        }
        @Override
        public Integer readFromParcel(Parcel p) {
            return (p.readByte() != 0) ? p.readInt() : null;
        }

        @Override
        public void writeToParcel(Parcel p, Integer value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeInt(value);
            }
        }

        @Override
        public Integer readFromCursor(Cursor c, int idx, Integer defaultValue) {
            return (c.isNull(idx) ? defaultValue : c.getInt(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Integer value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Integer value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Long> LONG = new IAccessor<Long>() {
        @Override
        public Long readFromStream(DataInputStream in) throws IOException {
            return (in.readBoolean()) ? in.readLong() : null;
        }
        @Override
        public void writeToStream(DataOutputStream out, Long value) throws IOException {
            out.writeBoolean(value != null);
            if (value != null) {
                out.writeLong(value);
            }
        }
        @Override
        public Long readFromParcel(Parcel p) {
            return (p.readByte() != 0) ? p.readLong() : null;
        }

        @Override
        public void writeToParcel(Parcel p, Long value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeLong(value);
            }
        }

        @Override
        public Long readFromCursor(Cursor c, int idx, Long defaultValue) {
            return (c.isNull(idx) ? defaultValue : c.getLong(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Long value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Long value) {
            return (value != null) ? String.valueOf(value) : null;
        };
    };

    public static final IAccessor<Float> FLOAT = new IAccessor<Float>() {
        @Override
        public Float readFromStream(DataInputStream in) throws IOException {
            return (in.readBoolean()) ? in.readFloat() : null;
        }
        @Override
        public void writeToStream(DataOutputStream out, Float value) throws IOException {
            out.writeBoolean(value != null);
            if (value != null) {
                out.writeFloat(value);
            }
        }
        @Override
        public Float readFromParcel(Parcel p) {
            return (p.readByte() != 0) ? p.readFloat() : null;
        }

        @Override
        public void writeToParcel(Parcel p, Float value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeFloat(value);
            }
        }

        @Override
        public Float readFromCursor(Cursor c, int idx, Float defaultValue) {
            return (c.isNull(idx) ? defaultValue : c.getFloat(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Float value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Float value) {
            return String.valueOf(value);
        };
    };

    public static final IAccessor<Double> DOUBLE = new IAccessor<Double>() {
        @Override
        public Double readFromStream(DataInputStream in) throws IOException {
            return (in.readBoolean()) ? in.readDouble() : null;
        }
        @Override
        public void writeToStream(DataOutputStream out, Double value) throws IOException {
            out.writeBoolean(value != null);
            if (value != null) {
                out.writeDouble(value);
            }
        }
        @Override
        public Double readFromParcel(Parcel p) {
            return (p.readByte() != 0) ? p.readDouble() : null;
        }

        @Override
        public void writeToParcel(Parcel p, Double value) {
            p.writeByte(p != null ? (byte)1 : 0);
            if (value != null) {
                p.writeDouble(value);
            }
        }

        @Override
        public Double readFromCursor(Cursor c, int idx, Double defaultValue) {
            return (c.isNull(idx) ? defaultValue : c.getDouble(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Double value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(Double value) {
            return String.valueOf(value);
        };
    };

    public static final IAccessor<Character> CHARACTER = new IAccessor<Character>() {
        @Override
        public Character readFromStream(DataInputStream in) throws IOException {
            return (in.readBoolean()) ? in.readChar() : null;
        }
        @Override
        public void writeToStream(DataOutputStream out, Character value) throws IOException {
            out.writeBoolean(value != null);
            if (value != null) {
                out.writeChar(value);
            }
        }
        @Override
        public Character readFromParcel(Parcel p) {
            return (p.readByte() != 0) ? (char)p.readInt() : null;
        }

        @Override
        public void writeToParcel(Parcel p, Character value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeInt(value);
            }
        }

        @Override
        public Character readFromCursor(Cursor c, int idx, Character defaultValue) {
            return (c.isNull(idx) ? defaultValue : (char)c.getShort(idx));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Character value) {
            values.put(columnName, (value != null) ? (short)value.charValue() : null);
        }

        @Override
        public String stringValue(Character value) {
            return (value != null) ? String.valueOf((short)value.charValue()) : null;
        };
    };

    public static final IAccessor<Boolean> BOOLEAN = new IAccessor<Boolean>() {
        @Override
        public Boolean readFromStream(DataInputStream in) throws IOException {
            return (in.readBoolean()) ? in.readBoolean() : null;
        }
        @Override
        public void writeToStream(DataOutputStream out, Boolean value) throws IOException {
            out.writeBoolean(value != null);
            if (value != null) {
                out.writeBoolean(value);
            }
        }
        @Override
        public Boolean readFromParcel(Parcel p) {
            return (p.readByte() != 0) ? (p.readByte() != 0) : null;
        }

        @Override
        public void writeToParcel(Parcel p, Boolean value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeByte(value ? (byte)1 : 0);
            }
        }

        @Override
        public Boolean readFromCursor(Cursor c, int idx, Boolean defaultValue) {
            return (c.isNull(idx) ? defaultValue : (c.getShort(idx) != 0));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Boolean value) {
            values.put(columnName, (value != null) ? (short)(value ? 1 : 0) : null);
        }

        @Override
        public String stringValue(Boolean value) {
            return (value != null) ? String.valueOf(value ? 1 : 0) : null;
        };
    };

    public static final IAccessor<String> STRING = new IAccessor<String>() {
        @Override
        public String readFromStream(DataInputStream in) throws IOException {
            return (in.readBoolean()) ? in.readUTF() : null;
        }
        @Override
        public void writeToStream(DataOutputStream out, String value) throws IOException {
            out.writeBoolean(value != null);
            if (value != null) {
                out.writeUTF(value);
            }
        }
        @Override
        public String readFromParcel(Parcel p) {
            return (p.readByte() != 0) ? p.readString() : null;
        }

        @Override
        public void writeToParcel(Parcel p, String value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeString(value);
            }
        }

        @Override
        public String readFromCursor(Cursor c, int idx, String defaultValue) {
            return (c.isNull(idx) ? defaultValue : (c.getString(idx)));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, String value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(String value) {
            return (value != null) ? value : null;
        };
    };

    public static final IAccessor<byte[]> BLOB = new IAccessor<byte[]>() {
        @Override
        public byte[] readFromStream(DataInputStream in) throws IOException {
            int n = in.readInt();
            if (n >= 0) {
                byte[] bs = new byte[n];
                in.read(bs, 0, n);
                return bs;
            } else {
                return null;
            }
        }
        @Override
        public void writeToStream(DataOutputStream out, byte[] value) throws IOException {
            if (value != null) {
                out.writeInt(value.length);
                out.write(value);
            } else {
                out.writeInt(-1);
            }
        }
        @Override
        public byte[] readFromParcel(Parcel p) {
            int n = p.readInt();
            if (n >= 0) {
                byte[] bs = new byte[n];
                p.readByteArray(bs);
                return bs;
            } else {
                return null;
            }
        }

        @Override
        public void writeToParcel(Parcel p, byte[] value) {
            if (value != null) {
                p.writeInt(value.length);
                p.writeByteArray(value);
            } else {
                p.writeInt(-1);
            }
        }

        @Override
        public byte[] readFromCursor(Cursor c, int idx, byte[] defaultValue) {
            return (c.isNull(idx) ? defaultValue : (c.getBlob(idx)));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, byte[] value) {
            values.put(columnName, value);
        }

        @Override
        public String stringValue(byte[] value) {
            if (value == null) {
                return null;
            } else {
                StringBuilder sb = new StringBuilder();
                for (byte b : value) {
                    if (0 <= b && b < 0x10) {
                        sb.append('0');
                    }
                    sb.append(Integer.toHexString(b));
                }
                return sb.toString();
            }
        };
    };

    public static final IAccessor<Serializable> SERIALIZABLE = new IAccessor<Serializable>() {
        @Override
        public Serializable readFromStream(DataInputStream in) throws IOException {
            if (in.readBoolean()) {
                ObjectInputStream oin = new ObjectInputStream(in);
                try {
                    return (Serializable) oin.readObject();
                } catch (ClassNotFoundException e) {
                    // ignore
                    return null;
                }
            } else {
                return null;
            }
        }
        @Override
        public void writeToStream(DataOutputStream out, Serializable value) throws IOException {
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
        public Serializable readFromParcel(Parcel p) {
            if (p.readByte() != 0) {
                return p.readSerializable();
            } else {
                return null;
            }
        }

        @Override
        public void writeToParcel(Parcel p, Serializable value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeSerializable(value);
            }
        }

        @Override
        public Serializable readFromCursor(Cursor c, int idx, Serializable defaultValue) {
            byte[] bs = BLOB.readFromCursor(c, idx, null);
            if (bs != null) {
                return fromByteArray(bs);
            } else {
                return defaultValue;
            }
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Serializable value) {
            byte[] bs = toByteArray(value);
            values.put(columnName, bs);
        }

        @Override
        public String stringValue(Serializable value) {
            return (value != null) ? value.toString() : null;
        }
    };

    public static final IAccessor<Parcelable> PARCELABLE = new IAccessor<Parcelable>() {
        @Override
        public Parcelable readFromStream(DataInputStream in) throws IOException {
            byte[] bs = BLOB.readFromStream(in);
            if (bs != null) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.unmarshall(bs, 0, bs.length);
                    parcel.setDataPosition(0);
                    return parcel.readParcelable(Accessor.class.getClassLoader());
                } finally {
                    parcel.recycle();
                }
            } else {
                return null;
            }
        }
        @Override
        public void writeToStream(DataOutputStream out, Parcelable value) throws IOException {
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
            BLOB.writeToStream(out, bs);
        }
        @Override
        public Parcelable readFromParcel(Parcel p) {
            if (p.readByte() != 0) {
                return p.readParcelable(Accessor.class.getClassLoader());
            } else {
                return null;
            }
        }

        @Override
        public void writeToParcel(Parcel p, Parcelable value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeParcelable(value, 0);
            }
        }

        @Override
        public Parcelable readFromCursor(Cursor c, int idx, Parcelable defaultValue) {
            byte[] bs = BLOB.readFromCursor(c, idx, null);
            if (bs != null) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.unmarshall(bs, 0, bs.length);
                    parcel.setDataPosition(0);
                    return parcel.readParcelable(Accessor.class.getClassLoader());
                } finally {
                    parcel.recycle();
                }
            } else {
                return defaultValue;
            }
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Parcelable value) {
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
        public String stringValue(Parcelable value) {
            return (value != null) ? value.toString() : null;
        }
    };

    public static final IAccessor<Bundle> BUNDLE = new IAccessor<Bundle>() {
        @Override
        public Bundle readFromStream(DataInputStream in) throws IOException {
            return (Bundle)PARCELABLE.readFromStream(in);
        }
        @Override
        public void writeToStream(DataOutputStream out, Bundle value) throws IOException {
            PARCELABLE.writeToStream(out, value);
        }
        @Override
        public Bundle readFromParcel(Parcel p) {
            if (p.readByte() != 0) {
                return p.readBundle(Accessor.class.getClassLoader());
            } else {
                return null;
            }
        }

        @Override
        public void writeToParcel(Parcel p, Bundle value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeBundle(value);
            }
        }

        @Override
        public Bundle readFromCursor(Cursor c, int idx, Bundle defaultValue) {
            return (Bundle)PARCELABLE.readFromCursor(c, idx, defaultValue);
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Bundle value) {
            PARCELABLE.putToContentValues(values, columnName, value);
        }

        @Override
        public String stringValue(Bundle value) {
            return (value != null) ? value.toString() : null;
        }
    };

    public static final IAccessor<Date> DATE = new IAccessor<Date>() {
        @Override
        public Date readFromStream(DataInputStream in) throws IOException {
            return (in.readBoolean()) ? new Date(in.readLong()) : null;
        }
        @Override
        public void writeToStream(DataOutputStream out, Date value) throws IOException {
            out.writeBoolean(value != null);
            if (value != null) {
                out.writeLong(value.getTime());
            }
        }
        @Override
        public Date readFromParcel(Parcel p) {
            return (p.readByte() != 0) ? new Date(p.readLong()) : null;
        }

        @Override
        public void writeToParcel(Parcel p, Date value) {
            p.writeByte(value != null ? (byte)1 : 0);
            if (value != null) {
                p.writeLong(value.getTime());
            }
        }

        @Override
        public Date readFromCursor(Cursor c, int idx, Date defaultValue) {
            return (c.isNull(idx) ? defaultValue : new Date(c.getLong(idx)));
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Date value) {
            values.put(columnName, (value != null) ? value.getTime() : null);
        }

        @Override
        public String stringValue(Date value) {
            return (value != null) ? String.valueOf(value.getTime()) : null;
        }
    };

    public static <T extends Enum<T>> IAccessor<T> createEnumNameAccessor(final Class<T> enumType) {
        return new IAccessor<T>() {
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
            public T readFromCursor(Cursor c, int idx, T defaultValue) {
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
        };
    }

    public static <T> IAccessor<List<T>> createListAccessor(final IAccessor<T> child) {
        return new IAccessor<List<T>>() {
            @Override
            public List<T> readFromStream(DataInputStream in) throws IOException {
                int n = in.readInt();
                if (n >= 0) {
                    List<T> list = new ArrayList<T>();
                    for (int i = 0; i < n; i++) {
                        list.add(child.readFromStream(in));
                    }
                    return list;
                } else {
                    return null;
                }
            }
            @Override
            public void writeToStream(DataOutputStream out, List<T> value) throws IOException {
                if (value != null) {
                    out.writeInt(value.size());
                    for (T v : value) {
                        child.writeToStream(out, v);
                    }
                } else {
                    out.writeInt(-1);
                }
            }
            @Override
            public List<T> readFromParcel(Parcel p) {
                int n = p.readInt();
                if (n >= 0) {
                    List<T> list = new ArrayList<T>();
                    for (int i = 0; i < n; i++) {
                        list.add(child.readFromParcel(p));
                    }
                    return list;
                } else {
                    return null;
                }
            }

            @Override
            public void writeToParcel(Parcel p, List<T> value) {
                if (value != null) {
                    p.writeInt(value.size());
                    for (T v : value) {
                        child.writeToParcel(p, v);
                    }
                } else {
                    p.writeInt(-1);
                }
            }

            @Override
            public List<T> readFromCursor(Cursor c, int idx, List<T> defaultValue) {
                byte[] bs = BLOB.readFromCursor(c, idx, null);
                if (bs != null) {
                    try {
                        DataInputStream din = new DataInputStream(new ByteArrayInputStream(bs));
                        return readFromStream(din);
                    } catch (IOException e) {
                        return defaultValue;
                    }
                } else {
                    return defaultValue;
                }
            }

            @Override
            public void putToContentValues(ContentValues values, String columnName, List<T> value) {
                byte[] bs = null;
                if (value != null) {
                    try {
                        ByteArrayOutputStream bout = new ByteArrayOutputStream();
                        DataOutputStream dout = new DataOutputStream(bout);
                        writeToStream(dout, value);
                        dout.flush();
                        bs = bout.toByteArray();
                    } catch (IOException e) {
                        // ignore
                    }
                }
                values.put(columnName, bs);
            }

            @Override
            public String stringValue(List<T> value) {
                return value != null ? String.valueOf(value) : null;
            }
        };
    }

    public static <T> IAccessor<T[]> createArrayAccessor(final IAccessor<T> child, final Class<T> cls) {
        return new IAccessor<T[]>() {
            @Override
            public T[] readFromStream(DataInputStream in) throws IOException {
                int n = in.readInt();
                if (n >= 0) {
                    @SuppressWarnings("unchecked")
                    T[] list = (T[])Array.newInstance(cls, n);
                    for (int i = 0; i < n; i++) {
                        list[i]= child.readFromStream(in);
                    }
                    return list;
                } else {
                    return null;
                }
            }
            @Override
            public void writeToStream(DataOutputStream out, T[] value) throws IOException {
                if (value != null) {
                    out.writeInt(value.length);
                    for (T v : value) {
                        child.writeToStream(out, v);
                    }
                } else {
                    out.writeInt(-1);
                }
            }
            @Override
            public T[] readFromParcel(Parcel p) {
                int n = p.readInt();
                if (n >= 0) {
                    @SuppressWarnings("unchecked")
                    T[] list = (T[])Array.newInstance(cls, n);
                    for (int i = 0; i < n; i++) {
                        list[i] = child.readFromParcel(p);
                    }
                    return list;
                } else {
                    return null;
                }
            }

            @Override
            public void writeToParcel(Parcel p, T[] value) {
                if (value != null) {
                    p.writeInt(value.length);
                    for (T v : value) {
                        child.writeToParcel(p, v);
                    }
                } else {
                    p.writeInt(-1);
                }
            }

            @Override
            public T[] readFromCursor(Cursor c, int idx, T[] defaultValue) {
                byte[] bs = BLOB.readFromCursor(c, idx, null);
                if (bs != null) {
                    try {
                        DataInputStream din = new DataInputStream(new ByteArrayInputStream(bs));
                        return readFromStream(din);
                    } catch (IOException e) {
                        return defaultValue;
                    }
                } else {
                    return defaultValue;
                }
            }

            @Override
            public void putToContentValues(ContentValues values, String columnName, T[] value) {
                byte[] bs = null;
                if (value != null) {
                    try {
                        ByteArrayOutputStream bout = new ByteArrayOutputStream();
                        DataOutputStream dout = new DataOutputStream(bout);
                        writeToStream(dout, value);
                        dout.flush();
                        bs = bout.toByteArray();
                    } catch (IOException e) {
                        // ignore
                    }
                }
                values.put(columnName, bs);
            }

            @Override
            public String stringValue(T[] value) {
                return value != null ? String.valueOf(value) : null;
            }
        };
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
