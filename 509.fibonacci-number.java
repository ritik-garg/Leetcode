/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

/*
31/31 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 48.35 % of java submissions (40.4 MB)
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
// @lc code=end

