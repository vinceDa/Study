package com.ohyoung.geek.chapter03;

/**
 * 锁和受保护资源的关系
 * @author ohYoung
 * @date 2020/12/17 10:59
 */
public class SafeCalc {

    long value = 0L;
    long get() {
        synchronized (new Object()) {
            return value;
        }
    }
    void addOne() {
        synchronized (new Object()) {
            value += 1;
        }
    }

    public static void main(String[] args) {
        SafeCalc safeCalc = new SafeCalc();
        while (true) {
            new Thread(safeCalc::addOne).start();
            new Thread(safeCalc::get).start();
            System.out.println(safeCalc.value);
        }
    }

}
