package com.ohyoung.structure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 * @author ohYoung
 * @date 2021/7/14 22:14
 */
public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
//        bfs(0, 7);
        dfs(0, 7);
//        cusBfs(0, 7);
    }

    /**
     * 顶点的个数
     */
    private static int v = 8;

    /**
     * 邻接表
     */
    private static LinkedList<Integer>[] adj;

    public Graph() {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图一条边存两次
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public static void cusBfs(int s, int t) {
        if (s == t) {
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] prev = new int[v];
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * BFS: 广度优先搜索
     */
    public static void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // 记录已经访问过的顶点，避免重复访问
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // 存储已经被访问、但相连顶点还没被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // 记录搜索路径
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * 是否已找到终止顶点
     */
    private static boolean found = false;
    /**
     * dfs：深度优先算法
     */
    public static void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
//        recurDfs(s, t, visited, prev);
        cusRecurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private static void cusRecurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                visited[q] = true;
                prev[q] = w;
                cusRecurDfs(q, t, visited, prev);
            }
        }
    }

    private static void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    private static void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }
}
