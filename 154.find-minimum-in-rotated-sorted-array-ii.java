/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

/*
193/193 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 88.21 % of java submissions (42.6 MB)
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) high = mid;
            else if (nums[mid] == nums[high]) high--;
            else low = mid + 1;
        }
        return nums[low];
    }
}
// @lc code=end

