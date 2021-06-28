package com.ohyoung.geek.chapter35;

/**
 * 设置自己的标志位终止线程
 * @author ohYoung
 * @date 2020/12/20 13:28
 */
public class Proxy {

    // 线程终止标志位
    volatile boolean isTerminated = false;
    boolean started = false;
    // 采集线程
    Thread rptThread;
    // 启动采集功能
    synchronized void start() {
        // 不允许同时启动多个线程
        if (started) {
            return;
        }
        started = true;
        isTerminated = false;
        rptThread = new Thread(() -> {
            while (!isTerminated) {
                try {
                    // 每2s采集一次
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // 重新设置线程中断状态
                    Thread.currentThread().interrupt();
                }
            }
            started = false;
        });
        rptThread.start();
    }

    // 终止采集功能
    synchronized void stop() {
        // 设置中断标志位
        isTerminated = true;
        rptThread.interrupt();
    }

}
