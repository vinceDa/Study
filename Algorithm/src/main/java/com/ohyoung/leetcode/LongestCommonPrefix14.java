package com.ohyoung.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *      输入：strs = ["flower","flow","flight"]
 *      输出："fl"
 * 示例 2：
 *      输入：strs = ["dog","racecar","car"]
 *      输出：""
 *      解释：输入不存在公共前缀。
 *
 * 提示：
 *      1 <= strs.length <= 200
 *      0 <= strs[i].length <= 200
 *      strs[i] 仅由小写英文字母组成
 *
 * @author ohYoung
 * @date 2021/9/24 22:25
 */
public class LongestCommonPrefix14 {

    public static void main(String[] args) {
        LongestCommonPrefix14 example = new LongestCommonPrefix14();
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(example.longestCommonPrefix(strs));
        strs = new String[]{"dog","racecar","car"};
        System.out.println(example.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        int minLength = Arrays.stream(strs).min(Comparator.comparing(String::length)).get().length();
        if (minLength == 0) {
            return "";
        }
        while (minLength > 0) {
            String target = strs[0].substring(0, minLength);
            boolean match = true;
            for (int i = 1; i < strs.length; i++) {
                if (!target.equals(strs[i].substring(0, minLength))) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return target;
            }
            minLength--;
        }
        return "";
    }

}
