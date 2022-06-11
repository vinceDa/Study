package com.ohyoung.leetcode.recursive.offer;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 *
 * 提示：
 * 0 <= n <= 100
 *
 * 链接：<a href="https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof">...</a>
 * @author ouyb01
 * @date 2022/6/9 9:22
 */
public class Fib {

    public static void main(String[] args) {
        Fib example = new Fib();
        System.out.println(example.fib(2));
        System.out.println(example.fib(5));
        System.out.println(example.fib(20));
        System.out.println(example.fib(100));
    }

    // 不用mem会超时
    int[] mem = new int[101];
    int mod = 1000000007;

    public int fib(int n) {
        if (mem[n] != 0) {
            return mem[n] % mod;
        }
        if (n <= 1) {
            mem[n] = n;
            return mem[n];
        }
        mem[n] = (fib(n - 1) + fib(n - 2)) % mod;
        return mem[n];
    }

}
