package com.ohyoung.leetcode.linkedlist.xzg.pic;

import com.ohyoung.leetcode.linkedlist.ListNode;
import com.ohyoung.leetcode.linkedlist.ListNodeUtil;
import com.ohyoung.leetcode.linkedlist.xzg.ReverseList206;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 *
 * 提示：
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *
 * 进阶：你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 链接：<a href="https://leetcode.cn/problems/palindrome-linked-list">...</a>
 * @author ouyb01
 * @date 2022/7/27 9:46
 */
public class IsPalindrome234 {

    public static void main(String[] args) {
        IsPalindrome234 example = new IsPalindrome234();
        ListNode head = ListNodeUtil.setNext(new int[]{1, 2, 2, 1});
        System.out.println(example.isPalindrome(head));
        head = ListNodeUtil.setNext(new int[]{1, 2});
        System.out.println(example.isPalindrome(head));
        head = ListNodeUtil.setNext(new int[]{});
        System.out.println(example.isPalindrome(head));
        head = ListNodeUtil.setNext(new int[]{1});
        System.out.println(example.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 1. 快慢指针确认中间位置
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. 翻转后半部分的链表数据(奇数个节点则从slow.next开始, 偶数个节点则从slow开始)
        slow = reverse(slow);
        ListNode l = slow;
        // 3. 比对是否回文
        ListNode tmp = head;
        while (slow != null) {
            if (slow.val != tmp.val) {
                return false;
            }
            slow = slow.next;
            tmp = tmp.next;
        }
        // 4. 将链表还原
        reverse(l);
        return true;
    }

    public ListNode  reverse(ListNode head) {
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

}
