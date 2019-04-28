package com.example.mydataprovider.greenDao.helper;

import com.example.mydataprovider.entity.TestEntity;
import com.example.mydataprovider.greenDao.manager.BaseBeanHelper;

import org.greenrobot.greendao.AbstractDao;

public class TestEntityHelper extends BaseBeanHelper<TestEntity,Long> {

    public TestEntityHelper(AbstractDao dao) {
        super(dao);
    }
}
