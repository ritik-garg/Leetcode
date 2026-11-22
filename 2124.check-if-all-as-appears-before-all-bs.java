/*
 * @lc app=leetcode id=2124 lang=java
 *
 * [2124] Check if All A's Appears Before All B's
 */

/*
216/216 cases passed (1 ms)
Your runtime beats 54.57 % of java submissions
Your memory usage beats 26.36 % of java submissions (42.8 MB)
*/

// @lc code=start
class Solution {
    public boolean checkString(String s) {
        char[] c = s.toCharArray();
        boolean b = false;
        for (char ch : c) {
            if (b && ch == 'a') return false;
            else if (ch == 'b') b = true;
        }
        return true;
    }
}
// @lc code=end

