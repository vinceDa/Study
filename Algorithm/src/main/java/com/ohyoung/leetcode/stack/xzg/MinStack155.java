package com.ohyoung.leetcode.stack.xzg;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 *
 * 示例 1:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 提示：
 * -231<= val <= 231- 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push,pop,top, andgetMin最多被调用3 * 104次
 *
 * 链接：<a href="https://leetcode.cn/problems/min-stack">...</a>
 * @author ohYoung
 * @date 2021/7/7 22:06
 */
public class MinStack155 {

    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    Stack<Integer> normalStack;

    /**
     * 使用一个辅助栈存储最小值，在push的时候和最小栈的顶部数值比较，小的压入栈顶，获取最小值时peek最小栈
     */
    Stack<Integer> minStack;

    public MinStack155() {
        normalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        normalStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            Integer min = minStack.peek();
            if (min > val) {
                minStack.push(val);
            } else {
                minStack.push(min);
            }
        }

    }

    public void pop() {
        normalStack.pop();
        minStack.pop();
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }



}
