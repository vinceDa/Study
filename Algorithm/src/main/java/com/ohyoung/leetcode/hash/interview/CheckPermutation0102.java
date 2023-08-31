package com.ohyoung.leetcode.hash.interview;

/**
 * 面试题 01.02. 判定是否互为字符重排
 *
 * 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 *
 * 说明：
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * <a href="https://leetcode-cn.com/problems/check-permutation-lcci/"></a>
 * @author vince 2023/8/21 10:11
 */
public class CheckPermutation0102 {

    public static void main(String[] args) {
        CheckPermutation0102 checkPermutation = new CheckPermutation0102();
        System.out.println(checkPermutation.CheckPermutation("abc", "bca"));
        System.out.println(checkPermutation.CheckPermutation("abc", "bad"));
        System.out.println(checkPermutation.CheckPermutation("asvnpzurz", "urzsapzvn"));

    }

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] index = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            index[c]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (index[c] == 0) {
                return false;
            }
            index[c]--;
        }
        return true;
    }


}
