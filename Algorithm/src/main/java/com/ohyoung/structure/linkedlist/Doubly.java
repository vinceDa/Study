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

    public boolean deleteNode(int index) {
        if (head == null) {
            return false;
        }
        int sum = 0;
        Node tmp = head;
        while (sum != index) {
            if (tmp.next == null) {
                return false;
            }
            tmp = tmp.next;
            sum++;
        }
        tmp.pre.next = tmp.next;
        return true;
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
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.addNode(7);
        linkedList.print();
        System.out.println(linkedList.deleteNode(2));
        linkedList.print();
    }

}
