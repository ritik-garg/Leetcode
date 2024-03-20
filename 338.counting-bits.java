/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

/*
15/15 cases passed (2 ms)
Your runtime beats 93.92 % of java submissions
Your memory usage beats 64.4 % of java submissions (46.5 MB)
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            answer[i] = answer[i >> 1] + (i & 1);
        }
        return answer;
    }
}
// @lc code=end

