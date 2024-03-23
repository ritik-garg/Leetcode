/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

/*
281/281 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 34.68 % of java submissions (43.3 MB)
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target)
                return true;
            if ((nums[left] == nums[mid]) && (nums[right] == nums[mid])) {
                ++left;
                --right;
            }

            else if (nums[left] <= nums[mid]) {
                if ((nums[left] <= target) && (nums[mid] > target))
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if ((nums[mid] < target) && (nums[right] >= target))
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }
}
// @lc code=end
