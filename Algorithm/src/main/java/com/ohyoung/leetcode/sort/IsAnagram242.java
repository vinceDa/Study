package com.ohyoung.leetcode.sort;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * 示例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 提示:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s 和 t仅包含小写字母
 *
 * 进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 进阶问题的核心点在于「字符是离散未知的」，因此我们用哈希表维护对应字符的频次即可。同时读者需要注意
 * \text{Unicode}Unicode 一个字符可能对应多个字节的问题，不同语言对于字符串读取处理的方式是不同的。
 *
 * 链接：<a href="https://leetcode.cn/problems/valid-anagram">...</a>
 * @author ouyb01
 * @date 2022/9/8 9:31
 */
public class IsAnagram242 {

    public static void main(String[] args) {
        IsAnagram242 example = new IsAnagram242();
        System.out.println(example.isAnagram("anagram", "nagaram"));
        System.out.println(example.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        for (int c : chars) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
