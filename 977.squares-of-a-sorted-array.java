/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

/*
137/137 cases passed (1 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 61.58 % of java submissions (47 MB)
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        int right = 0, left = 0, ansIdx = 0;
        while (right < nums.length && nums[right] < 0) {
            right++;
        }
        left = right - 1;
        while (left >= 0 || right < nums.length) {
            int leftSquare = left >= 0 ? nums[left] * nums[left] : Integer.MAX_VALUE;
            int rightSquare = right < nums.length ? nums[right] * nums[right] : Integer.MAX_VALUE;
            if (rightSquare <= leftSquare) {
                answer[ansIdx++] = rightSquare;
                right++;
            } else {
                answer[ansIdx++] = leftSquare;
                left--;
            }
        }
        return answer;
    }
}
// @lc code=end

