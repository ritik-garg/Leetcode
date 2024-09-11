/*
 * @lc app=leetcode id=2220 lang=java
 *
 * [2220] Minimum Bit Flips to Convert Number
 */

/*
250/250 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 64.36 % of java submissions (40.3 MB)
 */

// @lc code=start
class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int answer = 0;
        while (xor != 0) {
            answer += xor & 1;
            xor >>= 1;
        }
        return answer;
    }
}
// @lc code=end

