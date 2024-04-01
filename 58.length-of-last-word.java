/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

/*
58/58 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 98.13 % of java submissions (41.1 MB)
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) != ' ') len++;
            else if (len != 0) break;
        }
        return len;
    }
}
// @lc code=end

