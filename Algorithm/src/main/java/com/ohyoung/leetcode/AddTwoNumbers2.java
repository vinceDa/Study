package com.ohyoung.leetcode;

/**
 *  [2]两数相加
 *  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 *  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 *  您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  示例：
 *
 *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author ohYoung
 * @date 2020-12-04 09:47:39
 */
public class AddTwoNumbers2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        ListNode tmp1 = l1;
        while (tmp1 != null) {
            System.out.print(tmp1.val + " ");
            tmp1 = tmp1.next;
        }
        System.out.println();
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        ListNode tmp2 = l2;
        while (tmp2 != null) {
            System.out.print(tmp2.val + " ");
            tmp2 = tmp2.next;
        }
        System.out.println();
        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int increase = 0;
        ListNode res = new ListNode();
        ListNode tmp = res;
        while (l1 != null && l2 != null) {
            int count = l1.val + l2.val + increase;
            if (count >= 10) {
                increase = 1;
                count -= 10;
            } else {
                increase = 0;
            }
            tmp.next = new ListNode(count);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode rest = l1;
        if (l2 != null) {
            rest = l2;
        }
        if (increase == 1) {
            while (rest != null) {
                int count = rest.val + increase;
                if (count >= 10) {
                    increase = 1;
                    count -= 10;
                } else {
                    increase = 0;
                }
                tmp.next = new ListNode(count);
                tmp = tmp.next;
                rest = rest.next;
            }
            if (increase == 1) {
                tmp.next = new ListNode(increase);
            }
        } else {
            tmp.next = rest;
        }
        return res.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  }
}