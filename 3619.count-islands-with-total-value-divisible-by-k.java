/*
 * @lc app=leetcode id=3551 lang=java
 *
 * [3619] Count Islands with Total Value Divisible by K
 */

/**
 * 
 * 670/670 cases passed (23 ms)
 * Your runtime beats 49.41 % of java submissions
 * Your memory usage beats 47.84 % of java submissions (115.2 MB)
 */

// @lc code=start
class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    if(DFS(grid, m, n, i, j, k) == 0) ans++;
                }
            } 
        }
        return ans;
    }

    int DFS(int[][] grid, int m, int n, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;
        int t = grid[i][j];
        grid[i][j] = 0;
        return (t + DFS(grid, m, n, i + 1, j, k) + DFS(grid, m, n, i - 1, j, k) + DFS(grid, m, n, i, j + 1, k) + DFS(grid, m, n, i, j - 1, k)) % k;
    }
}
// @lc code=end