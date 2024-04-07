/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

/*
83/83 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 90.85 % of java submissions (41 MB)
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        int maxOpen = 0, minOpen = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                maxOpen++; minOpen++;
            } else if (ch == ')') {
                maxOpen--;
                minOpen--;
            } else {
                maxOpen++;
                minOpen--;
            }
            if (maxOpen < 0) return false;
            minOpen = minOpen < 0 ? 0 : minOpen;
        }
        return minOpen == 0;
    }
}
// @lc code=end

