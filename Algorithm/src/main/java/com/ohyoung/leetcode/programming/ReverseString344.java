package com.ohyoung.leetcode.programming;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 *
 * @author ohYoung
 * @date 2022/5/25 8:16
 */
public class ReverseString344 {

    public static void main(String[] args) {
        ReverseString344 example = new ReverseString344();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        example.reverseString(s);
        System.out.println("reverseString: " + Arrays.toString(s));
        s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        example.reverseString(s);
        System.out.println("reverseString: " + Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int length = s.length;
        char tmp;
        for (int i = 0; i < length; i++) {
            int i1 = length - i - 1;
            // 到达中间点位则说明反转已完成
            if (i >= i1) {
                return;
            }
            tmp = s[i];
            s[i] = s[i1];
            s[i1] = tmp;
        }
    }
}
