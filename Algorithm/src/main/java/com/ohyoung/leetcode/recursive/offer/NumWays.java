package com.ohyoung.leetcode.recursive.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 *
 * 提示：
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：<a href="https://leetcode-cn.com/problems/climbing-stairs/">...</a>
 *
 * 链接：<a href="https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof">...</a>
 *
 * 设跳上 n 级台阶有f(n) 种跳法。在所有跳法中，青蛙的最后一步只有两种情况： 跳上 1 级或 2 级台阶。
 * 当为 1 级台阶： 剩 n-1 个台阶，此情况共有 f(n-1) 种跳法；
 * 当为 2 级台阶： 剩 n-2 个台阶，此情况共有 f(n-2) 种跳法。
 * f(n)为以上两种情况之和，即 f(n)=f(n-1)+f(n-2) ，以上递推性质为斐波那契数列。本题可转化为 求斐波那契数列第 n 项的值 ，
 * 与 面试题10- I. 斐波那契数列 等价，唯一的不同在于起始数字不同。
 * 青蛙跳台阶问题： f(0)=1, f(1)=1, f(2)=2；
 * 斐波那契数列问题： f(0)=0, f(1)=1, f(2)=1。
 * @author ouyb01
 * @date 2022/6/9 9:26
 */
public class NumWays {

    public static void main(String[] args) {
        NumWays example = new NumWays();
        System.out.println(example.numWays(2));
        System.out.println(example.numWays(7));
        System.out.println(example.numWays(0));
        System.out.println(example.numWays(44));

    }

    int[] mem = new int[101];
    int mod = 1000000007;

    public int numWays(int n) {
        if (mem[n] != 0) {
            return mem[n] % mod;
        }
        if (n <= 1) {
            mem[n] = 1;
            return mem[n];
        }
        mem[n] = (numWays(n - 1) + numWays(n - 2)) % mod;
        return mem[n];
    }

}
