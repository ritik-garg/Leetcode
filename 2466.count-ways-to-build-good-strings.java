/*
 * @lc app=leetcode id=2466 lang=java
 *
 * [2466] Count Ways To Build Good Strings
 */

/*
36/36 cases passed (6 ms)
Your runtime beats 98.66 % of java submissions
Your memory usage beats 99.33 % of java submissions (42.3 MB)
 */

// @lc code=start
class Solution {
    private static final int MODULO = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;

        int ans = 0;
        for (int i = 0; i <= high; ++i) {
            if (dp[i] != 0) {
                int i1 = i + zero, i2 = i + one;
                if (i1 <= high) dp[i1] = (dp[i1] + dp[i]) % MODULO;
                if (i2 <= high) dp[i2] = (dp[i2] + dp[i]) % MODULO;
            }
            if (i >= low) {
                ans = (ans + dp[i]) % MODULO;
            }
        }

        return ans;
    }
}
// @lc code=end

