package com.ohyoung.leetcode;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
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
 * @author ouyb01
 * @date 2021/11/4 17:32
 */
public class IsPerfectSquare367 {

    public static void main(String[] args) {
        IsPerfectSquare367 example = new IsPerfectSquare367();
        System.out.println(example.isPerfectSquare(16));
        System.out.println(example.isPerfectSquare(20));
    }

    public boolean isPerfectSquare(int num) {
        int start = 0;
        int end = num;
        while (start <= end) {
            // 取代 (end + start) / 2, 防止start + end过大造成溢出
            int mid = (end - start) / 2 + start;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return false;
    }
}
