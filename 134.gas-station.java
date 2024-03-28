/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

/*
40/40 cases passed (3 ms)
Your runtime beats 47.09 % of java submissions
Your memory usage beats 64.65 % of java submissions (56.9 MB)
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0, totalSurplus = 0;
        int start = 0;

        for (int i = 0; i < gas.length; ++i) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }
        return totalSurplus >= 0 ? start : -1;
    }
}
// @lc code=end

