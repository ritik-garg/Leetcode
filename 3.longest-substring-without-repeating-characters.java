/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

/*
 * 987/987 cases passed (2 ms)
 * Your runtime beats 99.15 % of java submissions
 * Your memory usage beats 80.74 % of java submissions (43.9 MB)
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] frequency = new int[256];
        int left = 0, right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            frequency[ch]++;
            if(frequency[ch] > 1) {
                maxLength = Math.max(maxLength, right - left);
                while (frequency[ch] > 1) {
                    frequency[s.charAt(left)]--;
                    left++;
                }
            }
            right++;
        }
        maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }
}
// @lc code=end

