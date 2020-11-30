package com.ohyoung.structure.queue;

import org.junit.Test;

/**
 * @author ohYoung
 * @date 2020/11/30 11:43
 */
public class ArrayQueueTest {

    @Test
    public void addData() {
        ArrayQueue queue = new ArrayQueue(10);
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
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("o");
        System.out.println(queue.dequeue());

    }

}
