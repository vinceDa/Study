package com.ohyoung.structure.queue;

/**
 * 基于数组实现循环队列
 *
 * @author ohYoung
 * @date 2020/12/1 10:11
 */
public class ArrayCycleQueue {

    private final String[] items;

    private int head = 0;

    private int tail = 0;

    private final int n;

    public ArrayCycleQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     *  入队
     *  当队列满时，tail 指向的位置实际上是没有存储数据的。所以，循环队列会浪费一个数组的存储空间
     */
    public boolean enqueue(String data) {
        // 队列满了
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = data;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     *  出队
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String item = items[head];
        head = (head + 1) % n;
        return item;
    }

    public void print() {
        int start = head;
        int end = tail;
        if (start > end) {
            start = tail;
            end = head;
        }
        for (int i = start; i < end; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
