package com.eebrahimjoy.roomdbtesting.background;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors
{
    private final Executor diskIO;
    private final Executor networkIO;
    private final Executor mainThread;

    private static AppExecutors sInstance;

    private static final Object LOCK = new Object();

    public AppExecutors()
    {
        diskIO     = Executors.newSingleThreadExecutor();
        networkIO  = Executors.newFixedThreadPool(3);
        mainThread = new MainThreadExecutor();
    }

    public static AppExecutors getInstance()
    {
        if (sInstance == null)
        {
            synchronized (LOCK)
            {
                sInstance = new AppExecutors();
            }
        }

        return sInstance;
    }

    private static class MainThreadExecutor implements Executor
    {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command)
        {
            mainThreadHandler.post(command);
        }
    }

    public Executor diskIO()
    {
        return diskIO;
    }

    public Executor mainThread()
    {
        return mainThread;
    }

    public Executor networkIO()
    {
        return networkIO;
    }
}
