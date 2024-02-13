/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

/*
 * 1146/1146 cases passed (5 ms)
 * Your runtime beats 71.31 % of java submissions
 * Your memory usage beats 65.5 % of java submissions (44.9 MB)
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 || j == 0)
                    dp[i][j] = i + j;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }
}
// @lc code=end
