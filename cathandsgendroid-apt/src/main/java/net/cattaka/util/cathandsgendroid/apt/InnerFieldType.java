
package net.cattaka.util.cathandsgendroid.apt;

import java.util.Locale;

public class InnerFieldType {
    public static final InnerFieldType BLOB = new InnerFieldType(false, "Accessor.BlobAccessor.createAccessor(byte[].class)", "BLOB", "byte[]");
    public static final InnerFieldType BOOLEAN = new InnerFieldType(false, "Accessor.BooleanAccessor.createAccessor(Boolean.class)", "BOOLEAN", "Boolean");
    public static final InnerFieldType BUNDLE = new InnerFieldType(false, "Accessor.BundleAccessor.createAccessor(Bundle.class)", "BUNDLE", "Bundle");
    public static final InnerFieldType BYTE = new InnerFieldType(false, "Accessor.ByteAccessor.createAccessor(Byte.class)", "BYTE", "Byte");
    public static final InnerFieldType CHARACTER = new InnerFieldType(false, "Accessor.CharacterAccessor.createAccessor(Character.class)", "CHARACTER", "Character");
    public static final InnerFieldType DATE = new InnerFieldType(false, "Accessor.DateAccessor.createAccessor(java.util.Date.class)", "DATE", "java.util.Date");
    public static final InnerFieldType DOUBLE = new InnerFieldType(false, "Accessor.DoubleAccessor.createAccessor(Double.class)", "DOUBLE", "Double");
    public static final InnerFieldType FLOAT = new InnerFieldType(false, "Accessor.FloatAccessor.createAccessor(Float.class)", "FLOAT", "Float");
    public static final InnerFieldType INTEGER = new InnerFieldType(false, "Accessor.IntegerAccessor.createAccessor(Integer.class)", "INTEGER", "Integer");
    public static final InnerFieldType LONG = new InnerFieldType(false, "Accessor.LongAccessor.createAccessor(Long.class)", "LONG", "Long");
    public static final InnerFieldType P_BOOLEAN = new InnerFieldType(true, "Accessor.PrimitiveBooleanAccessor.createAccessor(Boolean.class)", "P_BOOLEAN", "Boolean");
    public static final InnerFieldType P_BYTE = new InnerFieldType(true, "Accessor.PrimitiveByteAccessor.createAccessor(Byte.class)", "P_BYTE", "Byte");
    public static final InnerFieldType P_CHARACTER = new InnerFieldType(true, "Accessor.PrimitiveCharacterAccessor.createAccessor(Character.class)", "P_CHARACTER", "Character");
    public static final InnerFieldType P_DOUBLE = new InnerFieldType(true, "Accessor.PrimitiveDoubleAccessor.createAccessor(Double.class)", "P_DOUBLE", "Double");
    public static final InnerFieldType P_FLOAT = new InnerFieldType(true, "Accessor.PrimitiveFloatAccessor.createAccessor(Float.class)", "P_FLOAT", "Float");
    public static final InnerFieldType P_INTEGER = new InnerFieldType(true, "Accessor.PrimitiveIntegerAccessor.createAccessor(Integer.class)", "P_INTEGER", "Integer");
    public static final InnerFieldType P_LONG = new InnerFieldType(true, "Accessor.PrimitiveLongAccessor.createAccessor(Long.class)", "P_LONG", "Long");
    public static final InnerFieldType P_SHORT = new InnerFieldType(true, "Accessor.PrimitiveShortAccessor.createAccessor(Short.class)", "P_SHORT", "Short");
    public static final InnerFieldType PARCELABLE = new InnerFieldType(false, "Accessor.ParcelableAccessor.createAccessor(android.os.Parcelable.class)", "BLOB", "android.os.Parcelable");
    public static final InnerFieldType SHORT = new InnerFieldType(false, "Accessor.ShortAccessor.createAccessor(Short.class)", "SHORT", "Short");
    public static final InnerFieldType STRING = new InnerFieldType(false, "Accessor.StringAccessor.createAccessor(String.class)", "STRING", "String");

    public final String accessor;
    public final String dbDataType;
    public final String javaDataType;
    public final String origJavaDataType;
    public final boolean primitiveType;

	public InnerFieldType(boolean primitiveType, String accessor, String dbDataType, String javaDataType) {
		this(primitiveType, accessor, dbDataType, javaDataType, javaDataType);
	}

	private InnerFieldType(boolean primitiveType, String accessor,
			String dbDataType, String javaDataType, String origJavaDataType) {
		super();
		this.primitiveType = primitiveType;
		this.accessor = accessor;
		this.dbDataType = dbDataType;
		this.javaDataType = javaDataType;
		this.origJavaDataType = origJavaDataType;
	}
	
    public static InnerFieldType createCustomType(String name, String accessor, String dbDataType) {
        return new InnerFieldType(false, String.format(Locale.ROOT, accessor + ".createAccessor(%1$s.class)", name), dbDataType, String.valueOf(name), String.valueOf(name));
    }
	public static InnerFieldType createListType(InnerFieldType ift) {
	    String javaDataType = String.format("java.util.List<%1$s>", ift.javaDataType);
		return new InnerFieldType(false, String.format(Locale.ROOT, "Accessor.createListAccessor(%1$s)", ift.accessor), "BLOB", javaDataType);
	}
	public static InnerFieldType createArrayType(InnerFieldType ift) {
        String javaDataType = String.format("%1$s[]", ift.javaDataType);
		return new InnerFieldType(false, String.format(Locale.ROOT, "Accessor.createArrayAccessor(%1$s)", ift.accessor), "BLOB", javaDataType);
	}
}
