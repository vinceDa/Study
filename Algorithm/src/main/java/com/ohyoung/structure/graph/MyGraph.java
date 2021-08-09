package com.ohyoung.structure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ohYoung
 * @date 2021/7/19 23:18
 */
public class MyGraph {

    private static int v = 8;

    private static LinkedList<Integer>[] adj;

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
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
        bfs(0, 7);
        System.out.println();
        dfs(0, 7);
    }

    private static boolean found = true;

    private static void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        recurDfs(s, t, prev, visited);
        print(prev, s, t);
    }

    private static void recurDfs(int w, int t, int[] prev, boolean[] visited) {
        if (found) {
            return;
        }
        // 深度优先算法是从一个顶点找到不能找为止, 所以这里可以直接将顶点已访问置为true
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, prev, visited);
            }
        }

    }

    private static void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // 记录顶点是否已被访问
        boolean[] visited = new boolean[v];
        // 存储已被访问但相邻顶点还没被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        // 记录搜索路径
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
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
     * 递归打印s->t的路径
     * prev[w]存储的是搜索路径,表示顶点w是从前一个顶点搜索过来的, 例如: prev[3] = 2, 表示顶点3是从顶点2访问过来的
     * 所以prev[w]存储的是一个反向的路径, 这里需要通过递归正向打印路径
     */
    private static void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }



    public MyGraph(){
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
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



}
