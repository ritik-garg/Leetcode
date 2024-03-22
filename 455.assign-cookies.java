/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

/*
21/21 cases passed (8 ms)
Your runtime beats 98.31 % of java submissions
Your memory usage beats 21.21 % of java submissions (45.4 MB)
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int answer = 0;
        int a = 0, b = 0;
        while (a < g.length && b < s.length) {
            if (g[a] <= s[b]) {
                answer++;
                a++;
                b++;
            } else b++;
        }
        return answer;
    }
}
// @lc code=end

