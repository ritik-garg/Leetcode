/*
 * @lc app=leetcode id=2337 lang=java
 *
 * [2337] Move Pieces to Obtain a String
 */

/*
131/131 cases passed (1446 ms)
Your runtime beats 5.29 % of java submissions
Your memory usage beats 54.17 % of java submissions (45.5 MB)
 */

// @lc code=start
class Solution {
    public boolean canChange(String start, String target) {
        return canChange(start.toCharArray(), target.toCharArray(), 0);
    }

    private boolean canChange(char[] s, char[] t, int i) {
        int n = s.length;
        while (i < n) {
            while (i < n && s[i] == t[i]) i++;
            if (i >= n) return true;
            if (t[i] == 'R' || (t[i] == 'L' && s[i] == 'R') || (t[i] == '_' && s[i] == 'L')) return false;
            if (t[i] == 'L') {
                int j = i;
                while (j < n && s[j] == '_') j++;
                if (j >= n || s[j] == 'R') return false;
                s[i] = 'L';
                s[j] = '_';
            } else if (t[i] == '_') {
                int j = i;
                while (j < n && s[j] == 'R') j++;
                if (j >= n || s[j] == 'L') return false;
                s[i] = '_';
                s[j] = 'R';
            }
            i++;
        }
        return false;
    }
}
// @lc code=end

