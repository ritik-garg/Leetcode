/*
 * @lc app=leetcode id=2864 lang=java
 *
 * [2864] Maximum Odd Binary Number
 */

/*
985/985 cases passed (1 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 91.87 % of java submissions (42.9 MB)
 */

// @lc code=start
class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder answer = new StringBuilder();
        int ones = 0, zeros = 0;
        for(char ch : s.toCharArray()) {
            if (ch == '1') ones++;
            else zeros++;
        }

        while (ones-- > 1) {
            answer.append('1');
        }
        while (zeros-- > 0) {
            answer.append('0');
        }
        answer.append('1');
        return answer.toString();
    }
}
// @lc code=end

