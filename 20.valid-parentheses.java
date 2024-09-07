/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

/*
99/99 cases passed (1 ms)
Your runtime beats 98.7 % of java submissions
Your memory usage beats 71.65 % of java submissions (41.3 MB)
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            }
            else if (ch == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                else return false;
            }
            else if (ch == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

