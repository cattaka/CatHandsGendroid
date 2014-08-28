
package net.cattaka.util.cathandsgendroid.annotation;

public @interface AsyncInterface {
    int poolSize() default 10;

    String prefix() default "";

    String suffix() default "Async";
}
