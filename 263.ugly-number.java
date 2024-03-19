/*
 * @lc app=leetcode id=263 lang=java
 *
 * [263] Ugly Number
 */

/*
1013/1013 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 43.54 % of java submissions (40.7 MB)
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
}
// @lc code=end

