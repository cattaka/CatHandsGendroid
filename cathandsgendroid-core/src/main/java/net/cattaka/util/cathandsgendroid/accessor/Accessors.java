
package net.cattaka.util.cathandsgendroid.accessor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

public class Accessors {

    public static class PrimitiveByteAccessor implements IAccessor<Byte> {
        static PrimitiveByteAccessor instance;

        public static IAccessor<Byte> createAccessor(Class<Byte> clazz) {
            if (instance == null) {
                instance = new PrimitiveByteAccessor();
            }
            return instance;
        }

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
        public Byte readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : (byte)c.getShort(idx));
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

    public static class PrimitiveShortAccessor implements IAccessor<Short> {
        static PrimitiveShortAccessor instance;

        public static IAccessor<Short> createAccessor(Class<Short> clazz) {
            if (instance == null) {
                instance = new PrimitiveShortAccessor();
            }
            return instance;
        }

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
        public Short readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : c.getShort(idx));
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

    public static class PrimitiveIntegerAccessor implements IAccessor<Integer> {
        static PrimitiveIntegerAccessor instance;

        public static IAccessor<Integer> createAccessor(Class<Integer> clazz) {
            if (instance == null) {
                instance = new PrimitiveIntegerAccessor();
            }
            return instance;
        }

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
        public Integer readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : c.getInt(idx));
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

    public static class PrimitiveLongAccessor implements IAccessor<Long> {
        static PrimitiveLongAccessor instance;

        public static IAccessor<Long> createAccessor(Class<Long> clazz) {
            if (instance == null) {
                instance = new PrimitiveLongAccessor();
            }
            return instance;
        }

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
        public Long readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : c.getLong(idx));
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

    public static class PrimitiveFloatAccessor implements IAccessor<Float> {
        static PrimitiveFloatAccessor instance;

        public static IAccessor<Float> createAccessor(Class<Float> clazz) {
            if (instance == null) {
                instance = new PrimitiveFloatAccessor();
            }
            return instance;
        }

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
        public Float readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : c.getFloat(idx));
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

    public static class PrimitiveDoubleAccessor implements IAccessor<Double> {
        static PrimitiveDoubleAccessor instance;

        public static IAccessor<Double> createAccessor(Class<Double> clazz) {
            if (instance == null) {
                instance = new PrimitiveDoubleAccessor();
            }
            return instance;
        }

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
        public Double readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : c.getDouble(idx));
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

    public static class PrimitiveCharacterAccessor implements IAccessor<Character> {
        static PrimitiveCharacterAccessor instance;

        public static IAccessor<Character> createAccessor(Class<Character> clazz) {
            if (instance == null) {
                instance = new PrimitiveCharacterAccessor();
            }
            return instance;
        }

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
        public Character readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : (char)c.getShort(idx));
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

    public static class PrimitiveBooleanAccessor implements IAccessor<Boolean> {
        static PrimitiveBooleanAccessor instance;

        public static IAccessor<Boolean> createAccessor(Class<Boolean> clazz) {
            if (instance == null) {
                instance = new PrimitiveBooleanAccessor();
            }
            return instance;
        }

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
        public Boolean readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : (c.getShort(idx) != 0));
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

    public static class ByteAccessor implements IAccessor<Byte> {
        static ByteAccessor instance;

        public static IAccessor<Byte> createAccessor(Class<Byte> clazz) {
            if (instance == null) {
                instance = new ByteAccessor();
            }
            return instance;
        }

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
        public Byte readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : (byte)c.getInt(idx));
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

    public static class ShortAccessor implements IAccessor<Short> {
        static ShortAccessor instance;

        public static IAccessor<Short> createAccessor(Class<Short> clazz) {
            if (instance == null) {
                instance = new ShortAccessor();
            }
            return instance;
        }

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
        public Short readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx)) ? null : c.getShort(idx);
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

    public static class IntegerAccessor implements IAccessor<Integer> {
        static IntegerAccessor instance;

        public static IAccessor<Integer> createAccessor(Class<Integer> clazz) {
            if (instance == null) {
                instance = new IntegerAccessor();
            }
            return instance;
        }

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
        public Integer readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : c.getInt(idx));
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

    public static class LongAccessor implements IAccessor<Long> {
        static LongAccessor instance;

        public static IAccessor<Long> createAccessor(Class<Long> clazz) {
            if (instance == null) {
                instance = new LongAccessor();
            }
            return instance;
        }

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
        public Long readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : c.getLong(idx));
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

    public static class FloatAccessor implements IAccessor<Float> {
        static FloatAccessor instance;

        public static IAccessor<Float> createAccessor(Class<Float> clazz) {
            if (instance == null) {
                instance = new FloatAccessor();
            }
            return instance;
        }

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
        public Float readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : c.getFloat(idx));
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

    public static class DoubleAccessor implements IAccessor<Double> {
        static DoubleAccessor instance;

        public static IAccessor<Double> createAccessor(Class<Double> clazz) {
            if (instance == null) {
                instance = new DoubleAccessor();
            }
            return instance;
        }

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
        public Double readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : c.getDouble(idx));
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

    public static class CharacterAccessor implements IAccessor<Character> {
        static CharacterAccessor instance;

        public static IAccessor<Character> createAccessor(Class<Character> clazz) {
            if (instance == null) {
                instance = new CharacterAccessor();
            }
            return instance;
        }

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
        public Character readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : (char)c.getShort(idx));
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

    public static class BooleanAccessor implements IAccessor<Boolean> {
        static BooleanAccessor instance;

        public static IAccessor<Boolean> createAccessor(Class<Boolean> clazz) {
            if (instance == null) {
                instance = new BooleanAccessor();
            }
            return instance;
        }

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
        public Boolean readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : (c.getShort(idx) != 0));
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

    public static class StringAccessor implements IAccessor<String> {
        static StringAccessor instance;

        public static IAccessor<String> createAccessor(Class<String> clazz) {
            if (instance == null) {
                instance = new StringAccessor();
            }
            return instance;
        }

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
        public String readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : (c.getString(idx)));
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

    public static class BlobAccessor implements IAccessor<byte[]> {
        static BlobAccessor instance;

        public static IAccessor<byte[]> createAccessor(Class<byte[]> clazz) {
            if (instance == null) {
                instance = new BlobAccessor();
            }
            return instance;
        }

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
        public byte[] readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : (c.getBlob(idx)));
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

    public static class BundleAccessor implements IAccessor<Bundle> {
        static BundleAccessor instance;

        public static IAccessor<Bundle> createAccessor(Class<Bundle> clazz) {
            if (instance == null) {
                instance = new BundleAccessor();
            }
            return instance;
        }

        @Override
        public Bundle readFromStream(DataInputStream in) throws IOException {
            return (Bundle)ParcelableAccessor.createAccessor(Parcelable.class).readFromStream(in);
        }

        @Override
        public void writeToStream(DataOutputStream out, Bundle value) throws IOException {
            ParcelableAccessor.createAccessor(Parcelable.class).writeToStream(out, value);
        }

        @Override
        public Bundle readFromParcel(Parcel p) {
            if (p.readByte() != 0) {
                return p.readBundle(Accessors.class.getClassLoader());
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
        public Bundle readFromCursor(Cursor c, int idx) {
            return (Bundle)ParcelableAccessor.createAccessor(Parcelable.class).readFromCursor(c,
                    idx);
        }

        @Override
        public void putToContentValues(ContentValues values, String columnName, Bundle value) {
            ParcelableAccessor.createAccessor(Parcelable.class).putToContentValues(values,
                    columnName, value);
        }

        @Override
        public String stringValue(Bundle value) {
            return (value != null) ? value.toString() : null;
        }
    };

    public static class DateAccessor implements IAccessor<Date> {
        static DateAccessor instance;

        public static IAccessor<Date> createAccessor(Class<Date> clazz) {
            if (instance == null) {
                instance = new DateAccessor();
            }
            return instance;
        }

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
        public Date readFromCursor(Cursor c, int idx) {
            return (c.isNull(idx) ? null : new Date(c.getLong(idx)));
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
            public List<T> readFromCursor(Cursor c, int idx) {
                byte[] bs = BlobAccessor.createAccessor(byte[].class).readFromCursor(c, idx);
                if (bs != null) {
                    try {
                        DataInputStream din = new DataInputStream(new ByteArrayInputStream(bs));
                        return readFromStream(din);
                    } catch (IOException e) {
                        return null;
                    }
                } else {
                    return null;
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

    public static <T> IAccessor<T[]> createArrayAccessor(final IAccessor<T> child,
            final Class<T> cls) {
        return new IAccessor<T[]>() {
            @Override
            public T[] readFromStream(DataInputStream in) throws IOException {
                int n = in.readInt();
                if (n >= 0) {
                    @SuppressWarnings("unchecked")
                    T[] list = (T[])Array.newInstance(cls, n);
                    for (int i = 0; i < n; i++) {
                        list[i] = child.readFromStream(in);
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
            public T[] readFromCursor(Cursor c, int idx) {
                byte[] bs = BlobAccessor.createAccessor(byte[].class).readFromCursor(c, idx);
                if (bs != null) {
                    try {
                        DataInputStream din = new DataInputStream(new ByteArrayInputStream(bs));
                        return readFromStream(din);
                    } catch (IOException e) {
                        return null;
                    }
                } else {
                    return null;
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

    static byte[] toByteArray(Serializable src) {
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
}
