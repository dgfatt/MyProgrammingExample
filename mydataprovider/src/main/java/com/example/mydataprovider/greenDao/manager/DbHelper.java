package com.example.mydataprovider.greenDao.manager;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.mycommon.config.Constants;
import com.example.mydataprovider.greenDao.dao.DaoMaster;
import com.example.mydataprovider.greenDao.dao.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

public class DbHelper {

    private static final String TAG = DbHelper.class.getSimpleName();

    @SuppressLint("StaticFieldLeak")
    private static DbHelper daoManager;  //多线程 使用单例模式
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private Context context;

    private DbHelper(Context context) {
        this.context = context;
    }

    /**
     * 使用单例模式 保证数据库的安全
     */
    public static DbHelper getInstance(Context context) {
        if (daoManager == null) {
            synchronized (DbHelper.class) {
                if (daoManager == null) {
                    daoManager = new DbHelper(context);
                }
            }
        }
        return daoManager;
    }

    /**
     * 判断是否存在数据库，如果没有则创建数据库
     *
     * @return DaoMaster
     */
    public DaoMaster getDaoMaster(String userId) {
        if (daoMaster == null) {
            DatabaseContext databaseContext = new DatabaseContext(context,userId);
            helper = new DaoMaster.DevOpenHelper(databaseContext, Constants.DB_NAME, null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * 完成对数据库的添加 修改 查询 的操作 仅仅是一个接口
     *
     * @return DaoSession
     */
    synchronized DaoSession getDaoSession(String userId) {
        if (null == daoSession) {
            daoSession = getDaoMaster(userId).newSession();
        }
        return daoSession;
    }

    /**
     * 是否打印 数据库的日志信息 默认不开启
     */
    public void setDebug(Boolean isDebug) {
        if (isDebug) {
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
        } else {
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
        }

    }

    /**
     * 关闭 help
     */
    private void closeHelper() {
        if (helper != null) {
            helper.close();
            helper = null;
        }
    }

    /**
     * 关闭 会话
     */
    private void closeSession() {
        if (daoSession != null) {
            daoSession.clear();
            daoSession = null;
        }
    }

    /**
     * 关闭所有的操作 数据库用完的时候必须关闭 节省资源
     */
    public void closeConnection() {
        closeHelper();
        closeSession();
    }

}
