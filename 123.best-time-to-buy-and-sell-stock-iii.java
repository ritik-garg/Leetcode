/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

/*
214/214 cases passed (7 ms)
Your runtime beats 51.07 % of java submissions
Your memory usage beats 68.69 % of java submissions (60.8 MB)
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        for (int i = 0; i < prices.length; ++i) {
            for(int j = 0; j < 4; ++j) {
                if (i == 0 && j % 2 == 0) dp[j] = Integer.MIN_VALUE;
                if (j == 0) {
                    dp[j] = Math.max(dp[j], -prices[i]);
                } else if (j % 2 == 0) {
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        }
        return dp[3];
    }
}
// @lc code=end

