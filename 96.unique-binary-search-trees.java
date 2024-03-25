/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

/*
19/19 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 16.64 % of java submissions (40.5 MB)
 */

// @lc code=start
class Solution {
    private static int[] dp = new int[20];
    public int numTrees(int n) {
        if (dp[19] == 0) {
            fillDPArray();
        }
        return dp[n];
    }

    private void fillDPArray() {
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= 19; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
    }
}
// @lc code=end

