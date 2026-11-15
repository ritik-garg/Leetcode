/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

/*
198/198 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 84.6 % of java submissions (43.2 MB)
*/

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) return target == nums[0] ? 0 : -1;

        int l = 0, h = n - 1;
        while (l <= h) {
            int m = h - (h - l) / 2;
            if (target == nums[m]) return m;
            if (nums[l] <= nums[m]) {
                if (target >= nums[l] && target < nums[m]) h = m - 1;
                else l = m + 1;
            } else {
                if (target > nums[m] && target <= nums[h]) l = m + 1;
                else h = m - 1;
            }
        }

        return -1;
    }
}
// @lc code=end

