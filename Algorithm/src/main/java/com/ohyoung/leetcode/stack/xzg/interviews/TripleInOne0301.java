package com.ohyoung.leetcode.stack.xzg.interviews;

/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 示例1:
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 *
 * 示例2:
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *
 * 提示：
 * 0 <= stackNum <= 2
 *
 * 链接：<a href="https://leetcode.cn/problems/three-in-one-lcci">...</a>
 * @author ouyb01
 * @date 2022/6/2 17:38
 */
public class TripleInOne0301 {
    int size;
    int[][] stack;
    int[] top;

    public TripleInOne0301(int stackSize) {
        size = stackSize;
        stack = new int[3][size];
        top = new int[3];
    }

    public void push(int stackNum, int value) {
        if (top[stackNum] < size)
            stack[stackNum][top[stackNum]++] = value;
    }

    public int pop(int stackNum) {
        return isEmpty(stackNum) ? -1 : stack[stackNum][--top[stackNum]];
    }

    public int peek(int stackNum) {
        return isEmpty(stackNum) ? -1 : stack[stackNum][top[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return top[stackNum] == 0;
    }
}
