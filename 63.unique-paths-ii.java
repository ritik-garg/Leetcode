/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

/*
41/41 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 90.02 % of java submissions (41.4 MB)
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        for(int i = m - 1; i >= 0; --i) {
            for(int j = n - 1; j >= 0; --j) {
                if (i == m - 1 && j == n - 1) obstacleGrid[i][j] = 1;
                else if (i == m - 1) obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i][j + 1];
                else if (j == n - 1) obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i + 1][j];
                else obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i + 1][j] + obstacleGrid[i][j + 1];
            }
        }
        return obstacleGrid[0][0];
    }
}
// @lc code=end

