package com.ohyoung.leetcode.hash.pic;

import java.util.Objects;

/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 *
 * 示例 2：
 * 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 *
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 *
 * 注意：这里的相等是指针相等不是值相等
 *
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/"></a>
 * @author vince 2023/8/21 10:03
 */
public class GetIntersectionNode_ {

    public static void main(String[] args) {
        GetIntersectionNode_ getIntersectionNode = new GetIntersectionNode_();
        ListNode headA = getIntersectionNode.new ListNode(4);
        headA.next = getIntersectionNode.new ListNode(1);
        headA.next.next = getIntersectionNode.new ListNode(8);
        headA.next.next.next = getIntersectionNode.new ListNode(4);
        headA.next.next.next.next = getIntersectionNode.new ListNode(5);
        ListNode headB = getIntersectionNode.new ListNode(5);
        headB.next = getIntersectionNode.new ListNode(6);
        headB.next.next = getIntersectionNode.new ListNode(1);
        headB.next.next.next = headA.next.next;
        System.out.println(getIntersectionNode.getIntersectionNode3(headA, headB));

        headA = getIntersectionNode.new ListNode(1);
        headA.next = getIntersectionNode.new ListNode(9);
        headA.next.next = getIntersectionNode.new ListNode(1);
        headA.next.next.next = getIntersectionNode.new ListNode(2);
        headA.next.next.next.next = getIntersectionNode.new ListNode(4);
        headB = getIntersectionNode.new ListNode(3);
        headB.next = headA.next.next.next;
        System.out.println(getIntersectionNode.getIntersectionNode3(headA, headB));

        headA = getIntersectionNode.new ListNode(2);
        headA.next = getIntersectionNode.new ListNode(6);
        headA.next.next = getIntersectionNode.new ListNode(4);
        headB = getIntersectionNode.new ListNode(1);
        headB.next = getIntersectionNode.new ListNode(5);
        System.out.println(getIntersectionNode.getIntersectionNode3(headA, headB));
    }

    /**
     * 暴力解法
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        while (Objects.nonNull(hA)) {
            ListNode hB = headB;
            while (Objects.nonNull(hB)) {
                if (hA == hB && isSameNode(hA, hB)) {
                    return hA;
                }
                hB = hB.next;
            }
            hA = hA.next;
        }
        return null;
    }

    /**
     * 主要思路：只要存在相交点，相交点和后续节点一定完全相同，所以将两个链表的尾节点对齐，然后同时遍历两个链表，找到相同的节点即可
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode hA = headA;
        int lenA = 0;
        ListNode hB = headB;
        int lenB = 0;
        while (hA != null) {
            hA = hA.next;
            lenA++;
        }
        while (hB != null) {
            hB = hB.next;
            lenB++;
        }

        int len = lenA > lenB ? lenA - lenB : lenB - lenA;
        for (int i = 0; i < len; i++) {
            if (lenA > lenB) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    /**
     * 一样的思路，网上看到的更简洁的做法，牛！
     * a+c+b+c=b+c+a+c
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA != hB) {
            hA = hA == null ? headB : hA.next;
            hB = hB == null ? headA : hB.next;
        }
        return hA;
    }

    private boolean isSameNode(ListNode nodeA, ListNode nodeB) {
        ListNode nA = nodeA;
        ListNode nB = nodeB;
        while (Objects.nonNull(nA) && Objects.nonNull(nB)) {
            if (nA != nB) {
                return false;
            }
            nA = nA.next;
            nB = nB.next;
        }
        return Objects.isNull(nA) && Objects.isNull(nB);
    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
