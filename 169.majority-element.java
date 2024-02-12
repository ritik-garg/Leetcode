/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

/**
 * 
 * 50/50 cases passed (2 ms)
 * Your runtime beats 99.82 % of java submissions
 * Your memory usage beats 62.69 % of java submissions (50.4 MB)
 */

// @lc code=start

class Solution {
    public int majorityElement(int[] nums) {
        // Moore Voting Algorithm
        int c = 1;
        int e = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            if(c == 0) e = nums[i];
            c += (e == nums[i]) ? 1 : -1;
        }
        return e;
    }
}
// @lc code=end