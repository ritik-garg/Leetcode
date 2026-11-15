/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

/*
47/47 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 86.55 % of java submissions (47.7 MB)
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
            else if (target > nums[m]) l = m + 1;
            else h = m - 1;
        }
        return -1;
    }
}
// @lc code=end

