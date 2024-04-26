/*
 * @lc app=leetcode id=1289 lang=java
 *
 * [1289] Minimum Falling Path Sum II
 */

/*
16/16 cases passed (6 ms)
Your runtime beats 82.31 % of java submissions
Your memory usage beats 79.25 % of java submissions (49.1 MB)
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length, prevMinIdx = -1, prevSecondMinIdx = -1;
        for (int i = 0; i < n; ++i) {
            int minIdx = -1, secondMinIdx = -1;
            for (int j = 0; j < n; ++j) {
                if (i != 0) {
                    if (prevMinIdx == j) grid[i][j] = grid[i - 1][prevSecondMinIdx] + grid[i][j];
                    else grid[i][j] = grid[i - 1][prevMinIdx] + grid[i][j];
                }
                if (minIdx == -1) {
                    minIdx = j;
                } else if (grid[i][j] <= grid[i][minIdx]) {
                    secondMinIdx = minIdx;
                    minIdx = j;
                } else if (secondMinIdx == -1) {
                    secondMinIdx = j;
                } else if (grid[i][j] <= grid[i][secondMinIdx]) {
                    secondMinIdx = j;
                }
            }
            prevMinIdx = minIdx;
            prevSecondMinIdx = secondMinIdx;
        }
        return grid[n - 1][prevMinIdx];
    }
}
// @lc code=end


/*
With different dp array:
16/16 cases passed (6 ms)
Your runtime beats 82.31 % of java submissions
Your memory usage beats 26.19 % of java submissions (51.5 MB)

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length, prevMinIdx = -1, prevSecondMinIdx = -1;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            int minIdx = -1, secondMinIdx = -1;
            for (int j = 0; j < n; ++j) {
                if (i == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    if (prevMinIdx == j) dp[i][j] = dp[i - 1][prevSecondMinIdx] + grid[i][j];
                    else dp[i][j] = dp[i - 1][prevMinIdx] + grid[i][j];
                }
                if (minIdx == -1) {
                    minIdx = j;
                } else if (dp[i][j] <= dp[i][minIdx]) {
                    secondMinIdx = minIdx;
                    minIdx = j;
                } else if (secondMinIdx == -1) {
                    secondMinIdx = j;
                } else if (dp[i][j] <= dp[i][secondMinIdx]) {
                    secondMinIdx = j;
                }
            }
            prevMinIdx = minIdx;
            prevSecondMinIdx = secondMinIdx;
        }
        return dp[n - 1][prevMinIdx];
    }
}
 */