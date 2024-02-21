/*
 * @lc app=leetcode id=201 lang=java
 *
 * [201] Bitwise AND of Numbers Range
 */

/*
8269/8269 cases passed (3 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 88.61 % of java submissions (43.6 MB)
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right = right & (right - 1);
        }
        return right & left;
    }
}
// @lc code=end

