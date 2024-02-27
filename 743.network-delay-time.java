/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

/*
53/53 cases passed (34 ms)
Your runtime beats 15.2 % of java submissions
Your memory usage beats 64.13 % of java submissions (48 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = createAdjacencyList(times, n);
        boolean[] vis = new boolean[n + 1];
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] {k, 0});
        n--;
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (!vis[node[0]]) {
                vis[node[0]] = true;
                n--;
                answer = node[1];
                for(int[] l : adjList.get(node[0])) {
                    pq.add(new int[] {l[0], node[1] + l[1]});
                }
            }
        }
        return n < 0 ? answer : -1;
    }
    
    private List<List<int[]>> createAdjacencyList(int[][] times, int n) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; ++i) {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; ++i) {
            adjList.get(times[i][0]).add(new int[] {times[i][1], times[i][2]});
        }
        return adjList;
    }
}
// @lc code=end

