/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

/*
167/167 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 94.66 % of java submissions (44.1 MB)
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            nums[left] = nums[right];
            if (right < nums.length - 1 && nums[right + 1] == nums[right]) {
                nums[left + 1] =  nums[left];
                left++;
            }
            left++;
            right++;
            while (right < nums.length && nums[right] == nums[right - 1]) {
                right++;
            }
        }
        return left;
    }
}
// @lc code=end

