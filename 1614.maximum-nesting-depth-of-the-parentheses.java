/*
 * @lc app=leetcode id=1614 lang=java
 *
 * [1614] Maximum Nesting Depth of the Parentheses
 */

/*
167/167 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 93.17 % of java submissions (41.1 MB)
 */

// @lc code=start
class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0, currentDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (ch == ')') currentDepth--;
        }
        return maxDepth;
    }
}
// @lc code=end

