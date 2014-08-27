package net.cattaka.util.cathandsgendroid.test;

import net.cattaka.util.cathandsgendroid.test.asyncif.SimpleInterface;
import net.cattaka.util.cathandsgendroid.test.asyncif.async.SimpleInterfaceAsync;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowHandler;
import org.robolectric.shadows.ShadowHandlerThread;
import org.robolectric.shadows.ShadowLooper;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class SimpleInterfaceTest {
    static class SimpleInterfaceImpl implements SimpleInterface {
        String runValue;
        @Override
        public void run() {
            runValue = "run";
        }
        @Override
        public int add(int a, int b) {
            return a+b;
        }
    }

    private Handler mHandler;

    @Before
    public void beforeTest() {
        mHandler = Robolectric.newInstanceOf(Handler.class);
    }

    @After
    public void afterTest() {
        mHandler = null;
    }

    @Test
    public void testRun() {
        ShadowLooper shadow = Robolectric.shadowOf(mHandler.getLooper());
        
        SimpleInterfaceImpl orig = new SimpleInterfaceImpl();
        SimpleInterfaceAsync async = new SimpleInterfaceAsync(orig, mHandler.getLooper());
        
        async.run();
        //assertEquals("run", orig.runValue);
        
        int v = async.add(3, 4);
        assertEquals(7, v);
    }
}
