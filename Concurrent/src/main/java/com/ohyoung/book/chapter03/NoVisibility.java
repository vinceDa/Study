package com.ohyoung.book.chapter03;


import java.util.concurrent.locks.Lock;

/**
 * @author ohYoung
 * @date 2020/12/25 11:09
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;


    private static class ReadThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReadThread().start();
        number = 42;
        ready = true;
    }

}
