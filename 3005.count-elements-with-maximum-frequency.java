/*
 * @lc app=leetcode id=3005 lang=java
 *
 * [3005] Count Elements With Maximum Frequency
 */

/*
623/623 cases passed (1 ms)
Your runtime beats 99.58 % of java submissions
Your memory usage beats 63.57 % of java submissions (42.1 MB)
 */

// @lc code=start
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0, count = 0;
        for (int num : nums) {
            freq[num]++;
            if (freq[num] > max) {
                max = freq[num];
                count = 1;
            } else if (freq[num] == max) {
                count++;
            }
        }
        return count * max;
    }
}
// @lc code=end
