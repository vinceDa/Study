package com.ohyoung.leetcode.match;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 * @author vince
 */
public class StrStr28 {

    /**
     * todo 暂时使用最简单的BF算法，有时间了会将BM和KMP算法用进去
     */
    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("abc", "c"));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", ""));
    }

    public static int strStr(String haystack, String needle) {
        return BF(haystack, haystack.length(), needle, needle.length());
    }

    private static int BF(String haystack, int n, String needle, int m) {
        if (needle == null) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack == null || "".equals(haystack)) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i < n - m + 1; i++) {
            String subStr = haystack.substring(i, i + m);
            if (needle.equals(subStr)) {
                return i;
            }
        }
        return -1;
    }

}
