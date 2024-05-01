/*
 * @lc app=leetcode id=2000 lang=java
 *
 * [2000] Reverse Prefix of Word
 */

/*
112/112 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 42.61 % of java submissions (41.6 MB)
 */

// @lc code=start
class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = 0;
        char[] w = word.toCharArray();
        while (idx < w.length && w[idx] != ch) idx++;
        if (idx >= w.length) return word;

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < w.length; ++i) {
            if (i <= idx) answer.append(w[idx - i]);
            else answer.append(w[i]);
        }
        return answer.toString();
    }
}
// @lc code=end

