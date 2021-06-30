package com.ohyoung.leetcode.linkedlist;

/**
 * 206. 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 * @author ohYoung
 * @date 2021/6/28 22:40
 */
public class RevertSpecifyPosition92 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode resNode = reverseSpecifyPosition(node, 2,4);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    /**
     *
     */
    private static ListNode reverseSpecifyPosition(ListNode head, int left, int right) {
        if (head == null || left < 1 || right < 1 || right > 500 || left > right) {
            return null;
        }
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // pre节点走left - 1步，来到left的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // rightNode走right-left+1步，来到right节点，记录这个节点是为了后续pre指向它（反转后它是头节点）
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 将中间部分截取出来然后反转
        ListNode leftNode = pre.next;
        ListNode behind = rightNode.next;
        // 切断前后链接
        pre.next = null;
        rightNode.next = null;
        // 切断后leftNode的范围为pre.next到rightNode
        // 用206题的方式反转中间链表
        reverse(leftNode);
        // 拼接【前、反转、后】三个部分的链表
        pre.next = rightNode;
        leftNode.next = behind;
        return dummyNode.next;
    }

    /**
     * 递归删除
     */
    // TODO
    private static ListNode removeDuplicateNodeByRecursion(ListNode head) {
        return null;
    }

    private static ListNode reverse(ListNode head) {
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
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
