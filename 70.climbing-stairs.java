/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

/*
45/45 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 76.1 % of java submissions (40.1 MB)
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 2;
        if (n == 1) return a;
        if (n == 2) return b;
        for (int i = 3; i <= n; ++i) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
// @lc code=end

