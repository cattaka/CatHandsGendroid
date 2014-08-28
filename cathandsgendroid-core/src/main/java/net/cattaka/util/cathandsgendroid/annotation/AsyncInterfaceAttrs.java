
package net.cattaka.util.cathandsgendroid.annotation;

public @interface AsyncInterfaceAttrs {
    boolean forceSync() default false;

    boolean ignore() default false;
}
