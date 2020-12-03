package com.ohyoung.structure.stack;

import org.junit.Test;

/**
 * @author ohYoung
 * @date 2020/12/3 16:52
 */
public class LinkedListStackTest {

    @Test
    public void push() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.print();
    }

    @Test
    public void pop() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        System.out.println(stack.pop());
        stack.print();
    }

}
