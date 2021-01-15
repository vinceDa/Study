package com.ohyoung.structure.tree;

/**
 * @author ohYoung
 * @description 构建一颗二叉树并实现前、中、后序遍历
 * @date 2021/1/15 17:00
 **/
public class TreeTraverse {

    public static void main(String[] args) {
        TreeTraverse treeTraverse = new TreeTraverse();
        Node head = treeTraverse.init();
        preTraverse(head);
        System.out.println();
        midTraverse(head);
        System.out.println();
        afterTraverse(head);
    }

    static class Node {
        Node left;
        Node right;
        String data;

        public Node() {
        }

        public Node(String data) {
            this.data = data;
        }
    }

    public Node init() {
        // 构建一棵二叉树
        Node head = new Node("A");
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
        return head;
    }

    /**
     * 前序遍历
     */
    public static void preTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preTraverse(node.left);
        preTraverse(node.right);

    }
    /**
     * 中序遍历
     */
    public static  void midTraverse(Node node) {
        if (node == null) {
            return;
        }
        midTraverse(node.left);
        System.out.print(node.data);
        midTraverse(node.right);
    }
    /**
     * 后序遍历
     */
    public static void afterTraverse(Node node) {
        if (node == null) {
            return;
        }
        afterTraverse(node.left);
        afterTraverse(node.right);
        System.out.print(node.data);
    }
}
