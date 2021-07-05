package com.ohyoung.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个链表是否为回文链表
 * @author ohYoung
 * @date 2021/7/1 22:25
 */
public class IsPalindrome141 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next =  new ListNode(1);
        System.out.print("isPalindrome: " + isPalindrome(head));

    }

    /**
     * 1、找到链表中间点（快慢指针）
     * 2、将后半部分反转
     * 3、比对前半部分和后半部分是否一致
     * 4、将链表还原（可以不还原，但是建议改变结构后还是还原的好）
     * 5、返回结果
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        // 单节点的链表也是回文链表
        if (head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverse = Reverse206.reverse(slow);
        ListNode front = head;
        ListNode behind = reverse;
        while (behind != null) {
            if (behind.val == front.val) {
                behind = behind.next;
                front = front.next;
            } else {
                return false;
            }
        }
        Reverse206.reverse(reverse);
        return true;
    }

}
