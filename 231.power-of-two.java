/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

/*
1109/1109 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 83.26 % of java submissions (40.6 MB)
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
// @lc code=end
