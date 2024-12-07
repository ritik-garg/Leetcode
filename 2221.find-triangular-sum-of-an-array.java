/*
 * @lc app=leetcode id=2221 lang=java
 *
 * [2221] Find Triangular Sum of an Array
 */

/*
300/300 cases passed (41 ms)
Your runtime beats 97.35 % of java submissions
Your memory usage beats 88.68 % of java submissions (44.2 MB)
 */

// @lc code=start
class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            --n;
            for (int i = 0; i < n; ++i) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }
}
// @lc code=end

