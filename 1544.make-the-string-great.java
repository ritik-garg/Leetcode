/*
 * @lc app=leetcode id=1544 lang=java
 *
 * [1544] Make The String Great
 */

// @lc code=start
class Solution {
    public String makeGood(String s) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; ++i) {
            if (sb.length() == 0) {
                sb.append(str[i]);
                continue;
            }
            char prev = sb.charAt(sb.length() - 1), curr = str[i];
            if (prev - 'a' == curr - 'A' || prev - 'A' == curr - 'a') {
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

