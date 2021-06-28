package com.ohyoung.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ohYoung
 * @date 2020/12/31 11:26
 */
public class ThreadPoolExercise {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.shutdown();

    }

}
