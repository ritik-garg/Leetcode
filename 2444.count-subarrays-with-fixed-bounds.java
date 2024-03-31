/*
 * @lc app=leetcode id=2444 lang=java
 *
 * [2444] Count Subarrays With Fixed Bounds
 */

/*
52/52 cases passed (14 ms)
Your runtime beats 5.78 % of java submissions
Your memory usage beats 7.58 % of java submissions (70.6 MB)
 */

// @lc code=start
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int left = 0;
        long answer = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] > maxK || nums[right] < minK) {
                answer += countSubarraysUtil(nums, left, right - 1, minK, maxK);
                left = right + 1;
            }
        }
        answer += countSubarraysUtil(nums, left, nums.length - 1, minK, maxK);
        return answer;
    }

    private long countSubarraysUtil(int[] nums, int start, int end, int a, int b) {
        if (start > end) return 0;
        int left = start, right = start;
        while (left <= end && nums[left] != a && nums[left] != b) left++;
        if (left > end) return 0;
        if (nums[left] != a) {
            int temp = a;
            a = b;
            b = temp;
        }   
        while (right <= end && nums[right] != b) right++;
        if (right > end) return 0;
        long answer = (left - start + 1) * (end - right + 1) + countSubarraysUtil(nums, left + 1, end, a, b);
        return answer;
    }
}
// @lc code=end

