/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

/*
45/45 cases passed (3 ms)
Your runtime beats 99.09 % of java submissions
Your memory usage beats 19.55 % of java submissions (42.7 MB)
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] indexS = new int[256], indexT = new int[256];
        char[] charS = s.toCharArray(), charT = t.toCharArray();
        int n = charS.length;
        for (int i = 0; i < n; ++i) {
            if (indexS[charS[i]] != indexT[charT[i]]) return false;
            indexS[charS[i]] = i + 1; 
            indexT[charT[i]] = i + 1; 
        }
        return true;
    }
}
// @lc code=end
