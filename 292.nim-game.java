/*
 * @lc app=leetcode id=292 lang=java
 *
 * [292] Nim Game
 */

/*
60/60 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 63.14 % of java submissions (40.1 MB) 
 */

// @lc code=start
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
// @lc code=end

