package com.example.mydataprovider.greenDao.dao;

import org.greenrobot.greendao.test.AbstractDaoTestLongPk;

import com.example.mydataprovider.entity.TestEntity;
import com.example.mydataprovider.greenDao.dao.TestEntityDao;

public class TestEntityTest extends AbstractDaoTestLongPk<TestEntityDao, TestEntity> {

    public TestEntityTest() {
        super(TestEntityDao.class);
    }

    @Override
    protected TestEntity createEntity(Long key) {
        TestEntity entity = new TestEntity();
        entity.setId(key);
        return entity;
    }

}
