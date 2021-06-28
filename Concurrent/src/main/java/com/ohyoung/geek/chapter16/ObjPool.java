package com.ohyoung.geek.chapter16;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 实现一个限流器解决线程池的限流问题
 * @author ohYoung
 * @date 2020/12/19 12:32
 */
public class ObjPool<T, R> {

    final List<T> pool;
    // 用信号量实现一个限流器
    final Semaphore semaphore;
    // 构造函数
    public ObjPool(int size, T t) {
        pool = new Vector<T>(){};
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        semaphore = new Semaphore(size);
    }

    // 利用线程池对象调用func
    R exec(Function<T, R> function) throws InterruptedException {
        T t = null;
        semaphore.acquire();
        try {
            t = pool.remove(0);
            return function.apply(t);
        } finally {
            pool.add(t);
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ObjPool<Long, String> pool = new ObjPool<Long, String>(10, 2L);
        // 通过对象池获取t之后执行
        pool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }
}
