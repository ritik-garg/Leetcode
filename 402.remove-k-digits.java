/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

/*
43/43 cases passed (4 ms)
Your runtime beats 98.38 % of java submissions
Your memory usage beats 89.34 % of java submissions (44.7 MB)
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length(), top = -1;
        char[] stack = new char[n];
        for (char ch : num.toCharArray()) {
            while (k > 0 && top >= 0 && ch < stack[top]) {
                k--;
                top--;
            }
            if (top >= 0 || ch != '0') {
                stack[++top] = ch;
            }
        }       
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i <= top - k; ++i) {
            answer.append(stack[i]);
        }
        return answer.length() == 0 ? "0" : answer.toString();
    }
}
// @lc code=end

