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
        singly.addNode(0,1);
        System.out.println(singly.get(singly.createNode(1)));
        System.out.println(singly.get(0).data);
        System.out.println(singly.get(0));
    }

    @Test
    public void addNode() {
        Singly singly = new Singly();
        singly.addNode(0,1);
        singly.print();
        singly.addNode(1, 2);
        singly.print();
    }


    @Test
    public void deleteNode() {
        Singly singly = new Singly();
        singly.addNode(0,1);
        singly.addNode(1,2);
        singly.print();
        System.out.println(singly.deleteNode(singly.createNode(2)));;
        singly.print();
    }

    @Test
    public void deleteNodeWithIndex() {
        Singly singly = new Singly();
        singly.addNode(0,1);
        singly.print();
        System.out.println(singly.deleteNode(0));;
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

    }


}
