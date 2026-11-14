/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

/*
24/24 cases passed (4 ms)
Your runtime beats 6.59 % of java submissions
Your memory usage beats 86.42 % of java submissions (64.5 MB)
*/

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] p = new int[n], s = new int[n];
        p[0] = nums[0]; s[n - 1] = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            p[i] = p[i - 1] * nums[i];
            s[n - i - 1] = s[n - i] * nums[n - i - 1];
        }

        int[] ans = new int[n];
        ans[0] = s[1];
        ans[n - 1] = p[n - 2]; 
        for (int i = 1; i < n - 1; ++i) {
            ans[i] = p[i - 1] * s[i + 1];
        }
        return ans;
    }
}
// @lc code=end

