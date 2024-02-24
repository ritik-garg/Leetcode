/*
 * @lc app=leetcode id=2171 lang=java
 *
 * [2171] Removing Minimum Number of Magic Beans
 */

/*
 * Video Explanation: https://www.youtube.com/watch?v=Dkrw0_raQ_s&ab_channel=Leetcodes
 */

/*
64/64 cases passed (35 ms)
Your runtime beats 71.2 % of java submissions
Your memory usage beats 60 % of java submissions (64 MB)
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long sum = 0L, maxArea = 0L;
        for(int i = 0; i < n; ++i) {
            sum += beans[i];
            maxArea = Math.max(maxArea, 1L * beans[i] * (n - i));
        }
        return sum - maxArea;
    }
}
// @lc code=end

