package net.cattaka.util.cathandsgendroid.test.asyncif;

import net.cattaka.util.cathandsgendroid.annotation.AsyncInterface;

@AsyncInterface
public interface GenericsCallback<T extends Number> {
    public T add(T a, T b);

    public T mod(T a, T b) throws ArithmeticException;

    public void put(String key, T number);

    public T get(String key);
}