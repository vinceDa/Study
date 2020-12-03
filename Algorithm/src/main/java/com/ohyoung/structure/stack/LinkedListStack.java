package com.ohyoung.structure.stack;

/**
 * 用链表实现栈
 *
 * @author ohYoung
 * @date 2020/11/30 8:52
 */
public class LinkedListStack {

    private Node top = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            return -1;
        }
        int res = top.data;
        top = top.next;
        return res;
    }

    public void print() {
        Node tmp = top;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }


    public class Node{
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

}
