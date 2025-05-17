/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

/**
89/89 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 46.39 % of java submissions (42 MB)
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int[] c = new int[3];
        for (int n : nums) {
            c[n]++;
        }
        int i = 0;
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < c[j]; ++k, ++i) {
                nums[i] = j;
            }
        }
    }
}
// @lc code=end

/**
89/89 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 30.03 % of java submissions (42.2 MB)

class Solution {
    public void sortColors(int[] nums) {
        int r = 0, w = 0, b = 0;
        for (int i = 0; i < nums.length; ++i) {
            r += nums[i] == 0 ? 1 : 0;
            w += nums[i] == 1 ? 1 : 0;
            b += nums[i] == 2 ? 1 : 0;
        }

        for (int i = 0; i < r; ++i) {
            nums[i] = 0;
        }
        for (int i = r; i < r + w; ++i) {
            nums[i] = 1;
        }
        for (int i = r + w; i < nums.length; ++i) {
            nums[i] = 2;
        }
    }
}
 */