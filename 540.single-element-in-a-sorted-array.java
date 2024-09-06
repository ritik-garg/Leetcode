/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

/*
16/16 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 98.69 % of java submissions (49.7 MB)
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid == 0 || mid == nums.length - 1) return nums[mid];
            if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) low = mid + 1;
                else high = mid - 1;
            } else if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) high = mid - 1;
                else low = mid + 1;
            } else return nums[mid];
        }
        return nums[low];
    }
}
// @lc code=end

