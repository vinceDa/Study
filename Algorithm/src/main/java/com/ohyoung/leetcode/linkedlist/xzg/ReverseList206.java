package com.ohyoung.leetcode.linkedlist.xzg;

import com.ohyoung.leetcode.linkedlist.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 链接：<a href="https://leetcode.cn/problems/reverse-linked-list">...</a>
 * @author ohYoung
 * @date 2021/6/28 22:40
 */
public class ReverseList206 {

    public void main(String[] args) {
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
     *  链表反转，类似于引入第三个变量将a，b颠倒，不同的是需要注意代码顺序，不然可能会导致死循环
     */
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

    /**
     * 递归删除
     */
    // TODO
    private static ListNode removeDuplicateNodeByRecursion(ListNode head) {
        return null;
    }

}
