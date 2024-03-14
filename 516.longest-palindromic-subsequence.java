/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */

/*
86/86 cases passed (22 ms)
Your runtime beats 92.75 % of java submissions
Your memory usage beats 54.92 % of java submissions (55 MB)
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] str = s.toCharArray();
        char[] reverseStr = new StringBuilder(s).reverse().toString().toCharArray();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str[i - 1] == reverseStr[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n][n];
    }

    
}
// @lc code=end

