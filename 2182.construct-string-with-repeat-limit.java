/*
 * @lc app=leetcode id=2182 lang=java
 *
 * [2182] Construct String With Repeat Limit
 */

/*
150/150 cases passed (17 ms)
Your runtime beats 92.8 % of java submissions
Your memory usage beats 50.42 % of java submissions (45.8 MB)
 */

// @lc code=start
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) f[c - 'a']++;

        StringBuilder ans = new StringBuilder();
        for (int i = 25; i >= 0; --i) {
            if (f[i] <= 0) continue;
            for (int j = 0; j < repeatLimit && f[i] > 0; ++j) {
                ans.append((char)('a' + i));
                f[i]--;
            }

            if (f[i] > 0) {
                for (int j = i - 1; j >= 0; --j) {
                    if (f[j] > 0) {
                        ans.append((char)('a' + j));
                        f[j]--;
                        i++;
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }
}
// @lc code=end

