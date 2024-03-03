/*
 * @lc app=leetcode id=1976 lang=java
 *
 * [1976] Number of Ways to Arrive at Destination
 */

/*
55/55 cases passed (20 ms)
Your runtime beats 16.67 % of java submissions
Your memory usage beats 74.09 % of java submissions (49 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] adjList = createGraph(n, roads);
        return dijkstra(0, n - 1, adjList);
    }

    private int dijkstra(int src, int dst, List<int[]>[] adjList) {
        long[] time = new long[adjList.length], ways = new long[adjList.length];
        Arrays.fill(time, Long.MAX_VALUE);
        time[src] = 0;
        ways[src] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[] { src, 0 });

        while (!pq.isEmpty()) {
            long[] vertex = pq.poll();
            int v = (int) vertex[0];
            long t = vertex[1];
            if (t <= time[v]) {
                for (int[] edge : adjList[v]) {
                    if (t + edge[1] < time[edge[0]]) {
                        time[edge[0]] = t + edge[1];
                        pq.offer(new long[] { edge[0], time[edge[0]] });
                        ways[edge[0]] = ways[v];
                    } else if (t + edge[1] == time[edge[0]]) {
                        ways[edge[0]] = (ways[edge[0]] + ways[v]) % 1000000007;
                    }
                }
            }
        }
        return (int) ways[dst];
    }

    @SuppressWarnings("unchecked")
    private List<int[]>[] createGraph(int n, int[][] roads) {
        List<int[]>[] adjList = new List[n];
        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; ++i) {
            adjList[roads[i][0]].add(new int[] { roads[i][1], roads[i][2] });
            adjList[roads[i][1]].add(new int[] { roads[i][0], roads[i][2] });
        }
        return adjList;
    }
}
// @lc code=end
