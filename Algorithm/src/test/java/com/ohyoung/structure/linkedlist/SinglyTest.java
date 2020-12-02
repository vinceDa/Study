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
        singly.print();
    }


    @Test
    public void deleteNode() {
        Singly singly = new Singly();
        singly.deleteByValue(1);
        singly.deleteByValue(2);
        singly.print();
        singly.deleteByValue(2);
        singly.print();
    }

    @Test
    public void deleteNodeWithIndex() {
        Singly singly = new Singly();
        singly.insertTail(1);
        singly.print();
        singly.deleteByValue(0);
        singly.print();
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
        singly.print();
        singly.reverse();
        singly.print();
    }

}
