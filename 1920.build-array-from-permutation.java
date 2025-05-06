/*
 * @lc app=leetcode id=1920 lang=java
 *
 * [1920] Build Array from Permutation
 */

/*
140/140 cases passed (1 ms)
Your runtime beats 98.72 % of java submissions
Your memory usage beats 91.98 % of java submissions (45.2 MB)
 */

// @lc code=start
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; ++i) {
            answer[i] = nums[nums[i]];
        }
        return answer;
    }
}
// @lc code=end

