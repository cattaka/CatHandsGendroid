package net.cattaka.util.cathandsgendroid.test.asyncif;

import java.util.HashMap;
import java.util.Map;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Handler.Callback;

import net.cattaka.util.cathandsgendroid.exception.AsyncInterfaceException;
import net.cattaka.util.cathandsgendroid.test.asyncif.IGenericsCallback;

public class IGenericsCallbackAsync<T extends java.lang.Number> implements IGenericsCallback<T> {
    private static final int WORK_SIZE = 6;
    private static final int POOL_SIZE = 10;
    private static final int EVENT_START = 1;


    private static final int EVENT_METHOD_0_add = EVENT_START + 1;
    private static final int EVENT_METHOD_1_mod = EVENT_START + 2;
    private static final int EVENT_METHOD_2_put = EVENT_START + 3;
    private static final int EVENT_METHOD_3_get = EVENT_START + 4;

    private static Callback sCallback = new Callback() {
        @SuppressWarnings({"rawtypes","unchecked"})
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {

                case EVENT_METHOD_0_add: {
                    Object[] work = (Object[]) msg.obj;

                    IGenericsCallback orig = (IGenericsCallback) work[1];

                    java.lang.Number arg0 = (java.lang.Number) (work[0+2]);
                    java.lang.Number arg1 = (java.lang.Number) (work[1+2]);

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

                case EVENT_METHOD_1_mod: {
                    Object[] work = (Object[]) msg.obj;

                    IGenericsCallback orig = (IGenericsCallback) work[1];

                    java.lang.Number arg0 = (java.lang.Number) (work[0+2]);
                    java.lang.Number arg1 = (java.lang.Number) (work[1+2]);

                    try {

                        Object result = 
                        orig.mod(arg0 ,arg1);

                        work[WORK_SIZE - 2] = result;
                    } catch (Exception e) {
                        work[WORK_SIZE - 1] = e;
                    }
                    synchronized (work) {
                        work.notify();
                    }
                    return true;

                }

                case EVENT_METHOD_2_put: {
                    Object[] work = (Object[]) msg.obj;

                    IGenericsCallbackAsync me = (IGenericsCallbackAsync) work[0];
                    IGenericsCallback orig = (IGenericsCallback) work[1];

                    java.lang.String arg0 = (java.lang.String) (work[0+2]);
                    java.lang.Number arg1 = (java.lang.Number) (work[1+2]);

                    orig.put(arg0 ,arg1);
                    me.recycle(work);
                    return true;

                }

                case EVENT_METHOD_3_get: {
                    Object[] work = (Object[]) msg.obj;

                    IGenericsCallback orig = (IGenericsCallback) work[1];

                    java.lang.String arg0 = (java.lang.String) (work[0+2]);

                    try {

                        Object result = 
                        orig.get(arg0);

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
    private IGenericsCallback<T> orig;

    public IGenericsCallbackAsync(IGenericsCallback<T> orig, Looper looper) {
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

    public IGenericsCallbackAsync(IGenericsCallback<T> orig) {
        this(orig, Looper.getMainLooper());
    }



    @Override
    public  T add(T arg0, T arg1) 

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
            mHandler.obtainMessage(EVENT_METHOD_0_add, work)
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


        @SuppressWarnings("unchecked")
        T result = (T) work[WORK_SIZE - 2];
        recycle(work);


        return result;


    }

    @Override
    public  T mod(T arg0, T arg1) 

            throws

        java.lang.ArithmeticException

    {
    	if (Looper.myLooper() == mHandler.getLooper()) {

    		return orig.mod(arg0, arg1);

    	}
        Object[] work = obtain();
        work[0] = this;
        work[1] = orig;

        work[0+2] = arg0;
        work[1+2] = arg1;

        synchronized (work) {
            mHandler.obtainMessage(EVENT_METHOD_1_mod, work)
                    .sendToTarget();
            try {
                work.wait();
            } catch (InterruptedException e) {
                throw new AsyncInterfaceException(e);
            }
        }
        if (work[WORK_SIZE - 1] != null) {


            
            if (work[WORK_SIZE - 1] instanceof java.lang.ArithmeticException) {
                throw (java.lang.ArithmeticException) work[WORK_SIZE - 1];

            } else {
                throw new AsyncInterfaceException((Exception) work[WORK_SIZE - 1]);
            }

        }


        @SuppressWarnings("unchecked")
        T result = (T) work[WORK_SIZE - 2];
        recycle(work);


        return result;


    }

    @Override
    public  void put(java.lang.String arg0, T arg1) 

    {
    	if (Looper.myLooper() == mHandler.getLooper()) {

    		orig.put(arg0, arg1);
            return;

    	}
        Object[] work = obtain();
        work[0] = this;
        work[1] = orig;

        work[0+2] = arg0;
        work[1+2] = arg1;

        mHandler.obtainMessage(EVENT_METHOD_2_put, work).sendToTarget();

    }

    @Override
    public  T get(java.lang.String arg0) 

    {
    	if (Looper.myLooper() == mHandler.getLooper()) {

    		return orig.get(arg0);

    	}
        Object[] work = obtain();
        work[0] = this;
        work[1] = orig;

        work[0+2] = arg0;

        synchronized (work) {
            mHandler.obtainMessage(EVENT_METHOD_3_get, work)
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


        @SuppressWarnings("unchecked")
        T result = (T) work[WORK_SIZE - 2];
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