package com.ohyoung.leetcode.binarysearch;

/**
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 提示：
 * <p>
 * 0 <= x <= 2^31 - 1
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/sqrtx">...</a>
 *
 * @author ouyb01
 * @date 2022/6/14 9:33
 */
public class MySqrt69 {

    public static void main(String[] args) {
        MySqrt69 demo = new MySqrt69();
        System.out.println(demo.mySqrt(4));
        System.out.println(demo.mySqrt(8));
        System.out.println(demo.mySqrt(1));
        System.out.println(demo.mySqrt(0));
        System.out.println(demo.mySqrt(2147483647));
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int end = x / 2;
        int start = 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (mid  == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                if (mid - 1 <= x / (mid - 1)) {
                    return mid - 1;
                }
                end = mid - 1;
            } else if (mid < x / mid) {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                start = mid + 1;
            }
        }
        return start;
    }

}
