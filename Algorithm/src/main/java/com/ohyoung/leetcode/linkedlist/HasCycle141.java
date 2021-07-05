package com.ohyoung.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环
 * @author ohYoung
 * @date 2021/7/1 22:25
 */
public class HasCycle141 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next =  new ListNode(-4);
        head.next.next.next.next = head.next.next;
        System.out.print("hasCycle: " + hasCycle(head));

    }

    /**
     * 快慢指针，如果存在环，快慢指针会一直在环里移动，由于快指针每次都比慢指针多走一步，所以
     * 一定存在某个时刻，快指针会在N圈后追到慢指针，也就是fast==slow，这就是判断条件；
     * 假如不存在环，快指针一定先一步或者和慢指针同时走完链表
     * 边界条件：
     *      1、当链表为null时直接返回false
     *      2、当链表头节点的next为null时返回false（一个节点的链表肯定不是环）
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode soft = head;
        ListNode fast = head.next;
        while (soft != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            soft = soft.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 用Set存储节点，如果添加失败则表示已经添加过，证明当前链表是个环
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
