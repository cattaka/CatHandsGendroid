
package net.cattaka.util.cathandsgendroid;

public @interface GenDbHandler {
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

    boolean autoinclement() default true;

    boolean genDbFunc() default true;

    boolean genParcelFunc() default false;

    boolean genContentResolverFunc() default false;

}
