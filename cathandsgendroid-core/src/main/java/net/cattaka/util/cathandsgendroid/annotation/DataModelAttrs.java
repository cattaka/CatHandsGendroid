
package net.cattaka.util.cathandsgendroid.annotation;

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
    boolean ignore() default false;
    boolean forDb() default true;
    boolean forParcel() default true;
    boolean forContentResolver() default true;

    boolean primaryKey() default false;

    long version() default 1;

	@SuppressWarnings("rawtypes")
    Class<? extends IAccessor> accessor() default IAccessor.class;

    String nullValue() default "null";
}
