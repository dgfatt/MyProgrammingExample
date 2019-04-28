package com.example.myprogrammingexample.common.base;

import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.example.mycommon.base.BaseApplication;
import com.example.myprogrammingexample.common.config.AppConfigService;

public class MainApplication extends BaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initUtils();
        initAppConfigService();
    }

    private void initAppConfigService() {
        AppConfigService.getInstance().initService();
    }

    /**
     * 初始化工具类
     */
    private void initUtils() {
        Utils.init(this);
    }

}
