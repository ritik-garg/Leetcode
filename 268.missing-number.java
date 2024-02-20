/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

/*
122/122 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 74.57 % of java submissions (45 MB)
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int sum = (nums.length) * (nums.length + 1) / 2;
        for (int i : nums) sum -= i;
        return sum;
    }
}
// @lc code=end

