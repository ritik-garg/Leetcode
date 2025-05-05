/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

/**
114/114 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 62.1 % of java submissions (47.7 MB)
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                dfs(isConnected, vis, i, n);
                answer++;
            }
        }
        return answer;
    }

    void dfs(int[][] isConnected, boolean[] vis, int node, int n) {
        vis[node] = true;
        for (int i = 0; i < n; ++i) {
            if (i != node && !vis[i] && isConnected[node][i] == 1) {
                dfs(isConnected, vis, i, n);
            }
        }
    }
}
// @lc code=end

