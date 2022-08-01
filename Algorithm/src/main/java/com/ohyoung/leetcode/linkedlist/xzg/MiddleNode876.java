package com.ohyoung.leetcode.linkedlist.xzg;

import com.ohyoung.leetcode.linkedlist.ListNode;
import com.ohyoung.leetcode.linkedlist.ListNodeUtil;

/**
 * 给定一个头结点为 head的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 *
 * 示例2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 * 提示：
 * 给定链表的结点数介于1和100之间。
 *
 * 链接：<a href="https://leetcode.cn/problems/middle-of-the-linked-list">...</a>
 * @author ouyb01
 * @date 2022/7/27 9:34
 */
public class MiddleNode876 {

    public static void main(String[] args) {
        MiddleNode876 example = new MiddleNode876();
        ListNode head = ListNodeUtil.setNext(new int[]{1, 2, 3, 4, 5});
        ListNodeUtil.print(example.middleNode(head));
        head = ListNodeUtil.setNext(new int[]{1,2,3,4,5,6});
        ListNodeUtil.print(example.middleNode(head));

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
