/*
 * @lc app=leetcode id=520 lang=java
 *
 * [520] Detect Capital
 */

/*
551/551 cases passed (1 ms)
Your runtime beats 90.18 % of java submissions
Your memory usage beats 77.6 % of java submissions (41.6 MB)
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        Boolean firstChar = null;
        for (char ch : word.toCharArray()) {
            if (firstChar == null) {
                if (ch >= 'A' && ch <= 'Z') firstChar = true;
                else firstChar = false;    
            }
            if (ch >= 'A' && ch <= 'Z') {
                capitals++;
            }
        }
        return capitals == 0 || capitals == word.length() || (capitals == 1 && firstChar == true);
    }
}
// @lc code=end

