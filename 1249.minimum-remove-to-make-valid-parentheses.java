/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

/*
62/62 cases passed (7 ms)
Your runtime beats 98.71 % of java submissions
Your memory usage beats 98.26 % of java submissions (44.8 MB)
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] str = s.toCharArray();
        int openParentheses = 0;
        for (int i = 0; i < str.length; ++i) {
            if (str[i] == '(') openParentheses++;
            else if (str[i] == ')') {
                if (openParentheses > 0) openParentheses--;
                else str[i] = '.';
            }
        }

        for (int i = str.length - 1; i >= 0 && openParentheses > 0; --i) {
            if (str[i] == '(') {
                str[i] = '.';
                openParentheses--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; ++i) {
            if (str[i] != '.') sb.append(str[i]);
        }
        return sb.toString();
    }
}
// @lc code=end
