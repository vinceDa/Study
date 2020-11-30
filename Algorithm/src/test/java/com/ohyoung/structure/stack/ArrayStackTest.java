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
     *  ʹ��ջʵ�ּ������Ĺ���
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
                // ��ջ��Ԫ�رȽ�, �����ջ��Ԫ�����ȼ���ͬ�������ȼ�������ѹ��ջ
                if (havePriority(o, pop)) {
                    calStack.push(pop);
                    // ��֮ȡ�������ջ��Ԫ��, Ȼ��Ӳ�����ջȡ����������Ԫ�ؽ�������
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
