package com.ohyoung.structure.linkedlist;

import org.junit.Test;

/**
 *  ���������������
 *  ����:
 *      �������Ϊ��ʱ�������Ƿ�������������
 *      �������ֻ����һ�����ʱ�������Ƿ�������������
 *      �������ֻ�����������ʱ�������Ƿ�������������
 *      �����߼��ڴ���ͷ����β����ʱ���Ƿ�������������
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
     * ������ת
     * �����л��ļ��
     * �������������ϲ�
     * ɾ���������� n �����
     * ��������м���
     */
    @Test
    public void reverse() {

    }


}
