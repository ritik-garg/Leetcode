/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

/*
317/317 cases passed (2 ms)
Your runtime beats 73.57 % of java submissions
Your memory usage beats 31.16 % of java submissions (43.7 MB)
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1, i2 = num2.length() - 1;
        char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
        int carry = 0;
        StringBuilder answer = new StringBuilder();
        while (i1 >= 0 || i2 >= 0) {
            int sum = carry;
            sum += i1 >= 0 ? n1[i1--] - '0' : 0;
            sum += i2 >= 0 ? n2[i2--] - '0' : 0;
            carry = sum / 10;
            answer.append((char)(sum % 10 + '0'));
        }
        if (carry != 0) {
            answer.append((char)(carry + '0'));
        }
        return answer.reverse().toString();
    }
}
// @lc code=end
