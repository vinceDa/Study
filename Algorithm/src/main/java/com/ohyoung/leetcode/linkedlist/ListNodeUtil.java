package com.ohyoung.leetcode.linkedlist;

/**
 * @author ouyb01
 * @date 2022/7/27 15:15
 */
public class ListNodeUtil {

    public static ListNode setNext(int[] values) {
        if (values.length == 0) {
            return new ListNode();
        }
        ListNode head = new ListNode(values[0]);
        ListNode cur = head;
        for (int i = 1; i < values.length; i++) {
            cur.next = new ListNode(values[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode listNode = setNext(new int[]{1, 2, 3, 4});
        print(listNode);
    }

}
