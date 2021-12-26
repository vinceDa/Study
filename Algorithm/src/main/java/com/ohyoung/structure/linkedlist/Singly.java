package com.ohyoung.structure.linkedlist;

import java.util.Arrays;

/**
 *  实现一个单项链表
 *
 * @author ohYoung
 * @date 2020/11/25 17:04
 */
public class Singly {

    /**
     *  头节点
     */
    Node head = null;

    public class Node {
        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }

    }

    /**
     *  根据下标获取节点
     */
    public Node getByIndex(int targetIndex) {
        assert (targetIndex >= 0 && targetIndex < length()) : "[query(int index)] illegal index: " + targetIndex;
        int index = 0;
        Node tmp = head;
        while (index != targetIndex) {
            tmp = tmp.next;
            ++index;
        }
        return tmp;
    }

    /**
     *  根据节点查找其下标
     */
    public int getByValue(int value) {
        if (head == null) {
            return -1;
        }
        Node node = new Node(value);
        int index = 0;
        Node tmp = head;
        while (tmp.data != node.data) {
            if (tmp.next == null) {
                return -1;
            }
            tmp = tmp.next;
            ++index;
        }
        return index;
    }

    public void insertHead(int data) {
        Node newNode = new Node(data);
        this.insertHead(newNode);
    }

    public void insertHead(Node newNode) {
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertTail(int data) {
        Node newNode = new Node(data);
        this.insertTail(newNode);
    }

    public void insertTail(Node newNode) {
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public void insertAfter(Node after, int data) {
        if (after == null) {
            return ;
        }
        Node newNode = new Node(data);
        newNode.next = after.next;
        after.next = newNode;
    }

    public void insertBefore(Node before, int data) {
        if (before == null) {
            return ;
        }
        Node newNode = new Node(data);
        if (head == before) {
            this.insertHead(newNode);
            return;
        }
        Node tmp = head;
        while (tmp != null && tmp.next != before) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            return;
        }
        newNode.next = before;
        tmp.next = newNode;

    }


    public void deleteByNode(Node target) {
        if (head == null || target == null) {
            return ;
        }
        if (head == target) {
            head = head.next;
            return ;
        }
        // 找到target的前驱节点
        Node pre = head;
        while (pre != null && pre.next != target) {
            pre = pre.next;
        }
        if (pre == null) {
            return;
        }
        pre.next = pre.next.next;
    }

    public void deleteByValue(int value) {
        Node tmp = head;
        while (tmp != null && tmp.next.data != value) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            return ;
        }
        if (tmp == head) {
            head = head.next;
            return;
        }
        // 找到tmp的前驱节点
        Node pre = head;
        while (pre != null && pre.next != tmp) {
            pre = pre.next;
        }
        if (pre == null) {
            return;
        }
        pre.next = pre.next.next;
    }

    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    public void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void printAll() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public Node createNode(int data) {
        return new Node(data);
    }

    /**
     *  单链表反转, 推荐
     *  例图
     *  1->3->6->5
     *  反转过程
     *  1: null<-1 3->6->5   pre=null
     *  2: null<-1<-3 6->5   pre=1
     *  3: null<-1<-3<-6 5   pre=3
     *  4: null<-1<-3<-6<-5  pre=6
     */
    public void reverse() {
        if (head == null || head.next == null) {
            return ;
        }
        Node pre = null;
        while (head != null) {
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        // 反转完毕后, 头节点就是pre
        head = pre;
    }

    /**
     *  带节点的单链表反转, 推荐
     */
    public Node reverseWithNode(Node node) {
        if (node == null || node.next == null) {
            return null;
        }
        Node pre = null;
        while (node != null) {
            Node next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    /**
     *  判断是否为回文
     */
    public boolean isPalindrome() {
        Node midNode = getMidNode();
        Node left = head;
        Node right = reverseWithNode(midNode);
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    /**
     * 判断链表是否为环
     *  定义快慢两个指针, fast每次走2步, slow每次走1步
     *  1. 如果fast落后slow 1步, 那么下一步fast正好追上slow
     *  2. 如果fast落后slow 2步, 那么下一步fast将落后slow 1步, 属于情况1, 所以fast必定会和slow相遇
     *  因为fast=2 * slow, 所以相遇的时候slow正好绕了1圈(如果取非2倍的速度, 也会相遇但是slow可能会多绕几圈)
     */
    public boolean isLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 合并两个有序链表
     */
    public Node mergeOrderlyLinked(Node n1, Node n2) {
        Node merge = new Node(0);
        Node tmp = merge;
        while (n1 != null && n2 != null) {
            if (n1.data <= n2.data) {
                merge.next = n1;
                n1 = n1.next;
            } else {
                merge.next = n2;
                n2 = n2.next;
            }
            merge = merge.next;
        }
        if (n1 != null) {
            merge.next = n1;
        }
        if (n2 != null) {
            merge.next = n2;
        }
        return tmp.next;
    }

    /**
     *  删除倒数第N个节点
     *  定义快慢两个指针, 快指针先走N+1步, 然后快慢指针一起走, 当快指针走到尾部的时候, 慢指针所处的位置就是第N-1个节点
     */
    public void deleteReciprocalNode(int n) {
        if (head == null) {
            return;
        }
        Node slow = head;
        Node right = head;
        for (int i = 0; i <= n; i++) {
            if (right != null) {
                right = right.next;
            } else {
                // N等于链表长度, 说明是要删除第一个节点
                head = head.next;
                return;
            }
        }
        while (right != null) {
            right = right.next;
            slow = slow.next;
        }
        if (slow != null) {
            slow.next = slow.next.next;
        }
    }

    private Node getMidNode() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 链表为奇数
        if (fast != null) {
            slow = slow.next;
        }
        return slow;
    }

    /**
     *  单链表反转, 数组实现, 空间复杂度为O(n)
     */
    public void reverseByArray() {
        Node[] nodes = new Node[length()];
        int index = 0;
        Node tmp = head;
        while (tmp != null) {
            nodes[index++] = tmp;
            tmp = tmp.next;
        }
        int endIndex = nodes.length - 1;
        for (int i = endIndex; i > 0; i--) {
            Node node = nodes[i];
            node.next = nodes[i - 1];
        }
        nodes[0].next = null;
        head = nodes[endIndex];
    }

}
