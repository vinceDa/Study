package com.ohyoung.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ohYoung
 * @date 2021/7/1 22:25
 */
public class RecordList143 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = reorderList(head);
        while (listNode != null) {
            System.out.print(listNode.val + "  ");
            listNode = listNode.next;
        }

    }

    /**
     * 利用线性表存储该链表，然后利用线性表可以下标访问的特点，直接按顺序访问指定元素，重建该链表即可
     */
    public static ListNode reorderList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        // 不加这一步会造成死循环
        list.get(i).next = null;
        return head;
    }

    /**
     * 寻找链表中点 + 链表逆序 + 合并链表
     */
    // TODO: 2021/7/2
    public static ListNode reorderList2(ListNode head) {
        return null;
    }


}
