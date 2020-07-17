package com.cg.algorithm.graph;


import java.util.LinkedList;

public class Digraph { // 无向图
    private int v; // 顶点的个数
    private LinkedList<Integer>[] adj; // 邻接表

    public Digraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 有向图一条边存两次，添加一条从s->t的边
        adj[s].add(t);
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}