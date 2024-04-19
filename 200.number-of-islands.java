/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

/*
49/49 cases passed (3 ms)
Your runtime beats 86.63 % of java submissions
Your memory usage beats 34.95 % of java submissions (49.6 MB)
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0, m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (!isValid(x, y, grid)) return;
        grid[x][y] = '0';
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
    }

    private boolean isValid(int x, int y, char[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1';
    }
}
// @lc code=end

