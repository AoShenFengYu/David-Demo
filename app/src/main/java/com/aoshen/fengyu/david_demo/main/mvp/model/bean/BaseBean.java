package com.aoshen.fengyu.david_demo.main.mvp.model.bean;

/**
 * Created by kika-david on 2018/3/16.
 */

public class BaseBean {

    private final long createdTimeMillis;

    public BaseBean() {
        this.createdTimeMillis = System.currentTimeMillis();
    }

    public long getCreatedTimeMillis() {
        return createdTimeMillis;
    }
}
