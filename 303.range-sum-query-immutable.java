/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

/*
15/15 cases passed (8 ms)
Your runtime beats 65.98 % of java submissions
Your memory usage beats 94.21 % of java submissions (48.8 MB)
 */

// @lc code=start
class NumArray {
    long[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) return (int) prefixSum[right];
        return (int) (prefixSum[right] - prefixSum[left - 1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

