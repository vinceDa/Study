package com.ohyoung.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 * @author ohYoung
 * @date 2021/7/1 22:25
 */
public class HasCycleAndReturn142 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next =  new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.print("hasCycle: " + hasCycle2(head).val);

    }

    /**
     * 快慢指针，数学推导是重点，假设入环前的距离为a，入环点到相遇点距离为b，相遇点回到入环点的距离为c
     * slow * 2 = fast
     * slow = a + b
     * fast = a + b + c + b(此处本来应该是a + b + n * (c + b), 但是在慢节点入环前快节点的循环是无意义的，这里只记录慢节点入环时的那一圈，所以省略n)
     * ==> a = c
     * 所以在快慢节点相遇时，重新定义一个节点pre从head开始，与慢节点相遇的时候就是入环点
     */
    public static ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode pre = head;
                while (pre != slow) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 用Set存储节点，如果添加失败则表示已经添加过，证明当前链表是个环
     */
    public static ListNode hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
