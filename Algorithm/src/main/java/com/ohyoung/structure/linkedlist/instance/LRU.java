package com.ohyoung.structure.linkedlist.instance;

import com.ohyoung.structure.linkedlist.Singly;

/**
 * 使用单链表实现 最近最少使用LRU(Least Recently Used)策略
 *
 * @author ohYoung
 * @date 2020/11/29 16:14
 */
public class LRU {

    private Singly singly;
    private int length;

    public LRU(int length) {
        this.singly = new Singly();
        this.length = length;
    }


    public void addData(int data) {
        // 1. 如果数据在链表中存在, 将数据删除然后在链表头部插入
        int i = singly.get(singly.createNode(data));
        if (i != -1) {
            singly.deleteNode(i);
            singly.addNode(0, data);
            return;
        }
        // 2. 如果数据在链表中不存在
        if (singly.length() >= length) {
            // 2.2. 如果链表满了, 则删除尾节点然后从头部插入最新数据
            singly.deleteNode(singly.length() - 1);
        }
        // 2.1 如果链表未满, 则从头部插入数据
        singly.addNode(0, data);
    }

    public void print() {
        singly.print();
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.addData(1);
        lru.print();
        System.out.println("==========================");
        lru.addData(2);
        lru.print();
        System.out.println("==========================");
        lru.addData(3);
        lru.print();
        System.out.println("==========================");
        lru.addData(4);
        lru.print();
        System.out.println("==========================");
        lru.addData(3);
        lru.print();
        System.out.println("==========================");
        lru.addData(6);
        lru.print();
        System.out.println("==========================");
    }

}
