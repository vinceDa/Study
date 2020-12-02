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
     * ������ת
     * �����л��ļ��
     * �������������ϲ�
     * ɾ���������� n �����
     * ��������м���
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
