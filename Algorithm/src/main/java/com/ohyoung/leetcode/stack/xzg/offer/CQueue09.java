package com.ohyoung.leetcode.stack.xzg.offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 * 1 <= values <= 10000
 * 最多会对appendTail、deleteHead 进行10000次调用
 *
 * 链接：<a href="https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof">...</a>
 *
 * @author ouyb01
 * @date 2022/6/2 17:33
 */
public class CQueue09 {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public CQueue09() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        if (!stackOut.isEmpty()) {
            return stackOut.pop();
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.isEmpty() ? -1 :stackOut.pop();
    }


    
}
