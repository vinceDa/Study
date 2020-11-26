package com.ohyoung.structure.linkedlist;

/**
 *  实现一个单项链表
 *
 * @author ohYoung
 * @date 2020/11/25 17:04
 */
public class Singly {

    /**
     *  单链表反转
     *  链表中环的检测
     *  两个有序的链表合并
     *  删除链表倒数第 n 个结点
     *  求链表的中间结点
     */

    /**
     *  如果链表为空时，代码是否能正常工作？
     *  如果链表只包含一个结点时，代码是否能正常工作？
     *  如果链表只包含两个结点时，代码是否能正常工作？
     *  代码逻辑在处理头结点和尾结点的时候，是否能正常工作？
     */

    /**
     *  头节点
     */
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
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public void addNode(int index, int data) {
        Node newNode = new Node(data);
        if (index < 0 || index > length()) {
            System.err.println("addNode: illegal index");
            return;
        }
        if (index == 0) {
            newNode.next = head;
            head = newNode;
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
            return true;
        }
        Node tmp = head;
        while (tmp.next != target) {
            if (tmp.next == null) {
                return false;
            }
            tmp = tmp.next;
        }
        // 找到tmp的前驱节点
        Node pre = head;
        while (pre != tmp) {
            pre = pre.next;
        }
        target.next = tmp;
        pre.next = target;
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
            return true;
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

}
