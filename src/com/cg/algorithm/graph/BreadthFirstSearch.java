package com.cg.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private Queue<Integer> queue;

    public void BreadthFirstSearch(Graph graph) {
        marked = new boolean[graph.getV()];
        edgeTo = new int[graph.getV()];
        queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (Integer w : graph.adj(v)) {
                if (!marked[w]) {
                    marked[v] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
    }
}
