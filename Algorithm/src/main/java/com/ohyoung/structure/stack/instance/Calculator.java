package com.ohyoung.structure.stack.instance;

import com.ohyoung.structure.stack.ArrayStack;

/**
 *  用栈的方式实现一个简易计算器
 * @author ohYoung
 * @date 2020/12/3 16:41
 */
public class Calculator {

    public static void cal(Object[] cal) {
        int numberCount = 0;
        int symbolCount = 0;
        for (Object o : cal) {
            if (o instanceof String) {
                ++symbolCount;
            } else {
                ++numberCount;
            }
        }
        ArrayStack numStack = new ArrayStack(numberCount);
        ArrayStack symbolStack = new ArrayStack(symbolCount);

        for (Object o : cal) {
            assert o != null;
            if (o instanceof String) {
                Object pop = symbolStack.pop();
                // 与栈顶元素比较, 如果和栈顶元素优先级相同或者优先级更高则压入栈
                if (havePriority(o, pop)) {
                    symbolStack.push(pop);
                    // 反之取出运算符栈顶元素, 然后从操作数栈取出顶端两个元素进行运算
                } else {
                    if (pop != null) {
                        Integer i2 = (Integer) numStack.pop();
                        Integer i1 = (Integer) numStack.pop();
                        numStack.push(cal(i1, i2, pop.toString()));
                    }
                }
                symbolStack.push(o);
            } else {
                numStack.push(o);
            }
        }
        Object pop = symbolStack.pop();
        while (pop != null) {
            Integer i2 = (Integer) numStack.pop();
            Integer i1 = (Integer) numStack.pop();
            numStack.push(cal(i1, i2, pop.toString()));
            pop = symbolStack.pop();
        }
        System.out.println(numStack.pop());
    }

    private static int cal(Integer i1, Integer i2, String operator) {
        switch (operator) {
            case "+":
                return i1 + i2;
            case "-":
                return i1 - i2;
            case "*":
                return i1 * i2;
            case "/":
                return i1 / i2;
            default:
                return -1;
        }
    }

    private static boolean havePriority(Object cal1, Object cal2) {
        if (cal1 == null || cal2 == null) {
            return false;
        }
        if ("+".equals(cal1) || "-".equals(cal1)) {
            return false;
        } else {
            return !"*".equals(cal2) && !"/".equals(cal2);
        }
    }

    public static void main(String[] args) {
        Object[] cal = new Object[]{1, "+", 2, "*", 3, "/", 2, "+", 2 , "*", 3};
        cal(cal);
    }
}
