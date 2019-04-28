package com.example.myprogrammingexample.common.config;

import android.os.Handler;
import android.os.HandlerThread;

public class AppConfigService {

    private static final AppConfigService INSTANCE = new AppConfigService();
    private Handler mIoHandler;

    public static AppConfigService getInstance() {
        return INSTANCE;
    }

    public static AppConfigService getAppDataService() {
        return new AppConfigService();
    }

    public void initService() {
        backGroundInit();
    }

    private void backGroundInit() {
        HandlerThread ioThread = new HandlerThread("IoThread");
        ioThread.start();
        mIoHandler = new Handler(ioThread.getLooper());
        mIoHandler.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
