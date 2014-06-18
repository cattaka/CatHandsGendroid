
package net.cattaka.util.gendbhandler;

public @interface Attribute {
    public enum FieldType {
        /** */
        P_BYTE,
        /** */
        P_SHORT,
        /** */
        P_INT,
        /** */
        P_LONG,
        /** */
        P_FLOAT,
        /** */
        P_DOUBLE,
        /** */
        P_CHAR,
        /** */
        P_BOOLEAN,
        /** */
        BYTE,
        /** */
        SHORT,
        /** */
        INTEGER,
        /** */
        LONG,
        /** */
        FLOAT,
        /** */
        DOUBLE,
        /** */
        CHAR,
        /** */
        BOOLEAN,
        /** */
        STRING,
        /** */
        SERIALIZABLE,
        /** */
        PARCELABLE,
        /** */
        BLOB
    }

    boolean persistent() default true;

    boolean forDb() default true;
    boolean forParcel() default true;
    boolean forContentResolver() default true;

    boolean primaryKey() default false;

    long version() default 1;

    Class<?> customCoder() default Object.class;

    FieldType customDataType() default FieldType.STRING;

    String nullValue() default "";
}
