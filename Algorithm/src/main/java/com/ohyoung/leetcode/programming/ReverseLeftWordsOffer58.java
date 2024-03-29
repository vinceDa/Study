package com.ohyoung.leetcode.programming;

import java.util.Arrays;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出:"cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出:"umghlrlose"
 *
 * 限制：
 * 1 <= k < s.length <= 10000
 * @author ohYoung
 * @date 2022/5/30 23:14
 */
public class ReverseLeftWordsOffer58 {

    public static void main(String[] args) {
        ReverseLeftWordsOffer58 example = new ReverseLeftWordsOffer58();
        System.out.println("reverseLeftWords abcdefg, k = 2: " + "cdefgab".equals(example.reverseLeftWords("abcdefg", 2)));
        System.out.println("reverseLeftWords lrloseumgh, k = 6: " + "umghlrlose".equals(example.reverseLeftWords("lrloseumgh", 6)));
    }

    public String reverseLeftWords(String s, int n) {
        char[] res = new char[s.length()];
        int index = 0;
        for (int i = n; i < s.length(); i++) {
            res[index++] = s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            res[index++] = s.charAt(i);
        }
        return String.valueOf(res);
    }

}
