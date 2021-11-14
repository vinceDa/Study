package com.ohyoung.structure.trie;

/**
 * @author ohYoung
 * @date 2021/10/7 11:10
 */
public class Trie {

    /**
     * 存储无意义字符, 根节点
     */
    private TrieNode root = new TrieNode('/');

    /**
     * 往Trie树中插入一个字符串
     */
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        // 表示trie树中的红色叶子结点
        p.isEndingChar = true;
    }

    /**
     * 在Trie树中查找一个字符串
     */
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            if (p.children == null) {
                return false;
            }
            int index = pattern[i] - 'a';
            p = p.children[index];
        }
        return p.isEndingChar;
    }

}
