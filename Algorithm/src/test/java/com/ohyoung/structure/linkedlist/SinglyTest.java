package com.ohyoung.structure.linkedlist;

import org.junit.Test;

/**
 *  单向链表测试用例
 *  条件:
 *      如果链表为空时，代码是否能正常工作？
 *      如果链表只包含一个结点时，代码是否能正常工作？
 *      如果链表只包含两个结点时，代码是否能正常工作？
 *      代码逻辑在处理头结点和尾结点的时候，是否能正常工作？
 * @author ohYoung
 * @date 2020/11/26 13:49
 */
public class SinglyTest {

    @Test
    public void get() {
        Singly singly = new Singly();
        singly.insertTail(1);
        System.out.println(singly.getByValue(1));
        System.out.println(singly.getByIndex(0).data);
        System.out.println(singly.getByIndex(0));
    }

    @Test
    public void insertTail() {
        Singly singly = new Singly();
        singly.insertTail(1);
        singly.insertTail(2);
        singly.insertTail(3);
        singly.printAll();
    }


    @Test
    public void deleteNode() {
        Singly singly = new Singly();
        singly.deleteByValue(1);
        singly.deleteByValue(2);
        singly.printAll();
        singly.deleteByValue(2);
        singly.printAll();
    }

    @Test
    public void deleteNodeWithIndex() {
        Singly singly = new Singly();
        singly.insertTail(1);
        singly.printAll();
        singly.deleteByValue(0);
        singly.printAll();
    }

    /**
     * 单链表反转
     * 链表中环的检测
     * 两个有序的链表合并
     * 删除链表倒数第 n 个结点
     * 求链表的中间结点
     */
    @Test
    public void reverse() {
        Singly singly = new Singly();
        singly.insertTail(1);
        singly.insertTail(2);
        singly.insertTail(3);
        singly.insertTail(4);
        singly.insertTail(5);
        singly.insertTail(6);
        singly.printAll();
        singly.reverse();
        singly.printAll();
    }

    /**
     * 判断是否回文
     */
    @Test
    public void isPalindrome() {
        Singly singly = new Singly();
        singly.insertTail(1);
        singly.insertTail(2);
        singly.insertTail(3);
        singly.insertTail(2);
        singly.insertTail(1);
        // singly.insertTail(6);
        System.out.println(singly.isPalindrome());
    }

    /**
     * 删除倒数第N个节点
     */
    @Test
    public void deleteReciprocalNode() {
        Singly singly = new Singly();
        singly.insertTail(1);
        singly.insertTail(2);
        singly.insertTail(3);
        singly.insertTail(2);
        singly.insertTail(1);
        singly.insertTail(1);
        singly.printAll();
        singly.deleteReciprocalNode(1);
        singly.printAll();
    }

    /**
     * 判断链表是否回环
     */
    @Test
    public void isLoop() {
        Singly singly = new Singly();
        singly.insertTail(1);
        singly.insertTail(2);
        singly.insertTail(3);
        singly.insertTail(2);
        singly.insertTail(1);
        singly.insertTail(1);
        Singly.Node node = singly.createNode(100);
        singly.insertTail(node);
        node.next = singly.head;
        System.out.println(singly.isLoop());
    }

    /**
     * 合并两个有序链表
     */
    @Test
    public void mergeOrderlyLinked() {
        Singly singly = new Singly();
        singly.insertTail(1);
        singly.insertTail(2);
        singly.insertTail(3);
        singly.insertTail(5);
        singly.insertTail(7);
        singly.insertTail(8);
        Singly another = new Singly();
        another.insertTail(2);
        another.insertTail(4);
        another.insertTail(5);
        another.insertTail(6);
        another.insertTail(8);
        another.insertTail(9);
        another.insertTail(10);
        Singly.Node node = singly.mergeOrderlyLinked(singly.head, another.head);
        singly.print(node);
    }

}
