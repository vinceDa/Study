package com.ohyoung.structure.linkedlist;

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
        assert node != null : "[get(Node node)] illegal node";
        if (head == null) {
            return -1;
        }
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
        int length = length();
        if (index == length) {
            addNode(data);
            return;
        }
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        assert (index > 0 && index < length) : "addNode with illegal index: " + index;

        Node tmp = head;
        int count = 0;
        while (count != index) {
            tmp = tmp.next;
            count++;
        }
        // 找到tmp的前驱节点
        Node pre = head;
        while (tmp != pre) {
            pre = pre.next;
        }
        newNode.next = tmp;
        pre.next = newNode;
    }

    public boolean deleteNode(Node target) {
        assert head != null : "empty linked list";
        if (head == target) {
            head = head.next;
            return true;
        }
        Node tmp = head;
        while (tmp.data != target.data) {
            if (tmp.next == null) {
                return false;
            }
            tmp = tmp.next;
        }
        // 找到tmp的前驱节点
        Node pre = head;
        while (pre.next != tmp) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return true;
    }

    public boolean deleteNode(int index) {
        assert (index >= 0 && index < length()) : "deleteNode with illegal index: " + index;
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

    public Node createNode(int data) {
        return new Node(data);
    }

}
