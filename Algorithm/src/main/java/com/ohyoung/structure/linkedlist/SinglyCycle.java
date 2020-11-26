package com.ohyoung.structure.linkedlist;

/**
 * 单向循环链表
 *
 * @author ohYoung
 * @date 2020/11/25 18:32
 */
public class SinglyCycle {

    Node head = null;

    class Node {
        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node tmp = head;
        while (tmp.next != head) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
        newNode.next = head;
    }

    public boolean deleteNode(Node target) {
        if (head == null) {
            return false;
        }
        Node tmp = head;
        if (head == target) {
            head = head.next;
            return true;
        }
        while (tmp.next != target) {
            if (tmp.next == null) {
                return false;
            }
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return true;
    }

    public boolean deleteNode(int index) {
        if (index < 1 && index > length()) {
            // 抛异常
            return false;
        }
        if (head == null) {
            return false;
        }
        int sum = 0;
        Node tmp = head;
        while (sum != index) {
            tmp = tmp.next;
            sum++;
        }
        // 找到tmp的前驱节点
        Node pre = head;
        while (pre.next != tmp) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return true;
    }

    public int length() {
        int length = 0;
        if (head == null) {
            return length;
        }
        Node tmp = head;
        while (tmp.next != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

}
