/*
 * @lc app=leetcode id=1358 lang=java
 *
 * [1358] Number of Substrings Containing All Three Characters
 */

/*
54/54 cases passed (11 ms)
Your runtime beats 89.33 % of java submissions
Your memory usage beats 45.77 % of java submissions (44.6 MB)
 */

// @lc code=start
class Solution {
    public int numberOfSubstrings(String s) {
        int prev = 0, left = 0, right = 0, n = s.length();
        int answer = 0;
        int a = 0, b = 0, c = 0;
        while (right < n) {
            char ch = s.charAt(right++);
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;

            boolean changed = false;
            while (left < n && a > 0 && b > 0 && c > 0) {
                char t = s.charAt(left++);
                if (t == 'a') a--;
                else if (t == 'b') b--;
                else c--;
                changed = true;
            }

            if (changed) {
                answer += (n - right + 1) * (left - prev);
                prev = left;
            }
        }
        return answer;
    }
}
// @lc code=end

