package com.ohyoung.leetcode.stack.xzg;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 链接：<a href="https://leetcode.cn/problems/valid-parentheses">...</a>
 * @author ouyb01
 * @date 2022/6/2 17:39
 */
public class IsValid20 {

    public static void main(String[] args) {
        IsValid20 example = new IsValid20();
        System.out.println(example.isValid("("));
        System.out.println(example.isValid(")"));
        System.out.println(example.isValid("()"));
        System.out.println(example.isValid("()[]{}"));
        System.out.println(example.isValid("(]"));
        System.out.println(example.isValid("([)]"));
        System.out.println(example.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        // 1. 定义一个栈
        Stack<Character> stack = new Stack<>();
        // 2. 遍历字符串, 如果是左括号, 直接入栈; 如果是右括号, 弹出栈顶元素和右括号进行比对, 成对则继续遍历, 否则返回
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if ((pop == '(' && c != ')') || (pop == '{' && c != '}') || (pop == '[' && c != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
