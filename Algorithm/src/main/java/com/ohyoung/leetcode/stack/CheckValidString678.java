package com.ohyoung.leetcode.stack;

import java.util.Stack;

/**
 * 给定一个只包含三种字符的字符串：(,)和 *,写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 (必须有相应的右括号 )。
 * 任何右括号 )必须有相应的左括号 (。
 * 左括号 ( 必须在对应的右括号之前 )。
 * *可以被视为单个右括号 ),或单个左括号 (,或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 *
 * @author ohYoung
 * @date 2021/9/12 10:01
 */
public class CheckValidString678 {

    public static void main(String[] args) {
        CheckValidString678 example = new CheckValidString678();
        System.out.println(example.checkValidString("("));
//        System.out.println(example.checkValidString("(*)"));
//        System.out.println(example.checkValidString("(*))"));
//        System.out.println(example.checkValidString("())*"));
//        System.out.println(example.checkValidString(")()*"));
//        System.out.println(example.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
    private boolean checkValidString(String s) {
        // )(是非法的 --> 括号的匹配和顺序有关, 所以stack存储的是每个字符在字符串中的下标用来判断括号的顺序是否合法
        Stack<Integer> left = new Stack<>();
        Stack<Integer> general = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.add(i);
            } else if (c == '*') {
                general.add(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!general.isEmpty()) {
                    general.pop();
                } else {
                    return false;
                }
            }
        }
        // 如果左括号和*都还存在, 将*看作右括号和左括号进行匹配, 同时注意顺序
        while (!left.isEmpty() && !general.isEmpty()) {
            if (general.pop() < left.pop()) {
                return false;
            }
        }
        return left.isEmpty();
    }
}
