
package net.cattaka.util.cathandsgendroid.annotation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
     * 
     * @author sumitomo
     */
    enum NamingConventions {
        /**
         * LowerCamelCase. If the class name is "TheDataModel", the table name
         * become "theDataModel".
         */
        LOWER_CAMEL_CASE,
        /**
         * UpperCamelCase. If the class name is "TheDataModel", the table name
         * become "TheDataModel".
         */
        UPPER_CAMEL_CASE,
        /**
         * LowerComposite. If the class name is "TheDataModel", the table name
         * become "the_data_model".
         */
        LOWER_COMPOSITE,
        /**
         * UpperComposite. If the class name is "TheDataModel", the table name
         * become "THE_DATA_MODEL".
         */
        UPPER_COMPOSITE,
    }

    /**
     * Specify conversion rule for table name.
     * 
     * @return conversion rule for table name
     */
    NamingConventions tableNamingConventions() default NamingConventions.LOWER_CAMEL_CASE;

    /**
     * Specify conversion rule for column name.
     * 
     * @return conversion rule for column name
     */
    NamingConventions fieldNamingConventions() default NamingConventions.LOWER_CAMEL_CASE;

    /**
     * Specify which fields are used for find. e.g
     * <ul>
     * <li>find="userId"</li>
     * <li>find={"userId", "userName", "team"}</li>
     * <li>find={"userId", "userName, team"}</li>
     * </ul>
     * 
     * @return Fields that are used for find.
     */
    String[] find() default {};

    /**
     * Specify which fields combinations are unique. e.g
     * <ul>
     * <li>unique="userId"</li>
     * <li>unique={"userId", "userName,team"}</li>
     * </ul>
     * 
     * @return Fields that are used for find.
     */
    String[] unique() default {};

    /**
     * Specify direct query sql. Note that column names must be same with field. e.g
     * <ul>
     * <li>unique={"Query1:select val1,val2 from mytable", "Query2:select max(val1) as val1, max(val2) as val2 from mytable"}</li>
     * </ul>
     * 
     * @return Fields that are used for query.
     */
    String[] query() default {};

    /**
     * Specify whether constants of column index are generated.
     * 
     * @return If true constants of column index are generated.
     */
    boolean columnIndexConstants() default true;

    /**
     * Specify whether constants of column name are generated.
     * 
     * @return If true constants of column name are generated.
     */
    boolean columnNameConstants() default true;

    /**
     * Specify whether this table of DB uses auto increment.
     * Note that if this is true, the field of primary key must be number type.
     * 
     * @return If true this table of DB uses auto increment.
     */
    boolean autoincrement() default true;

    /**
     * Specify whether this is used for DB.
     * 
     * @return If true methods for DB are generated.
     */
    boolean genDbFunc() default false;

    /**
     * Specify whether this is used for ParcelFunc.
     * 
     * @return If true methods for ParcelFunc are generated.
     */
    boolean genParcelFunc() default false;

    /**
     * Specify whether this is used for ContentResolverFunc.
     * 
     * @return If true methods for ContentResolverFunc are generated.
     */
    boolean genContentResolverFunc() default false;

    /**
     * Specify whether this is used for {@link DataOutputStream} and {@link DataInputStream}.
     * 
     * @return If true methods for DB are generated.
     */
    boolean genDsFunc() default false;
}
