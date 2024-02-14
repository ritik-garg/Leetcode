/*
 * @lc app=leetcode id=2149 lang=java
 *
 * [2149] Rearrange Array Elements by Sign
 */

/*
 * 133/133 cases passed (3 ms)
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 39.63 % of java submissions (77.2 MB)
 */

// @lc code=start
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int positiveIdx = 0, negativeIdx = 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                ans[negativeIdx] = nums[i];
                negativeIdx += 2;
            } else {
                ans[positiveIdx] = nums[i];
                positiveIdx += 2;
            }
        }
        return ans;
    }
}
// @lc code=end
