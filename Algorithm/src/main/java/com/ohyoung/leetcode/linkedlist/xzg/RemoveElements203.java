package com.ohyoung.leetcode.linkedlist.xzg;

import com.ohyoung.leetcode.linkedlist.ListNode;
import com.ohyoung.leetcode.linkedlist.ListNodeUtil;

import java.util.LinkedList;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * 提示：
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/remove-linked-list-elements">...</a>
 *
 * @author ouyb01
 * @date 2022/7/27 9:31
 */
public class RemoveElements203 {

    public static void main(String[] args) {
        RemoveElements203 example = new RemoveElements203();
        ListNode head = ListNodeUtil.setNext(new int[]{1, 2, 6, 3, 4, 5, 6});
        ListNodeUtil.print(example.removeElementsV1(head, 6));
        head = ListNodeUtil.setNext(new int[]{});
        ListNodeUtil.print(example.removeElementsV1(head, 1));
        head = ListNodeUtil.setNext(new int[]{7, 7, 7, 7});
        ListNodeUtil.print(example.removeElementsV1(head, 7));
        head = ListNodeUtil.setNext(new int[]{1, 2, 2, 1});
        ListNodeUtil.print(example.removeElementsV1(head, 2));

        head = ListNodeUtil.setNext(new int[]{1, 2, 6, 3, 4, 5, 6});
        ListNodeUtil.print(example.removeElementsV2(head, 6));
        head = ListNodeUtil.setNext(new int[]{});
        ListNodeUtil.print(example.removeElementsV2(head, 1));
        head = ListNodeUtil.setNext(new int[]{7, 7, 7, 7});
        ListNodeUtil.print(example.removeElementsV1(head, 7));
        head = ListNodeUtil.setNext(new int[]{1, 2, 2, 1});
        ListNodeUtil.print(example.removeElementsV2(head, 2));
    }

    /**
     * 初版
     */
    public ListNode removeElementsV1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 哑巴节点解决
     */
    public ListNode removeElementsV2(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * 递归
     * 递归的终止条件是 head 为空，此时直接返回 head。
     * 当 head 不为空时，递归地进行删除操作，然后判断 head 的节点值是否等于 val 并决定是否要删除 head
     *
     */
    public ListNode removeElementsV3(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElementsV3(head.next, val);
        return head.val == val ? head.next : head;
    }

}
