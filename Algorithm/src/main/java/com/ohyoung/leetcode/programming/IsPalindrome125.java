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
        s = ",,,,,,";
        System.out.println("isPalindrome: " + example.isPalindrome(s));
        s = "0P";
        System.out.println("isPalindrome: " + example.isPalindrome(s));
        s = "ab_a";
        System.out.println("isPalindrome: " + example.isPalindrome(s));
    }

    /**
     * 使用双指针分别指向头和尾, 当头和尾指向的char都为字符和数字时才进行比较, 比较成功后再往中间移动,
     * 当指针重合后说明匹配成功
     */
    public boolean isPalindrome(String s) {
        int length = s.length();
        int start = 0;
        int end = length - 1;
        while (start < end) {
            char c1 = s.charAt(start);
            if (!isCharacter(c1) && !isNum(c1)) {
                start++;
                continue;
            }
            char c2 = s.charAt(end);
            if (!isCharacter(c2) && !isNum(c2)) {
                end--;
                continue;
            }
            // 不相等且存在数字, 则铁定不回文
            if (c1 != c2 && (isNum(c1) || isNum(c2))) {
                return false;
            }
            if (c1 != c2 && isCharacter(c1) && isCharacter(c2)  && c1 - 32 != c2 && c2 - 32 != c1) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isCharacter(char c) {
        return (c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z';
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
