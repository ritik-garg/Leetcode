/*
 * @lc app=leetcode id=2370 lang=java
 *
 * [2370] Longest Ideal Subsequence
 */

/*
85/85 cases passed (36 ms)
Your runtime beats 48.41 % of java submissions
Your memory usage beats 40.48 % of java submissions (45.2 MB)
 */

// @lc code=start
class Solution {
    public int longestIdealString(String s, int k) {
        int answer = 0, n = s.length(), dp[] = new int[150];
        char[] str = s.toCharArray();
        for (int ci = 0; ci < n; ++ci) {
            int i = str[ci];
            for (int j = i - k; j <= i + k; ++j) dp[i] = Math.max(dp[i], dp[j]);
            answer = Math.max(answer, ++dp[i]);
        }
        return answer;
    }
}
// @lc code=end

