package com.ohyoung.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * @author ouyb01
 * @date 2021/11/21 18:20
 */
public class MaxTreeDepth559 {

    public static void main(String[] args) {
        MaxTreeDepth559 example = new MaxTreeDepth559();
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node root = new Node(1, Arrays.asList(node3, node2, node4));
        System.out.println(example.maxDepth(root));
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        List<Node> children = root.children;
        if (children != null) {
            for (Node child : children) {
                int childDepth = maxDepth(child);
                maxDepth = Math.max(maxDepth, childDepth);
            }
        }
        return maxDepth + 1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
