/*
 * @lc app=leetcode id=2485 lang=java
 *
 * [2485] Find the Pivot Integer
 */

/*
428/428 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 84.41 % of java submissions (40.2 MB)
 */

// @lc code=start
class Solution {
    public int pivotInteger(int n) {
        n = n * (n + 1) / 2;
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return sqrt;
        }
        return -1;
    }
}
// @lc code=end

