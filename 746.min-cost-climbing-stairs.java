/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

/*
285/285 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 71.93 % of java submissions (43 MB)
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < n; ++i) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[n - 1], cost[n - 2]);
    }
}
// @lc code=end

