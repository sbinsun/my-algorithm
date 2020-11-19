package com.sbinjun.support.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有向图
 * 拓扑排序
 */
public class Graph {

    private int v;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void add(Integer s, Integer t) {
        // 有向图
        adj[s].add(t);
    }

    // Kahn 算法
    public void kahn() {
        // 记录每个顶点的入度
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                inDegree[adj[i].get(j)] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer p = queue.poll();
            LinkedList<Integer> list = adj[p];
            if (!list.isEmpty()) {
                for (Integer e : list) {
                    inDegree[e]--;
                    if (inDegree[e] <= 0) {
                        queue.add(e);
                    }
                }
            }
            System.out.print(p + "->");
        }
    }


    public void topoSortByDFS() {
        // 先构建逆邻接表，边 s->t 表示，s 依赖于 t，t 先于 s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) { // 申请空间
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; ++i) { // 通过邻接表生成逆邻接表
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inverseAdj[w].add(i); // w->i
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) { // 深度优先遍历图
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }
//}、

    private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        } // 先把 vertex 这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print("->" + vertex);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        // 2 > 3 > 4 >5

        graph.add(2,3);
        graph.add(4,3);
        graph.add(4,5);
        graph.kahn();
        graph.topoSortByDFS();
    }
}
