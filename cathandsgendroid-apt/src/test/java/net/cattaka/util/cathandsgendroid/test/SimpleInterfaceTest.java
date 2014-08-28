package net.cattaka.util.cathandsgendroid.test;

import net.cattaka.util.cathandsgendroid.test.asyncif.SimpleInterface;
import net.cattaka.util.cathandsgendroid.test.asyncif.SimpleInterfaceAsync;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowLooper;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import static org.junit.Assert.*;

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
	}

	private Handler mHandler;
	private HandlerThread mHandlerThread;
	private ShadowLooper shadowLooper;

	@Before
	public void beforeTest() {
		mHandlerThread = Robolectric.newInstanceOf(HandlerThread.class);
		mHandlerThread.start();
		Looper looper = mHandlerThread.getLooper();
		shadowLooper = Robolectric.shadowOf(looper);
		mHandler = Robolectric.newInstance(Handler.class,
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
					if (shadowLooper.getScheduler().enqueuedTaskCount() > 0) {
						break;
					}
					Thread.sleep(10);
				}
			}
			assertNull(orig.runResult);
			shadowLooper.getScheduler().runTasks(1);
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
					if (shadowLooper.getScheduler().enqueuedTaskCount() > 0) {
						break;
					}
					Thread.sleep(10);
				}
			}
			assertNull(orig.addResult);
			shadowLooper.getScheduler().runTasks(1);
			assertEquals(Integer.valueOf(7), orig.addResult);
		}
	}
}
