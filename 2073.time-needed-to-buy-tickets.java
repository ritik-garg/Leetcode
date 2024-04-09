/*
 * @lc app=leetcode id=2073 lang=java
 *
 * [2073] Time Needed to Buy Tickets
 */

/*
65/65 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 86.99 % of java submissions (40.8 MB)
 */

// @lc code=start
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ticketsNeeded = tickets[k], totalTime = 0;
        for (int i = 0; i <= k; ++i) {
            totalTime += tickets[i] > ticketsNeeded ? ticketsNeeded : tickets[i];
        }
        for (int i = k + 1; i < tickets.length; ++i) {
            totalTime += tickets[i] >= ticketsNeeded ? ticketsNeeded - 1 : tickets[i];
        }
        return totalTime;
    }
}
// @lc code=end

