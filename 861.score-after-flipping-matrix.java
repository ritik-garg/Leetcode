/*
 * @lc app=leetcode id=861 lang=java
 *
 * [861] Score After Flipping Matrix
 */

/*
80/80 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 60.61 % of java submissions (41.3 MB)
 */

// @lc code=start
class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = (1 << (n - 1)) * m;

        for (int j = 1; j < n; j++) {
            int same = 0;
            for (int i = 0; i < m; i++) same += grid[i][0] == grid[i][j] ? 1 : 0;
            result += (1 << (n - 1 - j)) * Math.max(same, m - same);
        }

        return result;
    }
}
// @lc code=end
