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

    /**
     * �ж��Ƿ����
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
     * ɾ��������N���ڵ�
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
        singly.print();
        singly.deleteReciprocalNode(1);
        singly.print();
    }

    /**
     * �ж������Ƿ�ػ�
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
     * �ϲ�������������
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
        Singly.Node s = singly.head;
        Singly.Node a = another.head;
        Singly other = new Singly();
        while (s != null && a != null) {
            if (s.data <= a.data) {
                Singly.Node tmp = s;
                s = s.next;
                tmp.next = null;
                other.insertTail(tmp);
            } else {
                Singly.Node tmp = a;
                a = a.next;
                tmp.next = null;
                other.insertTail(tmp);
            }
        }
        if (s != null) {
            other.insertTail(s);
        }
        if (a != null) {
            other.insertTail(a);
        }
        other.print();
    }

}
