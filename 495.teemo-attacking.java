/*
 * @lc app=leetcode id=495 lang=java
 *
 * [495] Teemo Attacking
 */

/*
40/40 cases passed (2 ms)
Your runtime beats 99.73 % of java submissions
Your memory usage beats 20.83 % of java submissions (45.1 MB)
 */

// @lc code=start
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = 0;
        int start = timeSeries[0], end = timeSeries[0] + duration - 1;
        for (int i = 1; i < timeSeries.length; ++i) {
            if (timeSeries[i] > end) {
                time += end - start + 1;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration - 1;
        }
        time += end - start + 1;
        return time;
    }
}
// @lc code=end

