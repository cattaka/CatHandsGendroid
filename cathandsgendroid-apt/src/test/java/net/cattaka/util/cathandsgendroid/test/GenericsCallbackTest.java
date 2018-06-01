package net.cattaka.util.cathandsgendroid.test;

import java.util.HashMap;
import java.util.Map;

import net.cattaka.util.cathandsgendroid.test.asyncif.GenericsCallback;
import net.cattaka.util.cathandsgendroid.test.asyncif.GenericsCallbackAsync;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import android.os.Handler;
import org.robolectric.annotation.Config;
import org.robolectric.shadow.api.Shadow;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class GenericsCallbackTest {
    static class GenericsCallbackImpl implements GenericsCallback<Integer> {
    	private Map<String, Integer> map = new HashMap<String, Integer>();

		@Override
		public Integer add(Integer a, Integer b) {
			return a + b;
		}

		@Override
		public Integer mod(Integer a, Integer b) throws ArithmeticException {
			return a / b;
		}

		@Override
		public void put(String key, Integer number) {
			map.put(key, number);
		}

		@Override
		public Integer get(String key) {
			return map.get(key);
		}
    	
    }

    private Handler mHandler;

    @Before
    public void beforeTest() {
        mHandler = Shadow.newInstanceOf(Handler.class);
    }

    @After
    public void afterTest() {
        mHandler = null;
    }

    @Test
    public void testRun() {
    	GenericsCallbackImpl orig = new GenericsCallbackImpl();
    	GenericsCallbackAsync<Integer> async = new GenericsCallbackAsync<Integer>(orig, mHandler.getLooper());
        
    	assertEquals(Integer.valueOf(5), async.add(3, 2));
    	assertEquals(Integer.valueOf(2), async.mod(6, 3));
    	async.put("abcde", 13);
    	assertEquals(Integer.valueOf(13), async.get("abcde"));
    	try {
    		async.mod(12, 0);
    		fail();
    	} catch (ArithmeticException e) {
    		// OK
    	}
    }
}
