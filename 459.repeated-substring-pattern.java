/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

/*
129/129 cases passed (4 ms)
Your runtime beats 98.85 % of java submissions
Your memory usage beats 93.84 % of java submissions (44.5 MB)
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        for (int i = n / 2; i >= 1; --i) {
            if (n % i == 0) {
                boolean allEqual = true;
                for (int j = i; j < n; j += i) {
                    allEqual = isEqual(str, 0, j, i);
                    if (!allEqual) break;
                }
                if (allEqual) return true;
            }
        }
        return false;
    }

    private boolean isEqual(char[] str, int s1, int s2, int len) {
        for (int i = 0; i < len; ++i) {
            if (str[s1 + i] != str[s2 + i]) return false;
        }
        return true;
    }
}
// @lc code=end

