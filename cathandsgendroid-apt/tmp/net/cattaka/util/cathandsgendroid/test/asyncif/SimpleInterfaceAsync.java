package net.cattaka.util.cathandsgendroid.test.asyncif;

import java.util.HashMap;
import java.util.Map;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Handler.Callback;

import net.cattaka.util.cathandsgendroid.exception.AsyncInterfaceException;
import net.cattaka.util.cathandsgendroid.test.asyncif.SimpleInterface;

public class SimpleInterfaceAsync implements SimpleInterface {
    private static final int WORK_SIZE = 6;
    private static final int POOL_SIZE = 10;
    private static final int EVENT_START = 1;


    private static final int EVENT_METHOD_0_run = EVENT_START + 1;
    private static final int EVENT_METHOD_1_add = EVENT_START + 2;

    private static Callback sCallback = new Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {

                case EVENT_METHOD_0_run: {
                    Object[] work = (Object[]) msg.obj;

                    SimpleInterfaceAsync me = (SimpleInterfaceAsync) work[0];
                    SimpleInterface orig = (SimpleInterface) work[1];


                    orig.run();
                    me.recycle(work);
                    return true;

                }

                case EVENT_METHOD_1_add: {
                    Object[] work = (Object[]) msg.obj;

                    SimpleInterface orig = (SimpleInterface) work[1];

                    Integer arg0 = (Integer) (work[0+2]);
                    Integer arg1 = (Integer) (work[1+2]);

                    try {

                        Object result = 
                        orig.add(arg0 ,arg1);

                        work[WORK_SIZE - 2] = result;
                    } catch (Exception e) {
                        work[WORK_SIZE - 1] = e;
                    }
                    synchronized (work) {
                        work.notify();
                    }
                    return true;

                }

            }
            return false;
        }
    };
    private static Map<Looper, Handler> sHandlerMap = new HashMap<Looper, Handler>();
    private Handler mHandler;
    private Object[][] sOwnedPool = new Object[POOL_SIZE][WORK_SIZE];
    private SimpleInterface orig;

    public SimpleInterfaceAsync(SimpleInterface orig, Looper looper) {
        super();
        this.orig = orig;
        synchronized (sHandlerMap) {
            mHandler = sHandlerMap.get(looper);
            if (mHandler == null) {
                mHandler = new Handler(looper, sCallback);
                sHandlerMap.put(looper, mHandler);
            }
        }
    }

    public SimpleInterfaceAsync(SimpleInterface orig) {
        this(orig, Looper.getMainLooper());
    }



    @Override
    public  void run() 

    {
    	if (Looper.myLooper() == mHandler.getLooper()) {

    		orig.run();
            return;

    	}
        Object[] work = obtain();
        work[0] = this;
        work[1] = orig;


        mHandler.obtainMessage(EVENT_METHOD_0_run, work).sendToTarget();

    }

    @Override
    public  int add(int arg0, int arg1) 

    {
    	if (Looper.myLooper() == mHandler.getLooper()) {

    		return orig.add(arg0, arg1);

    	}
        Object[] work = obtain();
        work[0] = this;
        work[1] = orig;

        work[0+2] = arg0;
        work[1+2] = arg1;

        synchronized (work) {
            mHandler.obtainMessage(EVENT_METHOD_1_add, work)
                    .sendToTarget();
            try {
                work.wait();
            } catch (InterruptedException e) {
                throw new AsyncInterfaceException(e);
            }
        }
        if (work[WORK_SIZE - 1] != null) {

            throw new AsyncInterfaceException((Exception) work[WORK_SIZE - 1]);

        }


        int result = (Integer) work[WORK_SIZE - 2];
        recycle(work);


        return result;


    }


    private Object[] obtain() {
        final Object[][] pool = sOwnedPool;
        synchronized (pool) {
            Object[] p;
            for (int i = 0; i < POOL_SIZE; i++) {
                p = pool[i];
                if (p != null) {
                    pool[i] = null;
                    return p;
                }
            }
        }
        return new Object[WORK_SIZE];
    }

    private void recycle(Object[] p) {
    	for (int i=0;i<p.length;i++) {
    		p[i] = null;
    	}
        final Object[][] pool = sOwnedPool;
        synchronized (pool) {
            for (int i = 0; i < POOL_SIZE; i++) {
                if (pool[i] == null) {
                    pool[i] = p;
                    return;
                }
            }
        }
    }
}