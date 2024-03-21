/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 */

/*
34/34 cases passed (2 ms)
Your runtime beats 78.26 % of java submissions
Your memory usage beats 77.5 % of java submissions (42.7 MB)
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        Integer max = null, secondMax = null, thirdMax = null;
        for (int num : nums) {
            if (max == null || num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if (num == max) continue;
            else if (secondMax == null || num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num == secondMax) continue;
            else if (thirdMax == null || num > thirdMax) {
                thirdMax = num;
            }
        }
        return thirdMax == null ? max : thirdMax;
    }
}
// @lc code=end

