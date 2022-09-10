package com.ohyoung.leetcode.recursive.interview;

/**
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * 示例1:
 *  输入：A = 1, B = 10
 *  输出：10
 *
 * 示例2:
 *  输入：A = 3, B = 4
 *  输出：12
 *
 * 提示:
 * 保证乘法范围不会溢出
 *
 * 链接：<a href="https://leetcode.cn/problems/recursive-mulitply-lcci">...</a>
 * @author ouyb01
 * @date 2022/6/9 9:34
 */
public class Multiply {

    public static void main(String[] args) {
        Multiply example = new Multiply();
        System.out.println(example.multiply(1, 10));
        System.out.println(example.multiply(3, 4));
    }

    public int multiply(int a, int b) {
        if (a > b) {
            return multiplyCur(a, b);
        }
        return multiplyCur(b, a);
    }

    public int multiplyCur(int a, int b) {
        System.out.println("a: " + a + "   b: " + b);
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == 1) {
            return b;
        }
        if (b == 1) {
            return a;
        }
        return multiplyCur(a, b - 1) + a;
    }

}
