/*
 * @lc app=leetcode id=521 lang=java
 *
 * [521] Longest Uncommon Subsequence I
 */

/*
41/41 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 85.45 % of java submissions (41 MB)
 */

// @lc code=start
class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
// @lc code=end

