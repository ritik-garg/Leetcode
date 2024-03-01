/*
 * @lc app=leetcode id=1514 lang=java
 *
 * [1514] Path with Maximum Probability
 */

/*
19/19 cases passed (42 ms)
Your runtime beats 61.92 % of java submissions
Your memory usage beats 10.39 % of java submissions (59 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adjList = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; ++i) {
            adjList.get(edges[i][0]).add(new double[] {edges[i][1], succProb[i]});
            adjList.get(edges[i][1]).add(new double[] {edges[i][0], succProb[i]});
        }

        double[] dist = new double[n];
        boolean[] vis = new boolean[n];
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[1]));
        pq.offer(new double[] {start_node, 1.0});
        while (!pq.isEmpty()) {
            double[] entry = pq.poll();
            int vertex = (int)entry[0];
            vis[vertex] = true;
            if (vertex == end_node) return entry[1];
            if (dist[vertex] < entry[1]) {
                dist[vertex] = entry[1];
            }
            for (double[] edge : adjList.get(vertex)) {
                if (!vis[(int) edge[0]]) {
                    pq.offer(new double[] {edge[0], dist[vertex] * edge[1]});
                }
            }
        }
        return dist[end_node];
    }
}
// @lc code=end

