package net.cattaka.util.cathandsgendroid.test;

import java.util.Arrays;
import java.util.List;

import net.cattaka.util.cathandsgendroid.test.asyncif.SimpleInterface;
import net.cattaka.util.cathandsgendroid.test.asyncif.SimpleInterfaceAsync;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadow.api.Shadow;
import org.robolectric.shadows.ShadowLooper;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import static org.junit.Assert.*;

@Config(sdk = 8)
@RunWith(RobolectricTestRunner.class)
public class SimpleInterfaceTest {
	static class SimpleInterfaceImpl implements SimpleInterface {
		String runResult;
		Integer addResult;

		@Override
		public void run() {
			runResult = "run";
		}

		@Override
		public int add(int a, int b) {
			addResult = a + b;
			return addResult;
		}

        @Override
        public List<Integer> runLists(List<Integer> args) {
            return Arrays.asList(1,2,3);
        }
	}

	private Handler mHandler;
	private HandlerThread mHandlerThread;
	private ShadowLooper shadowLooper;

	@Before
	public void beforeTest() {
		mHandlerThread = Shadow.newInstanceOf(HandlerThread.class);
		mHandlerThread.start();
		Looper looper = mHandlerThread.getLooper();
		shadowLooper = Shadows.shadowOf(looper);
		mHandler = Shadow.newInstance(Handler.class,
				new Class<?>[] { Looper.class },
				new Object[] { mHandlerThread.getLooper() });
	}

	@After
	public void afterTest() {
		mHandlerThread.quit();
		mHandlerThread = null;
		mHandler = null;
	}

    @Test
    public void testSameThread() {
        SimpleInterfaceImpl orig = new SimpleInterfaceImpl();
        SimpleInterfaceAsync async = new SimpleInterfaceAsync(orig);
        
        async.run();
        assertEquals("run", orig.runResult);
        
        int v = async.add(3, 4);
        assertEquals(7, v);
		assertEquals(Integer.valueOf(7), orig.addResult);
    }

	@Test
	public void testFromOtherThread() throws InterruptedException {
		final SimpleInterfaceImpl orig = new SimpleInterfaceImpl();
		final SimpleInterfaceAsync async = new SimpleInterfaceAsync(orig,
				mHandler.getLooper());

		{
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					async.run();
				}
			};
			new Thread(runnable).start();

			{	// Wait for scheduler
				for (int i=0;i<100;i++) {
					if (shadowLooper.getScheduler().size() > 0) {
						break;
					}
					Thread.sleep(10);
				}
			}
			assertNull(orig.runResult);
			shadowLooper.getScheduler().runOneTask();
			assertEquals("run", orig.runResult);
		}
		{
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					async.add(3, 4);
				}
			};
			new Thread(runnable).start();

			{	// Wait for scheduler
				for (int i=0;i<100;i++) {
					if (shadowLooper.getScheduler().size() > 0) {
						break;
					}
					Thread.sleep(10);
				}
			}
			assertNull(orig.addResult);
			shadowLooper.getScheduler().runOneTask();
			assertEquals(Integer.valueOf(7), orig.addResult);
		}
	}
}
