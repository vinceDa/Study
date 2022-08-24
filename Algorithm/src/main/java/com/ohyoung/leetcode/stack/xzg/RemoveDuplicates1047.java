package com.ohyoung.leetcode.stack.xzg;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，
 * 其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * 提示：
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 *
 * 链接：<a href="https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string">...</a>
 * @author ouyb01
 * @date 2022/6/2 17:42
 */
public class RemoveDuplicates1047 {

    public static void main(String[] args) {
        RemoveDuplicates1047 example = new RemoveDuplicates1047();
        System.out.println(example.removeDuplicates("abbaca"));
        System.out.println(example.removeDuplicates("a"));
        System.out.println(example.removeDuplicates("ab"));
        System.out.println(example.removeDuplicates("aba"));
        System.out.println(example.removeDuplicates("abba"));
    }

    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "";
        }
        Deque<Character> resStack = new ArrayDeque<>();
        String res = "";
        while (!stack.isEmpty()) {
            resStack.push(stack.pop());
        }
        while (!resStack.isEmpty()) {
            res = res.concat(resStack.pop().toString());
        }
        return res;
    }
    

}
