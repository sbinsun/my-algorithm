package com.sbinjun.support.graph;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * 邻接表
 * 无向图
 */
public class UndirectGraph {

    private int v; //顶点个数
    private LinkedList<Integer>[] adj;

    public UndirectGraph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // 无向图，一条边存两次
    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    // 搜索一条从 s 到 t 的路径
    // 深度优先搜索
    public void bfs(int s,int t){
        if (s == t) return;

        // 记录已经访问过的顶点
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // 记录已经访问过，但是与其相连的顶点没访问的顶点
        Queue<Integer> queue = new LinkedList();
        queue.add(s);

        // 记录节点访问路径
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (!queue.isEmpty()) {
            Integer w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                Integer p = adj[w].get(i);
                if (!visited[p]) {
                    prev[p] = w;
                    visited[p] = true;
//                    if (p == t) {
//                        print(prev,s,t);
//                        return;
//                    }
                    if (p == t) break;
                    queue.add(p);
                }
            }
        }

        print(prev,s,t);
    }

    private boolean found = false;

    // 深度优先
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0;i < v; i++) {
            prev[i] = -1;
        }

        // 搜索
        recurDfs(s, t, visited,prev);

        // 打印
        print(prev,s,t);
    }

    private void recurDfs(int w, int t, boolean[] visited,int[] prev) {
        if (found) return;

        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }

        for (int i = 0; i < adj[w].size(); i++) {
            Integer p = adj[w].get(i);
            if (!visited[p]) {
                prev[p] = w;
                recurDfs(p,t,visited,prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (s != t) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }


    public static void main(String[] args) {
        UndirectGraph graph = new UndirectGraph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
//        graph.bfs(0,6);

        graph.dfs(0,6);
    }
}


