/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

/*
76/76 cases passed (1 ms)
Your runtime beats 99.41 % of java submissions
Your memory usage beats 46.43 % of java submissions (44.1 MB)
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int length = 0, i = 0;
        while (i < chars.length) {
            int count = 0;
            char current = chars[i];
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }

            chars[length++] = chars[i - 1];
            if (count > 1) {
                for(char c : String.valueOf(count).toCharArray()) {
                    chars[length++] = c;
                }
            }
        }

        return length;
    }
}
// @lc code=end

