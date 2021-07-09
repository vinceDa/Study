package com.ohyoung.leetcode.stack;

import java.util.Deque;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素
 * @author ohYoung
 * @date 2021/7/7 22:06
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
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

    public MinStack() {
        normalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        normalStack.push(val);
        if (minStack.size() == 0) {
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
