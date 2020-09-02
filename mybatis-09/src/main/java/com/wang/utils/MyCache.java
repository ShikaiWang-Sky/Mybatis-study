package com.wang.utils;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

//自己写缓存,只需要实现Cache接口!
public class MyCache implements Cache {
    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object o, Object o1) {

    }

    @Override
    public Object getObject(Object o) {
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
