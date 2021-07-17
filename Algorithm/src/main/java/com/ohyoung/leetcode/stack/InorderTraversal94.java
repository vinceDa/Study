package com.ohyoung.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历
 * @author ohYoung
 * @date 2021/7/8 23:13
 */
public class InorderTraversal94 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(2);
        head.right.left = new TreeNode(3);
        List<Integer> integers = inorderTraversal(head);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // 说明左子树已经访问完了
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                // 当前节点为最左节点，直接加入数组
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }


  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
