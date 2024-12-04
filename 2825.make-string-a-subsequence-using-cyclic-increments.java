/*
 * @lc app=leetcode id=2825 lang=java
 *
 * [2825] Make String a Subsequence Using Cyclic Increments
 */

/*
1126/1126 cases passed (5 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 23.03 % of java submissions (45.7 MB)
 */

// @lc code=start
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        return canMakeSubsequence(str1.toCharArray(), str2.toCharArray());
    }

    private boolean canMakeSubsequence(char[] s1, char[] s2) {
        int j = 0;
        for (int i = 0; i < s1.length; ++i) {
            if (s1[i] == s2[j] || (((s1[i] + 1 - 'a') % 26) + 'a') == s2[j]) {
                j++;
            }
            if (j >= s2.length) return true;
        }
        return false;
    }
}
// @lc code=end

