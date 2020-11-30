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


    /**
     *  根据下标获取节点
     */
    public Node get(int targetIndex) {
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
    public int get(Node node) {
        assert head != null : "empty linked list";
        assert node != null : "[get(Node node)] illegal node";
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
        if (index == length()) {
            addNode(data);
            return;
        }
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        assert (index > 0 && index < length()) : "addNode illegal index: " + index;
        Node tmp = head;
        int count = 0;
        while (count != index) {
            tmp = tmp.next;
            count++;
        }
        newNode.next = tmp;
        newNode.pre = tmp.pre;
        tmp.pre = newNode;
        tmp.pre.next = newNode;
    }

    public boolean deleteNode(Node target) {
        assert head != null : "empty linked list";

        if (head == target) {
            head = head.next;
            head.pre = null;
            return true;
        }
        Node tmp = head;
        while (tmp.data != target.data) {
            if (tmp.next == null) {
                return false;
            }
            tmp = tmp.next;
        }
        tmp.pre.next = tmp.next;
        tmp.next.pre = tmp.pre;
        return true;
    }

    public boolean deleteNode(int index) {
        assert (index >= 0 && index < length()) : "deleteNode illegal index: " + index;

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
        tmp.next.pre = tmp.pre;
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

    public Node createNode(int data) {
        return new Node(data);
    }

}
