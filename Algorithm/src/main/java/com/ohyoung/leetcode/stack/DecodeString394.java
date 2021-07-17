package com.ohyoung.leetcode.stack;

import java.util.*;

/**
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * @author ohYoung
 * @date 2021/7/10 17:14
 */
public class DecodeString394 {
    private static int index;

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("abc3[cd]xyz"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    /**
     * 定义一个栈，如果是数字则解析成数字后入栈，如果是[或是字符则直接入栈，
     * 如果碰到]就开始出栈，直到[才停止(此时栈顶元素一定是数字)，将[]中的字符拼接再反转然后再结合栈顶的数字形成新的字符串后再压入栈，
     * 当字符串的解析完成后，依次从栈中取出元素组合则为最后的结果
     */
    private static String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        index = 0;
        while (index < s.length()) {
            char curr = s.charAt(index);
            if (Character.isDigit(curr)) {
                stack.addLast(getDigits(s));
                // 如果是字符或者[则直接入栈
            } else if (Character.isLetter(curr) || curr == '[') {
                stack.addLast(String.valueOf(s.charAt(index++)));
            } else {
                ++index;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);
                // 过滤[
                stack.removeLast();
                int count = Integer.parseInt(stack.removeLast());
                String string = getString(sub);
                StringBuilder sub2 = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    sub2.append(string);
                }
                stack.addLast(sub2.toString());
            }
        }
        StringBuilder resBuilder = new StringBuilder();
        for (String re : stack) {
            resBuilder.append(re);
        }
        return resBuilder.toString();
    }

    /**
     * 如果碰到数字，则要确认接下来的是否为数字
     * 例如：12[a]，碰到1后，继续往后走最终获取到数字为12
     */
    private static String getDigits(String s) {
        StringBuilder integer = new StringBuilder();
        while (Character.isDigit(s.charAt(index))) {
            integer.append(s.charAt(index++));
        }
        return integer.toString();
    }

    private static String getString(LinkedList<String> strings) {
        StringBuilder ret = new StringBuilder();
        for (String string : strings) {
            ret.append(string);
        }
        return ret.toString();
    }
}
