/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

/*
56/56 cases passed (3 ms)
Your runtime beats 94.25 % of java submissions
Your memory usage beats 70.33 % of java submissions (44.3 MB)
*/

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        if (sc.length != tc.length) return false;

        int[] f = new int[26];
        for (int i = 0; i < sc.length; ++i) {
            f[sc[i] - 'a']++;
            f[tc[i] - 'a']--;
        }   

        for (int i : f) {
            if (i != 0) return false;
        }
        return true;
    }
}
// @lc code=end

