package com.ohyoung.structure.queue;

import org.junit.Test;

/**
 *  ������в�����
 *
 * @author ohYoung
 * @date 2020/12/3 17:37
 */
public class LinkedListQueueTest {

    @Test
    public void enqueue() {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        queue.print();
    }

    @Test
    public void dequeue() {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }
}