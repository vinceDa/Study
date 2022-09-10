package com.ohyoung.leetcode.recursive.offer;

import com.ohyoung.leetcode.linkedlist.ListNode;
import com.ohyoung.leetcode.linkedlist.ListNodeUtil;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 5000
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof">...</a>
 *
 * @author ouyb01
 * @date 2022/6/9 9:30
 */
public class ReverseList {

    public static void main(String[] args) {
        ReverseList example = new ReverseList();
        ListNode listNode = ListNodeUtil.setNext(new int[]{1, 2, 3, 4, 5});
        ListNodeUtil.print(example.reverseList(listNode));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        // 不置为null可能会产生环
        head.next = null;
        return newHead;
    }

}
