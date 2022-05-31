package com.ohyoung.leetcode.programming;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * @author ohYoung
 * @date 2022/5/30 23:12
 */
public class ReplaceSpaceOffer05 {

    public static void main(String[] args) {
        ReplaceSpaceOffer05 example = new ReplaceSpaceOffer05();
        System.out.println("LengthOfLastWord58 We are happy.: " + "We%20are%20happy.".equals(example.replaceSpace("We are happy.")));
        System.out.println("LengthOfLastWord58 : " + "".equals(example.replaceSpace("")));
    }

    public String replaceSpace(String s) {
        // 创建一个3s大的数组, 保证能够容纳所有元素
        char[] array = new char[s.length() * 3];
        // 创建变量size记录真实大小, 用于最后切割数组
        int size = 0;
        // 遍历s
        for (int i = 0; i < s.length(); i++) {
            // 碰到空格就将其替换成%20(占三个元素)
            if (s.charAt(i) == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = s.charAt(i);
            }
        }
        // 将字符数组转换为String
        return new String(array, 0, size);
    }

}
