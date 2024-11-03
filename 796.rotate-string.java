/*
 * @lc app=leetcode id=796 lang=java
 *
 * [796] Rotate String
 */

/*
54/54 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 51.17 % of java submissions (41.4 MB)
 */

// @lc code=start
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return rotateString(s.toCharArray(), goal.toCharArray());
    }

    private boolean rotateString(char[] s, char[] goal) {
        for (int i = 0; i < goal.length; ++i) {
            if (goal[i] == s[0] && rotateString(s, goal, i)) return true;
        }
        return false;
    }

    private boolean rotateString(char[] s, char[] goal, int idx) {
        for (int i = 0; i < s.length; ++i) {
            if (s[i] != goal[(i + idx) % goal.length]) return false;
        }
        return true;
    }
}
// @lc code=end

