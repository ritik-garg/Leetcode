/*
 * @lc app=leetcode id=1759 lang=java
 *
 * [1759] Count Number of Homogenous Substrings
 */

/*
85/85 cases passed (7 ms)
Your runtime beats 85.96 % of java submissions
Your memory usage beats 92.86 % of java submissions (44.8 MB)
 */

// @lc code=start
class Solution {
    final int MODULO = 1000000007;
    public int countHomogenous(String s) {
        int count = 1, answer = 1;
        char[] string = s.toCharArray();
        for(int i = 1; i < string.length; ++i) {
            if (string[i] == string[i - 1]) count++;
            else count = 1;
            answer = (answer + count) % MODULO;
        }
        return answer;
    }
}
// @lc code=end

