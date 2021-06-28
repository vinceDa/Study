package com.ohyoung.leetcode.linkedlist;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * @author ohYoung
 * @date 2021/6/28 22:40
 */
public class RemoveDuplicateNodeFromSortedLinkedList83 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        ListNode resNode = removeDuplicateNode(node);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    /**
     * 由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，因此我们只需要对链表进行一次遍历，就可以删除重复的元素
     */
    private static ListNode removeDuplicateNode(ListNode head) {
        if (head == null) {
            return null;
        }
        // 设置一个校验节点
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 将元素存入hash表
     */
    private static ListNode removeDuplicateNodeByHash(ListNode head) {
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
