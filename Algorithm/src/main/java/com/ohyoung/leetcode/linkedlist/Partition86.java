package com.ohyoung.leetcode.linkedlist;

/**
 * 86. 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *     你应当 保留 两个分区中每个节点的初始相对位置
 * @author ohYoung
 * @date 2021/7/1 22:41
 */
public class Partition86 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);
        ListNode listNode = partition(node, 3);
        while (listNode != null) {
            System.out.print(listNode.val + "  ");
            listNode = listNode.next;
        }
    }

    private static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftCurr = left;
        ListNode rightCurr = right;
        while (head != null) {
            if (head.val < x) {
                leftCurr.next = head;
                leftCurr = leftCurr.next;
            } else {
                rightCurr.next = head;
                rightCurr = rightCurr.next;
            }
            head = head.next;
        }
        // right链表的next肯定为null
        rightCurr.next = null;
        // left链表的尾节点连上right即可
        leftCurr.next = right.next;
        return left.next;
    }
}
