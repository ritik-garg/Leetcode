/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

/*
21/21 cases passed (1 ms)
Your runtime beats 99.97 % of java submissions
Your memory usage beats 86.88 % of java submissions (57.6 MB)
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, left = 0, right = 0;
        int answer = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                answer = Math.min(right - left + 1, answer);
                sum -= nums[left++];
            }
            right++;
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
// @lc code=end

