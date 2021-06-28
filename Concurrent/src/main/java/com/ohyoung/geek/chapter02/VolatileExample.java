package com.ohyoung.geek.chapter02;

/**
 * 变量x可能被CPU缓存而导致可见性问题。这个问题在1.5版本已经被圆满解决了
 * @author ohYoung
 * @date 2020/12/17 10:24
 */
public class VolatileExample {

    int x = 0;
    volatile boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            // 这里 x 会是多少呢？
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();
        Thread t1 = new Thread(volatileExample::writer);
        Thread t2 = new Thread(volatileExample::reader);
        t1.start();
        t2.start();
    }

}
