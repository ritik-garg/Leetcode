/*
 * @lc app=leetcode id=2914 lang=java
 *
 * [2914] Minimum Number of Changes to Make Binary String Beautiful
 */

/*
577/577 cases passed (3 ms)
Your runtime beats 97.78 % of java submissions
Your memory usage beats 73.44 % of java submissions (44.5 MB)
 */

// @lc code=start
class Solution {
    public int minChanges(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                answer++;
            }
        }
        return answer;
    }
}
// @lc code=end

