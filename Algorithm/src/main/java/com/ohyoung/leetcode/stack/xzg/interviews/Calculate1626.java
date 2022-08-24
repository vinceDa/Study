package com.ohyoung.leetcode.stack.xzg.interviews;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
 *
 * 示例1:
 * 输入: "3+2*2"
 * 输出: 7
 *
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 *
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 链接：<a href="https://leetcode.cn/problems/calculator-lcci">...</a>
 *
 * @author ouyb01
 * @date 2022/6/2 17:40
 */
public class Calculate1626 {

    public static void main(String[] args) {
        Calculate1626 example = new Calculate1626();
        System.out.println("3+2*2 = " + example.calculate("3+2*2"));
        System.out.println("3/2 = " + example.calculate("3/2"));
        System.out.println("3+5 / 2 = " + example.calculate("3+5 / 2"));
        System.out.println("42 = " + example.calculate("42"));

    }

    public int calculate(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        char preOperator = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                switch (preOperator) {
                    case '+':
                        numStack.push(num);
                        break;
                    case '-':
                        numStack.push(-num);
                        break;
                    case '*':
                        numStack.push(numStack.pop() * num);
                        break;
                    default:
                        numStack.push(numStack.pop() / num);
                }
                preOperator = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!numStack.isEmpty()) {
            res += numStack.pop();
        }
        return res;
    }

}
