package net.cattaka.util.cathandsgendroid.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation for Accessor.
 * 
 * @author sumitomo
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AccessorAttrs {
	/**
	 * Indicate that which data type the accessor uses.
	 * 
	 * @return data type on DB
	 */
	String dbDataType() default "TEXT";
}
