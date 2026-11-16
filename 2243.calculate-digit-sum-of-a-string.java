/*
 * @lc app=leetcode id=2243 lang=java
 *
 * [2243] Calculate Digit Sum of a String
 */

/*
121/121 cases passed (1 ms)
Your runtime beats 98.69 % of java submissions
Your memory usage beats 78.17 % of java submissions (42.5 MB)
*/

// @lc code=start
class Solution {
    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;
        char[] str = s.toCharArray();
        while (str.length > k) {
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            for (int i = 0; i < str.length; ++i) {
                sum += (str[i] - '0');
                if ((i + 1) % k == 0) {
                    sb.append(String.valueOf(sum));
                    sum = 0;
                }
            }
            if (str.length % k != 0) {
                sb.append(String.valueOf(sum));
            }
            str = sb.toString().toCharArray();
        }
        return String.valueOf(str);
    }
}
// @lc code=end

