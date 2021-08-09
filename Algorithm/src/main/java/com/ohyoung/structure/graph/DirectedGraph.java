package com.ohyoung.structure.graph;

import java.util.LinkedList;

/**
 * 有向图: 微博
 */
public class DirectedGraph {

    private int v;
    private LinkedList<LinkedList<Integer>> adj;

    public DirectedGraph(int v) {
        this.v = v;
        adj = new LinkedList<>();
    }

    public void addUser() {

    }

}
