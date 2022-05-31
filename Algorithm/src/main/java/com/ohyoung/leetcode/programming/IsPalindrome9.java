package com.ohyoung.leetcode.programming;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 *
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121。从右向左读, 为 121-。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 提示：
 * -2^31 <= x <= 2^31- 1
 * @author ohYoung
 * @date 2022/5/30 23:03
 */
public class IsPalindrome9 {

    public static void main(String[] args) {
        IsPalindrome9 example = new IsPalindrome9();
        System.out.println("IsPalindrome9 121: " + example.isPalindrome(121));
        System.out.println("IsPalindrome9 12321: " + example.isPalindrome(12321));
        System.out.println("IsPalindrome9 123321: " + example.isPalindrome(123321));
        System.out.println("IsPalindrome9 -121: " + example.isPalindrome(-121));
        System.out.println("IsPalindrome9 10: " + example.isPalindrome(10));
    }


    public boolean isPalindrome(int x) {
        // 负数肯定不是回文数
        if (x < 0) {
            return false;
        }
        // 个位数肯定是回文数
        if (x < 10) {
            return true;
        }
        // 大于10且能整除10的数肯定不是回文数
        if (x % 10 == 0) {
            return false;
        }
        // 反转后半部分数字, 当后半部分数字大于或等于前半部分数字时, 说明反转结束
        int i = 0;
        while (i < x) {
            i = i * 10 + x % 10;
            x /= 10;
        }
        // 当x为奇数位时, 比如12321, 最终得到的结果是12和123, 由于中位数对结果不会造成影响, 所以直接除以10再判断即可
        return x == i || x == i / 10;
    }

}
