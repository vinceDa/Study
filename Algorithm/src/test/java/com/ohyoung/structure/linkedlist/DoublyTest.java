package com.ohyoung.structure.linkedlist;

import org.junit.Test;

/**
 *  ˫�������������
 *  ����:
 *      �������Ϊ��ʱ�������Ƿ�������������
 *      �������ֻ����һ�����ʱ�������Ƿ�������������
 *      �������ֻ�����������ʱ�������Ƿ�������������
 *      �����߼��ڴ���ͷ����β����ʱ���Ƿ�������������
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
