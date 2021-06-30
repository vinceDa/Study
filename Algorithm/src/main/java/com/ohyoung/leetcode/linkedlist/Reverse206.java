package com.ohyoung.leetcode.linkedlist;

/**
 * 206. 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 * @author ohYoung
 * @date 2021/6/28 22:40
 */
public class Reverse206 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode resNode = reverse(node);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    /**
     *
     */
    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        // 记录前一个节点
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 递归删除
     */
    // TODO
    private static ListNode removeDuplicateNodeByRecursion(ListNode head) {
        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
