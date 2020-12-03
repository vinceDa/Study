package com.ohyoung.structure.queue;

/**
 * 基于链表实现队列
 *
 * @author ohYoung
 * @date 2020/11/30 11:24
 */
public class LinkedListQueue {

    private Node head;

    private Node tail;

    /**
     *  入队
     */
    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;

    }

    /**
     *  出队
     */
    public String dequeue() {
        if (head == null) {
            return null;
        }
        String res = head.data;
        head = head.next;
        return res;
    }

    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }


    private class Node{
        Node next;
        String data;

        public Node(String data) {
            this.data = data;
        }
    }
}
