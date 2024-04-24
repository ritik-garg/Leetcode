/*
 * @lc app=leetcode id=1137 lang=java
 *
 * [1137] N-th Tribonacci Number
 */

/*
39/39 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 59.37 % of java submissions (40.1 MB)
 */

// @lc code=start
class Solution {
    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; ++i) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        if (n == 0) return a;
        return c;
    }
}
// @lc code=end

