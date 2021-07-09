package com.ohyoung.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 *
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *      val：一个表示 Node.val 的整数。
 *      random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *      你的代码只接受原链表的头节点 head 作为传入参数。
 * @author ohYoung
 * @date 2021/7/1 22:25
 */
public class CopyRandomList138 {

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        Node node = copyRandomList(head);
        System.out.println(node);

    }

    /**
     *  1、遍历链表，拷贝每一个节点并放在原节点的next形成一个新旧交替的新链表
     *  2、遍历新链表，假设原始节点为A，新节点为A'
     *      归纳random节点: A'.random = A.random.next
     *      归纳next节点: A.next = A'.next    A'.next = B.next
     */
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node merge = head;
        while (merge != null) {
            Node node = new Node(merge.val);
            node.next = merge.next;
            merge.next = node;
            merge = node.next;
        }
        // 此时head为新旧交替的链表，merge循环后为null，所以令merge=head并开始处理random
        merge = head;
        while (merge != null) {
            merge.next.random = (merge.random == null) ? null : merge.random.next;
            merge = merge.next.next;
        }
        // 处理next节点
        // A->B->C
        Node mergeOld = head;
        // A'->B'->C'
        Node mergeNew = head.next;
        Node headOld = head.next;
        while (mergeOld != null) {
            mergeOld.next = mergeOld.next.next;
            mergeNew.next = (mergeNew.next != null) ? mergeNew.next.next : null;
            mergeOld = mergeOld.next;
            mergeNew = mergeNew.next;
        }
        return headOld;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
