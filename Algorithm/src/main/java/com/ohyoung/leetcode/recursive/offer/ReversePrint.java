package com.ohyoung.leetcode.recursive.offer;

import java.util.Arrays;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof">...</a>
 *
 * @author ouyb01
 * @date 2022/6/9 9:28
 */
public class ReversePrint {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        ReversePrint example = new ReversePrint();
        System.out.println(Arrays.toString(example.reversePrint(head)));
    }


    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode currentNode = head;
        int size = 0;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        int[] res = new int[size];
        int index = size - 1;
        while (head != null) {
            res[index--] = head.val;
            head = head.next;
        }
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
