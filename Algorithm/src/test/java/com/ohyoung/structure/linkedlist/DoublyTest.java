package com.ohyoung.structure.linkedlist;


import org.junit.jupiter.api.Test;

/**
 *  双向链表测试用例
 *  条件:
 *      如果链表为空时，代码是否能正常工作？
 *      如果链表只包含一个结点时，代码是否能正常工作？
 *      如果链表只包含两个结点时，代码是否能正常工作？
 *      代码逻辑在处理头结点和尾结点的时候，是否能正常工作？
 * @author ohYoung
 * @date 2020/11/26 13:49
 */
public class DoublyTest {

    @Test
    public void addNode() {
        Doubly Doubly = new Doubly();
        Doubly.addNode(0,1);
        Doubly.print();
        Doubly.addNode(1, 2);
        Doubly.print();
    }


    @Test
    public void deleteNode() {
        Doubly Doubly = new Doubly();
        Doubly.addNode(0,1);
        Doubly.addNode(1,2);
        Doubly.print();
        Doubly.Node node = Doubly.createNode(2);
        node.pre = Doubly.createNode(1);
        System.out.println(Doubly.deleteNode(node));
        Doubly.print();
    }

    @Test
    public void deleteNodeWithIndex() {
        Doubly Doubly = new Doubly();
        Doubly.addNode(0,1);
        Doubly.print();
        System.out.println(Doubly.deleteNode(1));;
        Doubly.print();
    }

}
