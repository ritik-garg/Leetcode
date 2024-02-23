/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

/*
210/210 cases passed (2 ms)
Your runtime beats 79.67 % of java submissions
Your memory usage beats 96.06 % of java submissions (41.1 MB)
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        k *= 2;
        int[] dp = new int[k];
        for(int i = 0; i < prices.length; ++i) {
            for(int j = 0; j < k; ++j) {
                if (i == 0 && j % 2 == 0) {
                    dp[j] = Integer.MIN_VALUE;
                }
                if (j == 0) {
                    dp[j] = Math.max(dp[j], -prices[i]);
                } else if (j % 2 == 0) {
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        }
        return dp[k - 1];
    }
}
// @lc code=end

