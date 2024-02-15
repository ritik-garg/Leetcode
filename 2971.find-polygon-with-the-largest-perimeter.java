/*
 * @lc app=leetcode id=2971 lang=java
 *
 * [2971] Find Polygon With the Largest Perimeter
 */

/*
 * 980/980 cases passed (28 ms)
 * Your runtime beats 98.63 % of java submissions
 * Your memory usage beats 45.78 % of java submissions (56.8 MB)
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0, answer = -1;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] < sum) {
                answer = sum + nums[i];
            }
            sum += nums[i];
        }
        return answer;
    }
}
// @lc code=end
