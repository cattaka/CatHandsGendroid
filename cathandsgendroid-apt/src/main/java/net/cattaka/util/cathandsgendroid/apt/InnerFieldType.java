
package net.cattaka.util.cathandsgendroid.apt;

import java.util.Locale;

public class InnerFieldType {
    public static final InnerFieldType BLOB = new InnerFieldType(false, "Accessor.BlobAccessor.createAccessor(byte[].class)", "BLOB", "byte[]", null);
    public static final InnerFieldType BOOLEAN = new InnerFieldType(false, "Accessor.BooleanAccessor.createAccessor(Boolean.class)", "INTEGER", "Boolean", null);
    public static final InnerFieldType BUNDLE = new InnerFieldType(false, "Accessor.BundleAccessor.createAccessor(Bundle.class)", "BLOB", "Bundle", null);
    public static final InnerFieldType BYTE = new InnerFieldType(false, "Accessor.ByteAccessor.createAccessor(Byte.class)", "INTEGER", "Byte", "byte");
    public static final InnerFieldType CHARACTER = new InnerFieldType(false, "Accessor.CharacterAccessor.createAccessor(Character.class)", "INTEGER", "Character", "char");
    public static final InnerFieldType DATE = new InnerFieldType(false, "Accessor.DateAccessor.createAccessor(java.util.Date.class)", "INTEGER", "java.util.Date", null);
    public static final InnerFieldType DOUBLE = new InnerFieldType(false, "Accessor.DoubleAccessor.createAccessor(Double.class)", "REAL", "Double", "double");
    public static final InnerFieldType FLOAT = new InnerFieldType(false, "Accessor.FloatAccessor.createAccessor(Float.class)", "REAL", "Float", "float");
    public static final InnerFieldType INTEGER = new InnerFieldType(false, "Accessor.IntegerAccessor.createAccessor(Integer.class)", "INTEGER", "Integer", "int");
    public static final InnerFieldType LONG = new InnerFieldType(false, "Accessor.LongAccessor.createAccessor(Long.class)", "INTEGER", "Long", "long");
    public static final InnerFieldType P_BOOLEAN = new InnerFieldType(true, "Accessor.PrimitiveBooleanAccessor.createAccessor(Boolean.class)", "INTEGER", "Boolean", null);
    public static final InnerFieldType P_BYTE = new InnerFieldType(true, "Accessor.PrimitiveByteAccessor.createAccessor(Byte.class)", "INTEGER", "Byte", "byte");
    public static final InnerFieldType P_CHARACTER = new InnerFieldType(true, "Accessor.PrimitiveCharacterAccessor.createAccessor(Character.class)", "INTEGER", "Character", "char");
    public static final InnerFieldType P_DOUBLE = new InnerFieldType(true, "Accessor.PrimitiveDoubleAccessor.createAccessor(Double.class)", "REAL", "Double", "double");
    public static final InnerFieldType P_FLOAT = new InnerFieldType(true, "Accessor.PrimitiveFloatAccessor.createAccessor(Float.class)", "REAL", "Float", "float");
    public static final InnerFieldType P_INTEGER = new InnerFieldType(true, "Accessor.PrimitiveIntegerAccessor.createAccessor(Integer.class)", "INTEGER", "Integer", "int");
    public static final InnerFieldType P_LONG = new InnerFieldType(true, "Accessor.PrimitiveLongAccessor.createAccessor(Long.class)", "INTEGER", "Long", "long");
    public static final InnerFieldType P_SHORT = new InnerFieldType(true, "Accessor.PrimitiveShortAccessor.createAccessor(Short.class)", "INTEGER", "Short", "short");
    public static final InnerFieldType PARCELABLE = new InnerFieldType(false, "Accessor.ParcelableAccessor.createAccessor(android.os.Parcelable.class)", "BLOB", "android.os.Parcelable", null);
    public static final InnerFieldType SHORT = new InnerFieldType(false, "Accessor.ShortAccessor.createAccessor(Short.class)", "INTEGER", "Short", "short");
    public static final InnerFieldType STRING = new InnerFieldType(false, "Accessor.StringAccessor.createAccessor(String.class)", "TEXT", "String", null);

    public final String accessor;
    public final String dbDataType;
    public final String javaDataType;
    public final String origJavaDataType;
    public final String primitiveJavaDataType;
    public final boolean primitiveType;

	public InnerFieldType(boolean primitiveType, String accessor, String dbDataType, String javaDataType, String primitiveJavaDataType) {
		this(primitiveType, accessor, dbDataType, javaDataType, javaDataType, primitiveJavaDataType);
	}

	private InnerFieldType(boolean primitiveType, String accessor,
			String dbDataType, String javaDataType, String origJavaDataType, String primitiveJavaDataType) {
		super();
		this.primitiveType = primitiveType;
		this.accessor = accessor;
		this.dbDataType = dbDataType;
		this.javaDataType = javaDataType;
		this.origJavaDataType = origJavaDataType;
		this.primitiveJavaDataType = (primitiveJavaDataType != null) ? primitiveJavaDataType : "(not supported)";
	}
	
    public static InnerFieldType createCustomType(String name, String accessor, String dbDataType) {
        return new InnerFieldType(false, String.format(Locale.ROOT, accessor + ".createAccessor(%1$s.class)", name), dbDataType, String.valueOf(name), String.valueOf(name), null);
    }
	public static InnerFieldType createListType(InnerFieldType ift) {
	    String javaDataType = String.format("java.util.List<%1$s>", ift.javaDataType);
		return new InnerFieldType(false, String.format(Locale.ROOT, "Accessor.createListAccessor(%1$s)", ift.accessor), "BLOB", javaDataType, null);
	}
	public static InnerFieldType createArrayType(InnerFieldType ift) {
        String javaDataType = String.format("%1$s[]", ift.javaDataType);
		return new InnerFieldType(false, String.format(Locale.ROOT, "Accessor.createArrayAccessor(%1$s)", ift.accessor), "BLOB", javaDataType, null);
	}
}
