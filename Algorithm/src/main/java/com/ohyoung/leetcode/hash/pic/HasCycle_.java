package com.ohyoung.leetcode.hash.pic;

/**
 * 141. 环形链表
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 *  <a href="https://leetcode-cn.com/problems/linked-list-cycle/"></a>
 *
 * @author vince 2023/8/21 10:06
 */
public class HasCycle_ {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {

        return false;
    }

    public class ListNode {
        int val;

        GetIntersectionNode_.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
