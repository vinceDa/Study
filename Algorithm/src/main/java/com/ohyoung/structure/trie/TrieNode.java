package com.ohyoung.structure.trie;

/**
 * @author ohYoung
 * @date 2021/10/7 10:55
 */
public class TrieNode {

    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;

    public TrieNode(char data) {
        this.data = data;
    }
}
