package com.ohyoung.leetcode.linkedlist.xzg.offer;

import com.ohyoung.leetcode.linkedlist.ListNode;
import com.ohyoung.leetcode.linkedlist.ListNodeUtil;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 * 0 <= 链表长度 <= 1000
 *
 * 链接：<a href="https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/">...</a>
 * @author ouyb01
 * @date 2022/7/27 9:36
 */
public class MergeTwoLists25 {

    public static void main(String[] args) {
        MergeTwoLists25 example = new MergeTwoLists25();
        ListNode l1 = ListNodeUtil.setNext(new int[]{1, 2, 4});
        ListNode l2 = ListNodeUtil.setNext(new int[]{1, 3, 4});
        ListNodeUtil.print(example.mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
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
        return res.next;
    }
}
