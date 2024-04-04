/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */

/*
290/290 cases passed (11 ms)
Your runtime beats 40.13 % of java submissions
Your memory usage beats 40.61 % of java submissions (45.2 MB)
 */

// @lc code=start
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean isScramble(String s1, String s2) {
        Map<String,Boolean> dp = new HashMap<>();
        return solve(new StringBuilder(s1), new StringBuilder(s2), dp);
    }

    private boolean solve(StringBuilder s1, StringBuilder s2, Map<String,Boolean> dp) {
        int n = s1.length();
        if (s1.toString().equals(s2.toString())) return true;
        if (n == 1) return false;

        String key = s1 + "#" + s2;
        if (dp.containsKey(key)) return dp.get(key);

        if (!isPermutation(s1, s2)) {
            dp.put(key, false);
            return false;
        }

        for (int i = 1; i < n; ++i) {
            boolean unswapped = solve(new StringBuilder(s1.substring(0, i)), new StringBuilder(s2.substring(0, i)), dp) 
                && solve(new StringBuilder(s1.substring(i)), new StringBuilder(s2.substring(i)), dp);
            if (unswapped) {
                dp.put(key, true);
                return true;
            }

            boolean swapped = solve(new StringBuilder(s1.substring(0, i)), new StringBuilder(s2.substring(n - i)), dp) 
                && solve(new StringBuilder(s1.substring(i)), new StringBuilder(s2.substring(0, n - i)), dp);
            if (swapped) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }

    private boolean isPermutation(StringBuilder s1, StringBuilder s2) {
        int n = s1.length();
        int[] f1 = new int[26], f2 = new int[26];
        for (int i = 0; i < n; ++i) {
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(f1, f2);
    }
}
// @lc code=end

