
package net.cattaka.util.cathandsgendroid.annotation;

import net.cattaka.util.cathandsgendroid.accessor.IAccessor;

public @interface DataModelAttrs {
    boolean ignore() default false;
    boolean forDb() default true;
    boolean forParcel() default true;
    boolean forContentResolver() default true;

    boolean primaryKey() default false;

    long version() default 1;

    String dbDataType() default "";
	@SuppressWarnings("rawtypes")
    Class<? extends IAccessor> accessor() default IAccessor.class;

    String nullValue() default "null";
}
