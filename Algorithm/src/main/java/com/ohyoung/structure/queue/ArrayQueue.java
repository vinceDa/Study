package com.ohyoung.structure.queue;

/**
 * 基于数组实现队列
 *
 * @author ohYoung
 * @date 2020/11/30 11:24
 */
public class ArrayQueue {

    private final String[] items;

    private int head = 0;

    private int tail = 0;

    private final int n;

    public ArrayQueue(int capacity) {
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
                // 队列头部有空余部分, 将队列剪切至头部然后继续从尾部添加数据
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

    public void print() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
