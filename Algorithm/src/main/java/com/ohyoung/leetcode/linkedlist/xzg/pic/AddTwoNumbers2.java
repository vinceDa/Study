package com.ohyoung.leetcode.linkedlist.xzg.pic;

import com.ohyoung.leetcode.linkedlist.ListNode;
import com.ohyoung.leetcode.linkedlist.ListNodeUtil;

import java.awt.geom.QuadCurve2D;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 链接：<a href="https://leetcode.cn/problems/add-two-numbers">...</a>
 * @author ouyb01
 * @date 2022/7/27 9:38
 */
public class AddTwoNumbers2 {

    public static void main(String[] args) {
        AddTwoNumbers2 example = new AddTwoNumbers2();
        ListNode l1 = ListNodeUtil.setNext(new int[]{2, 4, 3});
        ListNode l2 = ListNodeUtil.setNext(new int[]{5, 6, 4});
        ListNodeUtil.print(example.addTwoNumbers(l1, l2));

        l1 = ListNodeUtil.setNext(new int[]{0});
        l2 = ListNodeUtil.setNext(new int[]{0});
        ListNodeUtil.print(example.addTwoNumbers(l1, l2));

        l1 = ListNodeUtil.setNext(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = ListNodeUtil.setNext(new int[]{9, 9, 9, 9});
        ListNodeUtil.print(example.addTwoNumbers(l1, l2));
    }

    /**
     * 直接相加数字大小会超限， 直接使用对位相加的方式然后处理新的链表(是否进1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            tmp.next = new ListNode(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
            tmp = tmp.next;
        }
        while (l1 != null) {
            tmp.next = l1;
            tmp = tmp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            tmp.next = l2;
            tmp = tmp.next;
            l2 = l2.next;
        }
        tmp = head;
        int count = 0;
        while (tmp != null) {
            int val = tmp.val + count;
            tmp.val = val % 10;
            count = val / 10;
            if (tmp.next == null && count != 0) {
                tmp.next = new ListNode(count);
                break;
            }
            tmp = tmp.next;
        }
        return head.next;
    }

}
