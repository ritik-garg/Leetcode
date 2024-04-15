/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

/*
43/43 cases passed (2 ms)
Your runtime beats 91.03 % of java submissions
Your memory usage beats 80.91 % of java submissions (45.3 MB)
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int answer = 0, currentSum = 0;
        for (int i : nums) {
            if (i == 0) {
                answer = Math.max(answer, currentSum);
                currentSum = 0;
            } else {
                currentSum++;
            }
        }
        answer = Math.max(answer, currentSum);
        return answer;
    }
}
// @lc code=end

