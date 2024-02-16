/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

/*
66/66 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 90.28 % of java submissions (42 MB)
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        if (nums[1] < nums[0]) {
            return 0;
        } 
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == 0) {
                low = 1;
            } else if (mid == n - 1) {
                high = mid - 1;
            } else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }
}
// @lc code=end

