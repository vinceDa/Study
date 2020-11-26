package com.ohyoung.structure.linkedlist;

/**
 *  实现一个双向链表
 * @author ohYoung
 * @date 2020/11/25 18:15
 */
public class Doubly {

    Node head = null;

    class Node {
        Node pre = null;
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addNode(int data) {
        Node nextNode = new Node(data);
        if (head == null) {
            head = nextNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = nextNode;
        nextNode.pre = tmp;
    }

    public void addNode(int index, int data) {
        Node newNode = new Node(data);
        if (index < 0 || index >= length()) {
            System.err.println("addNode: illegal index");
            return;
        }
        Node tmp = head;
        int count = 0;
        while (count != index) {
            tmp = tmp.next;
            count++;
        }
        // 找到tmp的前驱节点
        Node pre = head;
        while (pre.next != tmp) {
            pre = pre.next;
        }
        newNode.next = tmp;
        pre.next = newNode;
    }

    public boolean deleteNode(Node target) {
        if (head == null) {
            System.err.println("empty linked list");
            return false;
        }
        if (head == target) {
            head = head.next;
            head.pre = null;
            return true;
        }
        Node tmp = head;
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
        if (index < 0 || index >= length()) {
            System.err.println("deleteNode: illegal index");
            // 抛异常
            return false;
        }
        // 只存在一个节点的情况
        if (index == 0 && length() == 1) {
            head = null;
            return true;
        }
        int sum = 0;
        Node tmp = head;
        while (sum != index) {
            tmp = tmp.next;
            sum++;
        }
        // 如果是头节点则没有前驱节点
        if (tmp == head) {
            head = head.next;
            head.pre = null;
            return true;
        }
        tmp.pre.next = tmp.next;
        return true;
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
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        Doubly linkedList = new Doubly();
        linkedList.addNode(1);
        linkedList.addNode(3);
        linkedList.print();
        System.out.println(linkedList.deleteNode(1));
        linkedList.print();
    }

}
