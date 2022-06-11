package com.ohyoung.leetcode.recursive.offer;

/**
 * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 提示：
 * -100.0 <x< 100.0
 * -231<= n <=231-1
 * -104<= xn<= 104
 *
 * 链接：<a href="https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof">...</a>
 * @author ouyb01
 * @date 2022/6/9 9:33
 */
public class MyPow {

    public static void main(String[] args) {
        MyPow example = new MyPow();
        System.out.println(example.myPow(2.00000, 10));
        System.out.println(example.myPow(2.10000, 3));
        System.out.println(example.myPow(2.00000, -2));
    }

    /**
     * 使用递归的方式解决: x^32 -> x^(16 * 2) -> x^(8 * 2 * 2) -> ... x^2 / x^2 * x
     */
    public double myPow(double x, int n) {
        //  -2^32转为正数时会溢出, 所以这里用long
        return (long) n >= 0 ? cal(x, n) : 1.0 / cal(x, -(long) n);
    }

    public double cal(double x, long l) {
        if (l == 0) {
            return 1.0;
        }
        double y = cal(x, l / 2);
        return l % 2 == 0 ? y * y : y * y * x;
    }

}
