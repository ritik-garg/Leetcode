/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

/*
131/131 cases passed (2 ms)
Your runtime beats 71.61 % of java submissions
Your memory usage beats 91.18 % of java submissions (45.8 MB)
*/

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return  false;

        int[] f = new int[26];
        for (char c : ransomNote.toCharArray()) f[c - 'a']--;
        for (char c : magazine.toCharArray()) f[c - 'a']++;
        for (int i : f) {
            if (i < 0) return false;
        }
        return true;
    }
}
// @lc code=end

