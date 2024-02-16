/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

/*
269/269 cases passed (1 ms)
Your runtime beats 79.1 % of java submissions
Your memory usage beats 60.24 % of java submissions (41.7 MB)
*/

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        s = "0" + s; // to easily start the index with 1
        int prev = 1, prevPrev = 1;
        for (int i = 1; i < s.length(); ++i) {
            int curr = 0;
            if (s.charAt(i) != '0') {
                curr += prev;
            }
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) < '7') {
                curr += prevPrev;
            }

            prevPrev = prev;
            prev = curr;
        }

        return prev;
    }
}
// @lc code=end

/*
 * Using Set for validity check
 * 269/269 cases passed (10 ms)
 * Your runtime beats 5.73 % of java submissions
 * Your memory usage beats 5.48 % of java submissions (42.7 MB)
 * 
 * public int numDecodings(String s) {
 * Set<String> valid = new HashSet<>(Arrays.asList("1", "2", "3", "4",
 * "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
 * "18", "19",
 * "20", "21", "22", "23", "24", "25", "26"));
 * 
 * s = "00" + s;
 * int[] dp = new int[s.length()];
 * dp[0] = 1;
 * dp[1] = 1;
 * for(int i = 2; i < s.length(); ++i) {
 * if (valid.contains("" + s.charAt(i))) {
 * dp[i] += dp[i - 1];
 * }
 * if (valid.contains("" + s.charAt(i - 1) + s.charAt(i))) {
 * dp[i] += dp[i - 2];
 * }
 * }
 * 
 * return dp[s.length() - 1];
 * }
 * 
 */
