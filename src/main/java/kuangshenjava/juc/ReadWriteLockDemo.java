package kuangshenjava.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
         MyCacheLock myCache = new MyCacheLock();
        for (int i = 0; i < 5; i++) {
            final int temp = i+1;
            new Thread(()->{
                myCache.put(temp+"",temp);
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i+1;
            new Thread(()->{
                myCache.get("temp"+temp);
            }).start();
        }
    }
}

class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写入OK");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取OK");
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + " 写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + " 写入OK");
    }

    public void get(String key) {
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + " 读取OK");
    }
}

