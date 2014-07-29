
package net.cattaka.util.cathandsgendroid.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface DataModel {
    enum NamingConventions {
        LOWER_CAMEL_CASE, // lowerCamelCase
        UPPER_CAMEL_CASE, // UpperCamelCase
        LOWER_COMPOSITE, // lower_composite
        UPPER_COMPOSITE, // UPPER_COMPOSITE
    }

    NamingConventions tableNamingConventions() default NamingConventions.LOWER_CAMEL_CASE;

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
