package com.ohyoung.example;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Java两个线程交替打印奇偶数
 * 思路: 利用Object.wait()和Object.notify()方法进行线程间的通信。
 * @author ohYoung
 * @date 2020/12/25 10:16
 */
public class PrintNumByTwoThread implements Runnable {

    private static int i = 1;

    private byte[] s1;

    public PrintNumByTwoThread(byte[] s1) {
        this.s1 = s1;
    }

    @Override
    public void run() {
        HashSet
        while (true) {
            synchronized (s1) {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + ": " + i++);
                s1.notify();
                if (i > 99) {
                    s1.notify();
                    break;
                }
                try {
                    s1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        byte[] s1 = new byte[1];
        PrintNumByTwoThread t1 = new PrintNumByTwoThread(s1);
        PrintNumByTwoThread t2 = new PrintNumByTwoThread(s1);
        new Thread(t1, "线程1").start();
        new Thread(t2, "线程2").start();
    }
}
