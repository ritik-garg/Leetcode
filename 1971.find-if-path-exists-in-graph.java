/*
 * @lc app=leetcode id=1971 lang=java
 *
 * [1971] Find if Path Exists in Graph
 */

/*
30/30 cases passed (105 ms)
Your runtime beats 58.05 % of java submissions
Your memory usage beats 51.37 % of java submissions (148.2 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = createAdjLIst(n, edges);
        boolean[] visited = new boolean[n];
        return dfs(adjList, source, destination, visited);
    }

    private List<Integer>[] createAdjLIst(int n, int[][] edges) {
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        return adjList;
    }

    private boolean dfs(List<Integer>[] adjList, int src, int dst, boolean[] vis) {
        vis[src] = true;
        if (src == dst) return true;
        for (Integer neighbor : adjList[src]) {
            if (!vis[neighbor]) {
                if (dfs(adjList, neighbor, dst, vis)) return true;
            }
        }
        return false;
    }
}
// @lc code=end


/*
Without early return
30/30 cases passed (111 ms)
Your runtime beats 53.01 % of java submissions
Your memory usage beats 44.72 % of java submissions (150.8 MB)


class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = createAdjLIst(n, edges);
        boolean[] visited = new boolean[n];
        dfs(adjList, source, destination, visited);
        return visited[destination];
    }

    private List<Integer>[] createAdjLIst(int n, int[][] edges) {
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        return adjList;
    }

    private void dfs(List<Integer>[] adjList, int src, int dst, boolean[] vis) {
        vis[src] = true;
        if (src == dst) return;
        for (Integer neighbor : adjList[src]) {
            if (!vis[neighbor]) dfs(adjList, neighbor, dst, vis);
        }
    }
}
 */

