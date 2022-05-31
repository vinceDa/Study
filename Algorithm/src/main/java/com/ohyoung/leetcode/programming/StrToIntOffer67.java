package com.ohyoung.leetcode.programming;

import cn.hutool.log.Log;

/**
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，
 * 则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−2^31, 2^31− 1]。如果数值超过这个范围，请返回 INT_MAX (2^31− 1) 或INT_MIN (−2^31) 。
 * <p>
 * 示例1:
 * 输入: "42"
 * 输出: 42
 * <p>
 * 示例2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * <p>
 * 示例3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * <p>
 * 示例4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * <p>
 * 示例5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 * 注意：本题与主站 8 题相同：https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @author ohYoung
 * @date 2022/5/30 23:18
 */
public class StrToIntOffer67 {

    public static void main(String[] args) {
        StrToIntOffer67 example = new StrToIntOffer67();
//        System.out.println("strToInt 42: " + example.strToInt("42"));
//        System.out.println("strToInt    -42: " + example.strToInt("   -42"));
//        System.out.println("strToInt 4193 with words: " + example.strToInt("4193 with words"));
//        System.out.println("strToInt words and 987: " + example.strToInt("words and 987"));
//        System.out.println("strToInt -91283472332: " + example.strToInt("-91283472332"));
//        System.out.println("strToInt +1: " + example.strToInt("+1"));
//        System.out.println("strToInt one blank: " + example.strToInt(" "));
//        System.out.println("strToInt two blank: " + example.strToInt("  "));
//        System.out.println("strToInt 3.14159: " + example.strToInt("3.14159"));
//        System.out.println("strToInt -: " + example.strToInt("-"));
//        System.out.println("strToInt -2147483647: " + example.strToInt("-2147483647"));
//        System.out.println("strToInt 20000000000000000000: " + example.strToInt("20000000000000000000"));
//        System.out.println("strToInt blankb11228552307: " + example.strToInt(" b11228552307"));
//        System.out.println("strToInt 10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459: " +
//                example.strToInt("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
        System.out.println("strToInt 0000000000012345678: " + example.strToInt("  0000000000012345678"));

    }

    public int strToInt(String str) {
        if ("".equals(str)) {
            return 0;
        }
        // 去掉所有的开局空格
        int start = 0;
        int end = str.length() - 1;
        boolean hasStart = false;
        // 碰到-或数字时开始收集所有的数字
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 首字母不是空格、-和数字, 则转换失败
            if (c != ' ' && c != '-' && c != '+' && !isNum(c) && !hasStart) {
                return 0;
            }
            // 开始收集数字后, 碰到所有的非数字都将终止收集
            if (!isNum(c) && hasStart) {
                end = i - 1;
                break;
            }
            if (c != ' ' && c != '0' && !hasStart) {
                start = i;
                hasStart = true;
            }
        }
        if (!hasStart) {
            return 0;
        }
        if (start == end) {
            if (isNum(str.charAt(start))) {
                return str.charAt(start) - '0';
            }
            return 0;
        }
        char[] chars = new char[end - start + 1];
        int index = 0;
        for (int i = start; i <= end; i++) {
            chars[index++] = str.charAt(i);
        }
        // 不能用int, 不然有可能溢出
        long count = 0;
        int terminate = 0;
        if (chars[0] == '-' || chars[0] == '+') {
            terminate = 1;
        }
        // 倍数也有可能溢出
        long multiple = 1;
        for (int i = chars.length - 1; i >= terminate; i--) {
            if (chars[0] == '-') {
                count += -(chars[i] - '0') * multiple;
            } else {
                count += (chars[i] - '0') * multiple;
            }
            if (count > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (count < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (multiple > Integer.MAX_VALUE) {
                if (chars[0] == '-') {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            multiple *= 10;
        }
        return (int) count;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
