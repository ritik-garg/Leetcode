/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

/*
44/44 cases passed (4 ms)
Your runtime beats 52.66 % of java submissions
Your memory usage beats 91.14 % of java submissions (43.4 MB)
 */

// @lc code=start

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m + 1];
        for(int i = m - 1; i >= 0; --i) {
            for(int j = 0; j < triangle.get(i).size(); ++j) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
// @lc code=end

