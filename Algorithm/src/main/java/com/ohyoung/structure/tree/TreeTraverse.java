package com.ohyoung.structure.tree;

import com.ohyoung.structure.linkedlist.Doubly;

/**
 * @author ohYoung
 * @description 构建一颗二叉树并实现前、中、后序遍历
 * @date 2021/1/15 17:00
 **/
public class TreeTraverse {

    class Node {
        Node left;
        Node right;
        String data;

        public Node(String data) {
            this.data = data;
        }
    }

    public void init(Node head) {
        // 构建一棵二叉树
        head = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");
        Node node7 = new Node("G");
        head.left = node2;
        head.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
    }

    /**
     * 前序遍历
     */
    public void preTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preTraverse(node.left);

    }
    /**
     * 中序遍历
     */
    public void midTraverse(Node node) {

    }
    /**
     * 后序遍历
     */
    public void afterTraverse(Node node) {

    }
}
