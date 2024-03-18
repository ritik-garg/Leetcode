/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

/*
1811/1811 cases passed (12 ms)
Your runtime beats 88.18 % of java submissions
Your memory usage beats 41.11 % of java submissions (46.1 MB)
 */

// @lc code=start
class Solution {
    public boolean isMatch(String str, String pat) {
        int m = str.length(), n = pat.length();
        char[] s = str.toCharArray(), p = pat.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p[i - 1] != '*') break;
            dp[0][i] = true;
        }

        for (int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '?') 
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p[j - 1] == '*') 
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else 
                    dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

