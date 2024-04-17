/*
 * @lc app=leetcode id=482 lang=java
 *
 * [482] License Key Formatting
 */

/*
39/39 cases passed (5 ms)
Your runtime beats 98.99 % of java submissions
Your memory usage beats 70.58 % of java submissions (44.4 MB)
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        char[] str = s.toCharArray();
        int length = 0;
        for (int i = 0; i < str.length; ++i) {
            if (str[i] == '-') continue;
            if (str[i] >= 'a' && str[i] <= 'z') str[i] = (char) (str[i] - 'a' + 'A');
            length++;
        }

        int partLength = length % k == 0 ? 0 : k - (length % k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; ++i) {
            if (str[i] == '-') continue;
            if (partLength == k) {
                sb.append('-');
                partLength = 0;
            }
            sb.append(str[i]);
            partLength++;
        }
        return sb.toString();
    }
}
// @lc code=end

