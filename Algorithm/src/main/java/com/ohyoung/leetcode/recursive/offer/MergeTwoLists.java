package com.ohyoung.leetcode.recursive.offer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 * 0 <= 链表长度 <= 1000
 *
 * 链接：<a href="https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof">...</a>
 * @author ouyb01
 * @date 2022/6/9 9:32
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MergeTwoLists example = new MergeTwoLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode res = example.mergeTwoLists(l1, l2);
        System.out.println(res);
        res = example.mergeTwoListsByRecursive(l1, l2);
        System.out.println(res);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        // 剩下的节点直接拼接到新链表的末尾
        tmp.next = l1 == null ? l2 : l1;
        return res.next;
    }

    /**
     * 通过递归的方式完成
     * 如果有一个为空, 则返回另一个非空列表
     * 定义merge操作:
     *      list1[0]+merge(list1[1:],list2) list1[0]<list2[0]
     *      list2[0]+merge(list1,list2[1:])  otherwise
     */
    public ListNode mergeTwoListsByRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsByRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsByRecursive(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
