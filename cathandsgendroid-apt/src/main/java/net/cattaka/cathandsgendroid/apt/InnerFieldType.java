
package net.cattaka.cathandsgendroid.apt;

public class InnerFieldType {
    /** */
    public static final InnerFieldType P_BYTE = new InnerFieldType(true, true, //
            "INTEGER", "0", //
            "Accessor.readPbyteFromParcel(%1$s)", //
            "Accessor.writePbyteToParcel(%1$s, %2$s)", //
            "Accessor.readPbyteFromCursor(%1$s, %2$s, (byte)%3$s)", //
            "Accessor.putPbyteToContentValues(%1$s, %2$s, %3$s)", //
            "String.valueOf(%1$s)" //
    );

    /** */
    public static final InnerFieldType P_SHORT = new InnerFieldType(true, true, //
            "INTEGER", "0", //
            "Accessor.readPshortFromParcel(%1$s)", //
            "Accessor.writePshortToParcel(%1$s, %2$s)", //
            "Accessor.readPshortFromCursor(%1$s, %2$s, (short)%3$s)", //
            "Accessor.putPshortToContentValues(%1$s, %2$s, %3$s)", //
            "String.valueOf(%1$s)" //
    );

    /** */
    public static final InnerFieldType P_INT = new InnerFieldType(true, true, //
            "INTEGER", "0", //
            "Accessor.readPintFromParcel(%1$s)", //
            "Accessor.writePintToParcel(%1$s, %2$s)", //
            "Accessor.readPintFromCursor(%1$s, %2$s, %3$s)", //
            "Accessor.putPintToContentValues(%1$s, %2$s, %3$s)", //
            "String.valueOf(%1$s)" //
    );

    /** */
    public static final InnerFieldType P_LONG = new InnerFieldType(true, true, //
            "INTEGER", "0", //
            "Accessor.readPlongFromParcel(%1$s)", //
            "Accessor.writePlongToParcel(%1$s, %2$s)", //
            "Accessor.readPlongFromCursor(%1$s, %2$s, (long)%3$s)", //
            "Accessor.putPlongToContentValues(%1$s, %2$s, %3$s)", //
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType P_FLOAT = new InnerFieldType(false, true, //
            "REAL", "0", //
            "Accessor.readPfloatFromParcel(%1$s)", //
            "Accessor.writePfloatToParcel(%1$s, %2$s)", //
            "Accessor.readPfloatFromCursor(%1$s, %2$s, (float)%3$s)", //
            "Accessor.putPfloatToContentValues(%1$s, %2$s, %3$s)", //
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType P_DOUBLE = new InnerFieldType(false, true,//
            "REAL", "0", //
            "Accessor.readPdoubleFromParcel(%1$s)", //
            "Accessor.writePdoubleToParcel(%1$s, %2$s)", //
            "Accessor.readPdoubleFromCursor(%1$s, %2$s, %3$s)", //
            "Accessor.putPdoubleToContentValues(%1$s, %2$s, %3$s)", //
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType P_CHAR = new InnerFieldType(true, true, //
            "INTEGER", "0", //
            "Accessor.readPcharFromParcel(%1$s)", //
            "Accessor.writePcharToParcel(%1$s, %2$s)", //
            "Accessor.readPcharFromCursor(%1$s, %2$s, (char)%3$s)", //
            "Accessor.putPcharToContentValues(%1$s, %2$s, %3$s)", //
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType P_BOOLEAN = new InnerFieldType(false, true, //
            "INTEGER", "false", //
            "Accessor.readPbooleanFromParcel(%1$s)", //
            "Accessor.writePbooleanToParcel(%1$s, %2$s)", //
            "Accessor.readPbooleanFromCursor(%1$s, %2$s, %3$s)", //
            "Accessor.putPbooleanToContentValues(%1$s, %2$s, %3$s)",//
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType BYTE = new InnerFieldType(true, false, //
            "INTEGER", "null", //
            "Accessor.readByteFromParcel(%1$s)", //
            "Accessor.writeByteToParcel(%1$s, %2$s)", //
            "Accessor.readByteFromCursor(%1$s, %2$s)", //
            "Accessor.putByteToContentValues(%1$s, %2$s, %3$s)",//
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType SHORT = new InnerFieldType(true, false, //
            "INTEGER", "null", //
            "Accessor.readShortFromParcel(%1$s)", //
            "Accessor.writeShortToParcel(%1$s, %2$s)", //
            "Accessor.readShortFromCursor(%1$s, %2$s)", //
            "Accessor.putShortToContentValues(%1$s, %2$s, %3$s)",//
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType INTEGER = new InnerFieldType(true, false, //
            "INTEGER", "null", //
            "Accessor.readIntegerFromParcel(%1$s)", //
            "Accessor.writeIntegerToParcel(%1$s, %2$s)", //
            "Accessor.readIntegerFromCursor(%1$s, %2$s)", //
            "Accessor.putIntegerToContentValues(%1$s, %2$s, %3$s)", //
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType LONG = new InnerFieldType(true, false, //
            "INTEGER", "null", //
            "Accessor.readLongFromParcel(%1$s)", //
            "Accessor.writeLongToParcel(%1$s, %2$s)", //
            "Accessor.readLongFromCursor(%1$s, %2$s)", //
            "Accessor.putLongToContentValues(%1$s, %2$s, %3$s)",//
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType FLOAT = new InnerFieldType(false, false,//
            "REAL", "null", //
            "Accessor.readFloatFromParcel(%1$s)", //
            "Accessor.writeFloatToParcel(%1$s, %2$s)", //
            "Accessor.readFloatFromCursor(%1$s, %2$s)", //
            "Accessor.putFloatToContentValues(%1$s, %2$s, %3$s)",//
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType DOUBLE = new InnerFieldType(false, false,//
            "REAL", "null", //
            "Accessor.readDoubleFromParcel(%1$s)", //
            "Accessor.writeDoubleToParcel(%1$s, %2$s)", //
            "Accessor.readDoubleFromCursor(%1$s, %2$s)", //
            "Accessor.putDoubleToContentValues(%1$s, %2$s, %3$s)", //
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType CHAR = new InnerFieldType(true, false, //
            "INTEGER", "null", //
            "Accessor.readCharacterFromParcel(%1$s)", //
            "Accessor.writeCharacterToParcel(%1$s, %2$s)", //
            "Accessor.readCharacterFromCursor(%1$s, %2$s)", //
            "Accessor.putCharacterToContentValues(%1$s, %2$s, %3$s)",//
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType BOOLEAN = new InnerFieldType(false, false, //
            "INTEGER", "null", //
            "Accessor.readBooleanFromParcel(%1$s)", //
            "Accessor.writeBooleanToParcel(%1$s, %2$s)", //
            "Accessor.readBooleanFromCursor(%1$s, %2$s)", //
            "Accessor.putBooleanToContentValues(%1$s, %2$s, %3$s)", //
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType STRING = new InnerFieldType(false, false,//
            "TEXT", "null", //
            "Accessor.readStringFromParcel(%1$s)", //
            "Accessor.writeStringToParcel(%1$s, %2$s)", //
            "Accessor.readStringFromCursor(%1$s, %2$s)", //
            "Accessor.putStringToContentValues(%1$s, %2$s, %3$s)",//
            "Accessor.toString(%1$s)" //
    );

    /** */
    public static final InnerFieldType SERIALIZABLE = new InnerFieldType(false, false,//
            "BLOB", "null", //
            "Accessor.readSerializableFromParcel(%1$s)", //
            "Accessor.writeSerializableToParcel(%1$s, %2$s)", //
            "Accessor.readSerializableFromCursor(%1$s, %2$s)", //
            "Accessor.putSerializableToContentValues(%1$s, %2$s, %3$s)",//
            "not Supported" //
    );

    /** */
    public static final InnerFieldType PARCELABLE = new InnerFieldType(false, false,//
            "BLOB", "null", //
            "Accessor.readParcelableFromParcel(%1$s, Accessor.class.getClassLoader())", //
            "Accessor.writeParcelableToParcel(%1$s, %2$s)", //
            "Accessor.readParcelableFromCursor(%1$s, %2$s, Accessor.class.getClassLoader())", //
            "Accessor.putParcelableToContentValues(%1$s, %2$s, %3$s)",//
            "not Supported" //
    );

    /** */
    public static final InnerFieldType BLOB = new InnerFieldType(false, false,//
            "BLOB", "null", //
            "Accessor.readBlobFromParcel(%1$s)", //
            "Accessor.writeBlobToParcel(%1$s, %2$s)", //
            "Accessor.readBlobFromCursor(%1$s, %2$s)", //
            "Accessor.putBlobToContentValues(%1$s, %2$s, %3$s)", //
            "not Supported" //
    );

    /** */
    public static final InnerFieldType ENUM_NAME = new InnerFieldType(false, false,//
            "TEXT", "null", //
            "Accessor.readEnumFromParcel(%1$s, %2$s.class)", //
            "Accessor.writeEnumToParcel(%1$s, %2$s)", //
            "Accessor.readEnumFromCursor(%1$s, %2$s, %4$s.class)", //
            "Accessor.putEnumToContentValues(%1$s, %2$s, %3$s)", //
            "Accessor.toStringName(%1$s)" //
    );

    /** */
    public static final InnerFieldType ENUM_ORDER = new InnerFieldType(false, false,//
            "INTEGER", "null", //
            "Accessor.readpIntegerFromParcel(%1$s)", //
            "Accessor.writeIntegerToParcel(%1$s, %2$s)", //
            "Accessor.readIntegerFromCursor(%1$s, %2$s)", //
            "Accessor.putIntegerToContentValues(%1$s, %2$s, %3$s)", //
            "Accessor.toStringOrder(%1$s)" //
    );

    /** */
    public static final InnerFieldType DATE = new InnerFieldType(false, false,//
            "INTEGER", "null", //
            "Accessor.readDateFromParcel(%1$s)", //
            "Accessor.writeDateToParcel(%1$s, %2$s)", //
            "Accessor.readDateFromCursor(%1$s, %2$s)", //
            "Accessor.putDateToContentValues(%1$s, %2$s, %3$s)", "Accessor.toString(%1$s)" //
    );

    public final boolean isInteger;

    public final boolean isPrimitive;

    public final String dbType;

    public final String defaultNullValue;

    public final String readFromParcel;

    public final String writeToParcel;

    public final String readFromCursor;

    public final String putToContentValue;

    public final String getterBlock;

    public final String setterBlock;

    public final String toStringBlock;

    public InnerFieldType(boolean isNumber, boolean isPrimitive, String dbType,
            String defaultNullValue, String readFromParcel, String writeToParcel,
            String readFromCursor, String putToContentValue, String toStringBlock) {
        this(isNumber, isPrimitive, dbType, defaultNullValue, readFromParcel, writeToParcel,
                readFromCursor, putToContentValue, toStringBlock, "%1$s.get%2$s()",
                "%1$s.set%2$s(%3$s)");
    }

    public InnerFieldType(boolean isNumber, boolean isPrimitive, String dbType,
            String defaultNullValue, String readFromParcel, String writeToParcel,
            String readFromCursor, String putToContentValue, String toStringBlock,
            String getterBlock, String setterBlock) {
        super();
        this.isInteger = isNumber;
        this.isPrimitive = isPrimitive;
        this.dbType = dbType;
        this.defaultNullValue = defaultNullValue;
        this.readFromParcel = readFromParcel;
        this.writeToParcel = writeToParcel;
        this.readFromCursor = readFromCursor;
        this.putToContentValue = putToContentValue;
        this.getterBlock = getterBlock;
        this.setterBlock = setterBlock;
        this.toStringBlock = toStringBlock;
    }

}
