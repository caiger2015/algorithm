package com.cg.algorithm.graph;

import java.util.Stack;

public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;

    public void DepthFirstSearch(Graph graph) {
        marked = new boolean[graph.getV()];
        edgeTo = new int[graph.getV()];
        dfs(graph, 0);//0当起点
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (Integer w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public Stack<Integer> getPathTo(int v) {
        if (!marked[v]) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        while (v != 0) {
            path.push(v);
            v = edgeTo[v];
        }
        path.push(0);
        return path;
    }

}
