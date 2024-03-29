/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */

/*
1494/1494 cases passed (1 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 69.99 % of java submissions (42.4 MB)
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        char[] number = s.toCharArray();
        boolean seenE = false, seenDot = false, seenNumber = false;
        for (int i = 0; i < number.length; ++i) {
            if (number[i] == '-' || number[i] == '+') {
                if (i != 0 && number[i - 1] != 'e' && number[i - 1] != 'E') return false;
            } else if (number[i] == '.') {
                if (seenE || seenDot) return false;
                seenDot = true;
            } else if (number[i] == 'e' || number[i] == 'E') {
                if (!seenNumber || i == number.length - 1 || seenE) return false;
                seenE = true;
                seenNumber = false;
            } else if (number[i] < '0' || number[i] > '9') {
                return false;
            } else {
                seenNumber = true;
            }
        }
        return seenNumber;
    }
}
// @lc code=end

