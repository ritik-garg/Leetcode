/*
 * @lc app=leetcode id=1786 lang=java
 *
 * [1786] Number of Restricted Paths From First to Last Node
 */

/*
77/77 cases passed (84 ms)
Your runtime beats 47.83 % of java submissions
Your memory usage beats 51.3 % of java submissions (73.9 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    private final static int MODULO = 1000000007;

    public int countRestrictedPaths(int n, int[][] edges) {
        List<int[]>[] adjList = createGraph(n, edges);
        int[] dist = dijkstra(n, adjList);
        return dfs(1, n, adjList, dist, new Integer[n + 1]);
    }

    @SuppressWarnings("unchecked")
    private List<int[]>[] createGraph(int n, int[][] edges) {
        List<int[]>[] adjList = new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjList[edge[0]].add(new int[] { edge[1], edge[2] });
            adjList[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        return adjList;
    }

    private int[] dijkstra(int n, List<int[]>[] adjList) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] vis = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { n, 0 });
        while (!pq.isEmpty()) {
            int[] vertex = pq.poll();
            vis[vertex[0]] = true;
            if (dist[vertex[0]] > vertex[1]) {
                dist[vertex[0]] = vertex[1];
                for (int[] edge : adjList[vertex[0]]) {
                    if (!vis[edge[0]]) {
                        pq.offer(new int[] { edge[0], vertex[1] + edge[1] });
                    }
                }
            }
        }
        return dist;
    }

    private int dfs(int start, int end, List<int[]>[] adjList, int[] dist, Integer[] mem) {
        if (mem[start] != null)
            return mem[start];
        if (start == end) {
            return 1;
        }
        int result = 0;
        for (int[] edge : adjList[start]) {
            if (dist[edge[0]] < dist[start]) {
                result = (result + dfs(edge[0], end, adjList, dist, mem)) % MODULO;
            }
        }
        mem[start] = result;
        return mem[start];
    }
}
// @lc code=end
