package com.ohyoung.leetcode.hash;

/**
 * 242. 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s 和 t 仅包含小写字母
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <a href="https://leetcode-cn.com/problems/valid-anagram/"></a>
 * @author vince 2023/8/21 11:44
 */
public class IsAnagram242 {

    public static void main(String[] args) {
        IsAnagram242 isAnagram = new IsAnagram242();
        System.out.println(isAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram.isAnagram("rat", "car"));
        System.out.println(isAnagram.isAnagram("ac", "bb"));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (array[index] == 0) {
                return false;
            }
            array[index]--;
        }
        return true;
    }


}
