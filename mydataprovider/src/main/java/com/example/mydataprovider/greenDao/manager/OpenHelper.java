package com.example.mydataprovider.greenDao.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mydataprovider.greenDao.dao.DaoMaster;
import com.example.mydataprovider.greenDao.dao.TestEntityDao;
import com.github.yuweiguocn.library.greendao.MigrationHelper;

import org.greenrobot.greendao.database.Database;

public class OpenHelper extends DaoMaster.OpenHelper {

    public OpenHelper(Context context, String name) {
        super(context, name);
    }

    public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {

        //把需要管理的数据库表DAO作为最后一个参数传入到方法中
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, TestEntityDao.class);
    }
}