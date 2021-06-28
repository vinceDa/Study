package com.ohyoung.geek.chapter17;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 用ReadWriteLock快速实现一个通用的缓存工具类
 * @author ohYoung
 * @date 2020/12/19 12:45
 */
public class Cache<K, V> {

    final Map<K, V> map = new HashMap<>();

    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    // 读锁
    final Lock read = readWriteLock.readLock();
    // 写锁
    final Lock write = readWriteLock.writeLock();

    public V get(K k) {
        read.lock();
        try {
            return map.get(k);
        } finally {
            read.unlock();
        }
    }

    public void put(K k, V v) {
        write.lock();
        try {
            map.put(k, v);
        } finally {
            write.unlock();
        }
    }

}



