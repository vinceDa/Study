package com.ohyoung.leetcode.stack;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式
 * @author ohYoung
 * @date 2021/7/10 16:01
 */
public class EvalRPN150 {

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));

        tokens = new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));

        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    /**
     * 定义一个栈，存放数字
     * 遇到运算符时，从数字栈取出两个数字进行运算再将结果压入数字栈，直到结束
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> valueStack = new Stack<>();
        for (String token : tokens) {
            // 如果是数字则压入数字栈
            if (!isOperator(token)) {
                valueStack.push(Integer.valueOf(token));
            } else {
                valueStack.push(cal(valueStack.pop(), valueStack.pop(), token));
            }
        }
        return valueStack.pop();
    }

    private static int cal(int i1, int i2, String operator) {
        int res = 0;
        switch (operator) {
            case "+":
                res =  i2 + i1;
                break;
            case "-":
                res =  i2 - i1;
                break;
            case "*":
                res =  i2 * i1;
                break;
            case "/":
                res =  i2 / i1;
                break;
            default:
                break;
        }
        return res;
    }

    private static boolean isOperator(String token) {
        return "*".equals(token) || "/".equals(token) || "+".equals(token) || "-".equals(token);
    }

}
