package com.ohyoung.structure.queue;

import org.junit.jupiter.api.Test;

/**
 * @author ohYoung
 * @date 2020/11/30 11:43
 */
public class ArrayCycleQueueTest {

    @Test
    public void enqueue() {
        ArrayCycleQueue queue = new ArrayCycleQueue(10);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        queue.enqueue("g");
        queue.enqueue("h");
        queue.enqueue("i");
        queue.enqueue("j");
        queue.enqueue("k");
        queue.enqueue("l");
        queue.enqueue("m");
        queue.print();

    }

    @Test
    public void dequeue() {
        ArrayCycleQueue queue = new ArrayCycleQueue(10);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        queue.enqueue("g");
        queue.enqueue("h");
        queue.enqueue("i");
        queue.enqueue("j");
        queue.enqueue("k");
        queue.enqueue("l");
        queue.enqueue("m");
        queue.enqueue("n");
        queue.enqueue("o");
        queue.print();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.print();

    }

}
