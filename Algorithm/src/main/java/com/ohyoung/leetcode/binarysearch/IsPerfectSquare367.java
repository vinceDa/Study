package com.ohyoung.leetcode.binarysearch;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 *
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 *
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 *
 * 提示：
 * 1 <= num <= 2^31 - 1
 *
 * 链接：<a href="https://leetcode.cn/problems/valid-perfect-square">...</a>
 * @author ouyb01
 * @date 2022/6/14 9:32
 */
public class IsPerfectSquare367 {

    public static void main(String[] args) {
        IsPerfectSquare367 demo = new IsPerfectSquare367();
        System.out.println(demo.isPerfectSquare(16));
        System.out.println(demo.isPerfectSquare(14));
        System.out.println(demo.isPerfectSquare(5));
        System.out.println(demo.isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        int start = 1;
        int end = num / 2;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (mid == num / mid) {
                if (num % mid == 0) {
                    return true;
                }
                end = mid - 1;
            } else if (mid > num / mid) {
                end = mid - 1;
            } else if (mid < num / mid) {
                start = mid + 1;
            }
        }
        return false;
    }

}
