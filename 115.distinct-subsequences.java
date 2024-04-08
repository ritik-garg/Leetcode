/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

/*
65/65 cases passed (13 ms)
Your runtime beats 77.93 % of java submissions
Your memory usage beats 46.99 % of java submissions (48.9 MB)
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], -1);
        }
        return numDistinct(s.toCharArray(), t.toCharArray(), 0, 0, dp);
    }

    private int numDistinct(char[] s, char[] t, int i, int j, int[][] dp) {
        int m = s.length, n = t.length;
        if (j >= n) return 1;
        if (i >= m) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = numDistinct(s, t, i + 1, j, dp);
        if (s[i] == t[j]) {
            dp[i][j] += numDistinct(s, t, i + 1, j + 1, dp);
        }
        return dp[i][j];
    }
}
// @lc code=end

