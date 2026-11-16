/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

/*
66/66 cases passed (8 ms)
Your runtime beats 94.1 % of java submissions
Your memory usage beats 81.48 % of java submissions (46.4 MB)
*/

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) return ans;
        int[] f = new int[26], t = new int[26];
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        for (int i = 0; i < pc.length; ++i) {
            f[pc[i] - 'a']++;
            t[sc[i] - 'a']++;
        }
        if (isEqual(f, t)) ans.add(0);

        for (int i = pc.length; i < sc.length; ++i) {
            t[sc[i - pc.length] - 'a']--;
            t[sc[i] - 'a']++;
            if (isEqual(f, t)) ans.add(i - pc.length + 1);
        }
        return ans;
    }

    private boolean isEqual(int[] f, int[] t) {
        for (int i = 0; i < 26; ++i) {
            if (f[i] != t[i]) return false;
        }
        return true;
    }
}
// @lc code=end

