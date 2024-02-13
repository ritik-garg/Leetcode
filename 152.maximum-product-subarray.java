/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

/*
 * 190/190 cases passed (1 ms)
 * Your runtime beats 89.76 % of java submissions
 * Your memory usage beats 68.32 % of java submissions (44.7 MB)
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int leftProduct = 1, rightProduct = 1, max = -11;
        for (int i = 0; i < n; ++i) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[n - i - 1];
            max = Math.max(max, Math.max(leftProduct, rightProduct));
        }

        return max;
    }
}
// @lc code=end
