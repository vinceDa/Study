package com.ohyoung.structure.stack;

import org.junit.jupiter.api.Test;

/**
 * @author ohYoung
 * @date 2020/11/30 9:31
 */
public class ArrayStackTest {

    @Test
    public void push() {
        ArrayStack stack = new ArrayStack(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.print());
    }

    @Test
    public void pop() {
        ArrayStack stack = new ArrayStack(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.print());
    }

}
