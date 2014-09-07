
package net.cattaka.util.cathandsgendroid.annotation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.cattaka.util.cathandsgendroid.accessor.IAccessor;

/**
 * An annotation for fields of DataModel.
 * 
 * @see DataModel
 * @author cattaka
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface DataModelAttrs {
    /**
     * Specify whether this field is ignored.
     * 
     * @return If true this is ignored.
     */
    boolean ignore() default false;

    /**
     * Specify whether this field is used for DB.
     * 
     * @return If true this is used for DB.
     */
    boolean forDb() default true;

    /**
     * Specify whether this field is used for Parcel.
     * 
     * @return If true this is used for Parcel.
     */
    boolean forParcel() default true;

    /**
     * Specify whether this field is used for ContentResolver.
     * 
     * @return If true this is used for ContentResolver.
     */
    boolean forContentResolver() default true;

    /**
     * Specify whether this field is used for {@link DataOutputStream} and {@link DataInputStream}.
     * 
     * @return If true this is used for DB.
     */
    boolean forDs() default true;

    /**
     * Specify whether or not the primary key.
     * 
     * @return If true this is used as primary key.
     */
    boolean primaryKey() default false;

    /**
     * Specify DB version when this field added.
     * 
     * @return DB version when this field added.
     */
    long version() default 1;

    /**
     * Indicate Custom accessor for this field.
     * 
     * @return Custom accessor for this field
     */
    @SuppressWarnings("rawtypes")
    Class<? extends IAccessor> accessor() default IAccessor.class;
}
