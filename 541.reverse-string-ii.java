/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 */

/*
60/60 cases passed (3 ms)
Your runtime beats 19.78 % of java submissions
Your memory usage beats 12.95 % of java submissions (44.4 MB)
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] str = s.toCharArray(), answer = new char[n];
        int i = 0;
        while (i < n) {
            for (int j = 0; j < k && i + j < n; ++j) {
                int idx = i + k >= n ? n - j - 1 : i + k - j - 1;
                answer[idx] = str[i + j];
            }
            i += k;
            for (int j = 0; j < k && i + j < n; ++j) {
                answer[i + j] = str[i + j];
            }
            i += k;
        }
        return new String(answer);
    }
}
// @lc code=end

