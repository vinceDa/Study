package com.ohyoung.structure.linkedlist;

import org.junit.Test;

/**
 *  单向链表测试用例
 * @author ohYoung
 * @date 2020/11/26 13:49
 */
public class SinglyTest {

    @Test
    public void addNode() {
        Singly singly = new Singly();
        singly.addNode(0,1);
        singly.print();
        singly.addNode(1, 2);
        singly.print();
    }



}
