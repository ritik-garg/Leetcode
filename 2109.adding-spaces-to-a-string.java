/*
 * @lc app=leetcode id=2109 lang=java
 *
 * [2109] Adding Spaces to a String
 */

/*
66/66 cases passed (21 ms)
Your runtime beats 88.52 % of java submissions
Your memory usage beats 55.56 % of java submissions (80.6 MB)
 */

// @lc code=start
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();
        int j = 0;
        for (int i = 0; i < str.length; ++i) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(' ');
                j++;
            }
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

