package com.ohyoung.leetcode.programming;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *
 * 提示：
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 * @author ohYoung
 * @date 2022/5/26 7:57
 */
public class IsPalindrome125 {

    public static void main(String[] args) {
        IsPalindrome125 example = new IsPalindrome125();
        String s = "A man, a plan, a canal: Panama";
        System.out.println("isPalindrome: " + example.isPalindrome(s));
        s = "race a car";
        System.out.println("isPalindrome: " + example.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        int length = s.length();
        int end = length - 1;
        // 遍历每个字符
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            // 如果c不是字符或数字, 则略过
            if (c < '1' || (c > '9' && c - 'a' > 35 && c - 'A' > 35)) {

            }
            if () {

            }
        }
        // 从第一个有效字符开始, 从末端找匹配项, 匹配成功则记录end下标并继续第二个字符

        // 当遍历下标>=end时, 遍历结束, 返回结果
        return true;
    }

}
