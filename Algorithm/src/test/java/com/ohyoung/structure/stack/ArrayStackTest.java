package com.ohyoung.structure.stack;

import org.junit.Test;

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

    /**
     *  使用栈实现计算器的功能
     */
    @Test
    public void cal() {
        Object[] cal = new Object[]{1, "+", 2, "*", 3, "/", 2, "+", 2 , "*", 3};
        ArrayStack numStack = new ArrayStack(6);
        ArrayStack calStack = new ArrayStack(5);
        for (Object o : cal) {
            assert o != null;
            if (o instanceof String) {
                Object pop = calStack.pop();
                // 与栈顶元素比较, 如果和栈顶元素优先级相同或者优先级更高则压入栈
                if (havePriority(o, pop)) {
                    calStack.push(pop);
                    // 反之取出运算符栈顶元素, 然后从操作数栈取出顶端两个元素进行运算
                } else {
                    if (pop != null) {
                        Integer i2 = (Integer) numStack.pop();
                        Integer i1 = (Integer) numStack.pop();
                        numStack.push(cal(i1, i2, pop.toString()));
                    }
                }
                calStack.push(o);
            } else {
                numStack.push(o);
            }
        }
        Object pop = calStack.pop();
        while (pop != null) {
            Integer i2 = (Integer) numStack.pop();
            Integer i1 = (Integer) numStack.pop();
            numStack.push(cal(i1, i2, pop.toString()));
            pop = calStack.pop();
        }
        System.out.println(numStack.pop());
    }

    private int cal(Integer i1, Integer i2, String operator) {
        switch (operator) {
            case "+":
                return i1 + i2;
            case "-":
                return i1 - i2;
            case "*":
                return i1 * i2;
            case "/":
                return i1 / i2;
        }
        return -1;
    }

    private boolean havePriority(Object cal1, Object cal2) {
        if (cal1 == null || cal2 == null) {
            return false;
        }
        if ("+".equals(cal1) || "-".equals(cal1)) {
            return false;
        } else {
            return !"*".equals(cal2) && !"/".equals(cal2);
        }
    }
}
