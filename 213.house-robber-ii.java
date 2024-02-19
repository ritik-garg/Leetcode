/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

/*
75/75 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 54.48 % of java submissions (41 MB)
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        
        int prevPrev1 = nums[0], prev1 = Math.max(nums[0], nums[1]);
        int prevPrev2 = 0, prev2 = nums[1];

        for(int i = 2; i < n; ++i) {
            if (i != n - 1) {
                int current1 = Math.max(nums[i] + prevPrev1, prev1);
                prevPrev1 = prev1;
                prev1 = current1;
            }

            int current2 = Math.max(nums[i] + prevPrev2, prev2);
            prevPrev2 = prev2;
            prev2 = current2;
        }

        return Math.max(prev1, prev2);
    }
}
// @lc code=end

