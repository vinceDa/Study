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
     */
    public boolean enqueue(String data) {
        if (tail == n) {
            // 队列满了
            if (head == 0) {
                return false;
            } else {
                // 将队列剪切至头部
                for (int i = head; i < tail; i++) {
                    items[i - head] = items[i];
                }
                tail = tail - head;
                head = 0;
            }
        }
        items[tail] = data;
        ++tail;
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
        ++head;
        return item;
    }
}
