package com.ohyoung.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
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
 */
public class IsValid20 {

    public static void main(String[] args) {
        IsValid20 example = new IsValid20();
        System.out.println(example.isValid("()"));
        System.out.println(example.isValid("()[]{}"));
        System.out.println(example.isValid("(]"));
        System.out.println(example.isValid("([)]"));
        System.out.println(example.isValid("{[]}"));
        System.out.println(example.isValid("["));
        System.out.println(example.isValid("(("));
        System.out.println(example.isValid("]"));

    }

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean push = c == '(' || c == '[' || c == '{';
            if (push) {
                stack.push(String.valueOf(c));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                String pop = stack.pop();
                if (("(".equals(pop) && c != ')') || ("{".equals(pop) && c != '}') || ("[".equals(pop) && c != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
