package com.ohyoung.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]
 *
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 10^5 次 get 和 put
 *
 * <a href="https://leetcode-cn.com/problems/lru-cache/"></a>
 * @author vince 2023/8/21 11:50
 */
public class LRUCache146 {
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args) {
        LRUCache146 lRUCache = new LRUCache146(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4

        System.out.println("=======================");

        LRUCache146 lRUCache2 = new LRUCache146(2);
        lRUCache2.put(1, 0);
        lRUCache2.put(2, 2);
        System.out.println(lRUCache2.get(1));
        lRUCache2.put(3, 3);
        System.out.println(lRUCache2.get(2));
        lRUCache2.put(4, 4);
        System.out.println(lRUCache2.get(1));
        System.out.println(lRUCache2.get(3));
        System.out.println(lRUCache2.get(4));

        System.out.println("=======================");

        LRUCache146 lRUCache3 = new LRUCache146(2);
        lRUCache3.put(2, 1);
        lRUCache3.put(1, 1);
        System.out.println(lRUCache3.get(2));
        lRUCache3.put(4, 1);
        System.out.println(lRUCache3.get(1));
        System.out.println(lRUCache3.get(2));

        System.out.println("=======================");

        LRUCache146 lRUCache4 = new LRUCache146(2);
        System.out.println(lRUCache4.get(2));
        lRUCache4.put(2, 6);
        System.out.println(lRUCache4.get(1));
        lRUCache4.put(1, 5);
        lRUCache4.put(1, 2);
        System.out.println(lRUCache4.get(1));
        System.out.println(lRUCache4.get(2));
    }

    private int size = 0;

    private final int capacity;

    private final Map<Integer, Node> map;

    private final Node dummyHead;

    private final Node dummyTail;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new Node(-1, 0);
        dummyTail = new Node(-1, 0);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        // 已存在的数据直接挪到头部
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }

        // 容量未满，直接在头部添加元素
        if (size < capacity) {
            addFirst(key, value);
            return;
        }

        // 删除末尾元素
        map.remove(dummyTail.pre.key);
        dummyTail.pre.pre.next = dummyTail;
        dummyTail.pre = dummyTail.pre.pre;
        size--;
        // 在头部新增元素
        addFirst(key, value);
    }

    private void addFirst(int key, int value) {
        Node node = new Node(key, value);
        node.next = dummyHead.next;
        node.pre = dummyHead;
        dummyHead.next.pre = node;
        dummyHead.next = node;
        map.put(key, node);
        size++;
    }

    private void moveToHead(Node node) {
        // 更新node节点的前后节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
        // node节点移动到头部
        node.pre = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.pre = node;
        dummyHead.next = node;
    }

    private class Node {
        int key;
        int value;

        Node pre;

        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}
