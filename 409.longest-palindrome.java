/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */

/*
95/95 cases passed (1 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 19.16 % of java submissions (42.1 MB)
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] frequency = new int[128];
        for(int ch : s.toCharArray()) {
            frequency[ch]++;
        }
        int answer = 0;
        boolean extra = false;
        for(int i : frequency) {
            answer += i % 2 == 0 ? i : i - 1;
            extra = extra ? extra : i % 2 == 1;
        }
        return extra ? answer + 1 : answer;
    }
}
// @lc code=end

