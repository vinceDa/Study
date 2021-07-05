package com.ohyoung.leetcode.linkedlist;

/**
 * @author ohYoung
 * @date 2021/7/1 22:25
 */
public class MergeTwoLists21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + "  ");
            listNode = listNode.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1;
        if (l2 != null) {
            curr.next = l2;
        }
        return dummy.next;
    }
}
