/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

/**
130/130 cases passed (6 ms)
Your runtime beats 99.24 % of java submissions
Your memory usage beats 93.67 % of java submissions (49 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for (String str : strs) {
            char[] f = new char[26];
            for (char ch : str.toCharArray()) f[ch - 'a']++;
            String k = String.valueOf(f);
            List<String> l = ans.getOrDefault(k, new ArrayList<>());
            l.add(str);
            ans.put(k, l);
        }
        return new ArrayList<>(ans.values());
    }
}
// @lc code=end

