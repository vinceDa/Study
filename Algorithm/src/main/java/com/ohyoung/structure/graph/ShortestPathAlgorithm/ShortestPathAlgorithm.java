package com.ohyoung.structure.graph.ShortestPathAlgorithm;

import java.util.LinkedList;

/**
 * 常用的最短路径算法
 * @author ouyb01
 * @date 2021/12/13 12:47
 */
public class ShortestPathAlgorithm {

    /**
     * 有向有权图的邻接表表示
     */
    class Graph {
        // 邻接表
        private LinkedList<Edge>[] adj;
        // 顶点个数
        private int v;

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                this.adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t, int w) {
            this.adj[s].add(new Edge(s, t, w));
        }


        private class Edge {
            // 边的起始顶点编号
            private int sid;
            // 边的终止顶点编号
            private int tid;
            // 权重
            private int w;

            public Edge(int sid, int tid, int w) {
                this.sid = sid;
                this.tid = tid;
                this.w = w;
            }
        }

        /**
         * 用于实现dijkastra
         */
        private class Vertex {
            // 顶点编号ID
            private int id;
            // 从起始顶点到这个顶点的距离
            private int dist;

            public Vertex(int id, int dist) {
                this.id = id;
                this.dist = dist;
            }
        }

        /**
         * 因为Java提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
         */
        private class  PriorityQueue {
            // 根据vertex.dist构建小顶堆
            private Vertex[] nodes;
            private int count;

            public PriorityQueue(int v) {
                this.nodes = new Vertex[v + 1];
                this.count = v;
            }

            public Vertex poll() {
                return null;
            }

            public void add(Vertex vertex) {

            }

            public void update(Vertex vertex) {

            }

            public boolean isEmpty() {
                return true;
            }

        }

        /**
         * 从顶点s到顶点t的最短路径
         */
        public void dijkstra(int s, int t) {
            // 用来还原最短路径
            int[] predecessor = new int[this.v];
            Vertex[] vertexes = new Vertex[this.v];
            for (int i = 0; i < this.v; i++) {
                vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
            }
            // 小顶堆
            PriorityQueue queue = new PriorityQueue(this.v);
            // 标记是否进入过队列
            boolean[] inqueue = new boolean[this.v];
            vertexes[s].dist = 0;
            queue.add(vertexes[s]);
            inqueue[s] = true;
            while (!queue.isEmpty()) {
                // 取堆顶元素并删除
                Vertex minVertex= queue.poll();
                // 最短路径产生了
                if (minVertex.id == t) break;
                for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                    // 取出一条minVetex相连的边
                    Edge e = adj[minVertex.id].get(i);
                    // minVertex-->nextVertex
                    Vertex nextVertex = vertexes[e.tid];
                    // 更新next的dist
                    if (minVertex.dist + e.w < nextVertex.dist) {
                        nextVertex.dist = minVertex.dist + e.w;
                        predecessor[nextVertex.id] = minVertex.id;
                        if (inqueue[nextVertex.id] == true) {
                            // 更新队列中的dist值
                            queue.update(nextVertex);
                        } else {
                            queue.add(nextVertex);
                            inqueue[nextVertex.id] = true;
                        }
                    }
                }
            }
            // 输出最短路径
            System.out.print(s);
            print(s, t, predecessor);
        }

    }
    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }
}
