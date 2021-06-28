package com.ohyoung.geek.chapter22;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 简化的线程池，仅⽤来说明⼯作原理
 * @author ohYoung
 * @date 2020/12/19 14:29
 */
public class MyThreadPool {
    // 利用阻塞队列实现生产者-消费者模式
    BlockingQueue<Runnable> workQueue;
    // 保存内部工作线程
    List<WorkerThread> threads = new ArrayList<>();
    // 构造方法
    public MyThreadPool(int size, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        for (int i = 0; i < size; i++) {
            WorkerThread workerThread = new WorkerThread();
            workerThread.start();
            threads.add(workerThread);
        }
    }

    // 提交任务
    void execute(Runnable command) throws InterruptedException {
        workQueue.put(command);
    }

    // 工作线程负责消费任务并执行任务
    class WorkerThread extends Thread {

        public void run() {
            // 循环取任务并执行
            while (true) {
                Runnable task = null;
                try {
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.run();
            }
        }

    }

    /**
     *  使用示例
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建有界阻塞队列
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(2);
        // 创建线程池
        MyThreadPool pool = new MyThreadPool(2, workQueue);
        // 提交任务
        pool.execute(() -> {
            System.out.println("hello");
        });
    }

}


