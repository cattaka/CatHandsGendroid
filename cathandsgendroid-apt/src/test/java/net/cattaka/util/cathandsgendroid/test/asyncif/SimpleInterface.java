package net.cattaka.util.cathandsgendroid.test.asyncif;


import java.util.List;

import net.cattaka.util.cathandsgendroid.annotation.AsyncInterface;

@AsyncInterface
public interface SimpleInterface {
    public void run();
    public int add(int a, int b);
    public List<Integer> runLists(List<Integer> args);
}
