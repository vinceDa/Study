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

    public void print() {
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
     */
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        Node pre = null;
        while (head != null) {
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head = pre;
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
