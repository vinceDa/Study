package com.ohyoung.leetcode;

/**
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * 返回重新排列后的字符串。
 *
 * 示例 1：
 *  输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 *  输出："leetcode"
 *  解释："codeleet" 重新排列后变为 "leetcode" 。
 *
 * @author ohYoung
 * @date 2020/11/6 15:26
 */
public class SortArray1528 {

    public static void main(String[] args) {
        String s = "aiohn";
        int[] indices = new int[]{3,1,4,2,0};
        System.out.println(restoreString(s, indices));
    }

    private static String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] sortChars = new char[chars.length];
        for (int i = 0; i < indices.length; i++) {
            sortChars[indices[i]] = chars[i];
        }
        return new String(sortChars);
    }

}
