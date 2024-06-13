/*
 * @lc app=leetcode id=2037 lang=java
 *
 * [2037] Minimum Number of Moves to Seat Everyone
 */

/*
262/262 cases passed (2 ms)
Your runtime beats 97.35 % of java submissions
Your memory usage beats 65.16 % of java submissions (43.9 MB)
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < seats.length; ++i) ans += Math.abs(seats[i] - students[i]);
        return ans;
    }
}
// @lc code=end

