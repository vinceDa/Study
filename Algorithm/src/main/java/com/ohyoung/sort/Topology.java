package com.ohyoung.sort;

import java.util.LinkedList;

/**
 * 拓朴排序解决源代码编译顺序问题
 * @author ohYoung
 * @date 2021/12/12 16:09
 */
public class Topology {
    /**
     * 顶点个数
     */
    private int v;
    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    public Topology(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * s先于t, 边s->t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    /**
     * Kahn算法
     * 贪心算法思想: 定义数据结构的时候，如果 s 需要先于 t 执行，那就添加一条 s 指向 t 的边。
     * 所以，如果某个顶点入度为 0， 也就表示，没有任何顶点必须先于这个顶点执行，那么这个顶点就可以执行了
     */
    public void topoSortByKahn() {
        // 统计每个顶点的入度
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                // i-> w
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            // 如果某个顶点入度为0, 则表示这个顶点可以执行
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer i = queue.remove();
            System.out.println("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                Integer k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    queue.add(k);
                }
            }
        }
    }

    /**
     * DFS算法实现
     */
    public void topoSortByDFS() {
        // 先构建逆邻接表, 边s->t表示s依赖于t, t先于s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        // 申请空间
        for (int i = 0; i < v; i++) {
            inverseAdj[i] = new LinkedList<>();
        }
        // 通过邻接表生成逆邻接表
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                // i -> w
                int w = adj[i].get(j);
                // w -> i
                inverseAdj[i].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        // 深度优先遍历图
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    /**
     * @param vertex 顶点
     * @param inverseAdj 逆邻接表
     * @param visited 是否已遍历
     */
    private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w]) {
                continue;
            }
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        }
        // 先把vertex这个顶点可达的所有顶点打印出来, 再打印它自己
        System.out.println("->" + vertex);
    }
}
