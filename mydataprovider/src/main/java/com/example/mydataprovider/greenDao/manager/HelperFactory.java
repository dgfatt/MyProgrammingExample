package com.example.mydataprovider.greenDao.manager;

import com.example.mycommon.base.BaseApplication;
import com.example.mydataprovider.greenDao.helper.TestEntityHelper;

public class HelperFactory {
    /**
     * 每一个BeanHelper都管理着数据库中的一个表，将这些管理者在ManagerFactory中进行统一管理
     */
    private TestEntityHelper testEntityHelper;

    private static HelperFactory mInstance = null;

    /**
     * 获取DaoFactory的实例
     *
     * @return
     */
    public static HelperFactory getInstance() {
        if (mInstance == null) {
            synchronized (HelperFactory.class) {
                if (mInstance == null) {
                    mInstance = new HelperFactory();
                }
            }
        }
        return mInstance;
    }

    public synchronized TestEntityHelper getTestEntityHelper(String userId) {
        if (testEntityHelper == null) {
            testEntityHelper = new TestEntityHelper(DbHelper.getInstance(BaseApplication.getInstance()).getDaoSession(userId).getTestEntityDao());
        }
        return testEntityHelper;
    }
}
