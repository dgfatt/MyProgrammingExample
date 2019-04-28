package com.example.mydataprovider.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TestEntity {

    @Id(autoincrement = true)
    private Long id;
    private String msg;
    private String content;
    @Generated(hash = 720663829)
    public TestEntity(Long id, String msg, String content) {
        this.id = id;
        this.msg = msg;
        this.content = content;
    }
    @Generated(hash = 1020448049)
    public TestEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMsg() {
        return this.msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}