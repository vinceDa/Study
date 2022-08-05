package com.ohyoung.leetcode.stack.xzg.interviews;

import java.util.Stack;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek返回 -1。
 *
 * 示例1:
 *  输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 *  输出：
 * [null,null,null,1,null,2]
 *
 * 示例2:
 *  输入： 
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 *  输出：
 * [null,null,null,null,null,true]
 * 说明:
 * 栈中的元素数目在[0, 5000]范围内。
 *
 * 链接：<a href="https://leetcode.cn/problems/sort-of-stacks-lcci">...</a>
 * @author ouyb01
 * @date 2022/6/2 17:35
 */
public class SortedStack0305 {

    private Stack<Integer> stack;

    private Stack<Integer> tmp;

    public SortedStack0305() {
        stack = new Stack<>();
        tmp = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || val <= stack.peek()) {
            stack.push(val);
            return;
        }
        while (!stack.isEmpty()) {
            if (val > stack.peek()) {
                tmp.push(stack.pop());
            } else {
                break;
            }
        }
        stack.push(val);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack0305 example = new SortedStack0305();
        example.peek();
        example.peek();
        example.pop();
        example.isEmpty();
        example.peek();
        example.push(19);
        example.pop();
        example.push(19);
        example.pop();
        System.out.println(example.peek());
    }

}
