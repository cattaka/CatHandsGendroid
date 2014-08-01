
package net.cattaka.util.cathandsgendroid.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation for DataModel.
 * 
 * @see DataModelAttrs
 * @author cattaka
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface DataModel {
	/**
	 * Conversion rule for table name and column name.
	 * @author sumitomo
	 */
    enum NamingConventions {
    	/**
    	 * LowerCamelCase. If the class name is "TheDataModel", the table name become "theDataModel".
    	 */
        LOWER_CAMEL_CASE,
        /**
         * UpperCamelCase. If the class name is "TheDataModel", the table name become "TheDataModel".
         */
        UPPER_CAMEL_CASE,
        /**
         * LowerComposite. If the class name is "TheDataModel", the table name become "the_data_model".
         */
        LOWER_COMPOSITE,
        /**
         * UpperComposite. If the class name is "TheDataModel", the table name become "THE_DATA_MODEL".
         */
        UPPER_COMPOSITE,
    }

    /**
     * Indicate conversion rule for table name.
     * @return conversion rule for table name
     */
    NamingConventions tableNamingConventions() default NamingConventions.LOWER_CAMEL_CASE;

    /**
     * Indicate conversion rule for column name.
     * 
     * @return conversion rule for column name
     */
    NamingConventions fieldNamingConventions() default NamingConventions.LOWER_CAMEL_CASE;

    String[] find() default {};

    String[] unique() default {};

    boolean columnIndexConstants() default true;

    boolean columnNameConstants() default true;

    boolean autoincrement() default true;

    boolean genDbFunc() default true;

    boolean genParcelFunc() default false;

    boolean genContentResolverFunc() default false;

}
