/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

/*
 * 38/38 cases passed (0 ms)
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 16.13 % of java submissions (57.6 MB)
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }

    private void reverseArray(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
// @lc code=end

