/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

/*
42/42 cases passed (1 ms)
Your runtime beats 73.35 % of java submissions
Your memory usage beats 96.06 % of java submissions (40.9 MB)
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) return false;

        String[] map = new String[26];
        Map<String, Integer> reverseMap = new HashMap<>();
        char[] patternChars = pattern.toCharArray();
        for (int i = 0; i < patternChars.length; ++i) {
            int currentChar = patternChars[i] - 'a';
            if (map[currentChar] != null && !split[i].equals(map[currentChar])) {
                return false;
            }
            if (reverseMap.get(split[i]) != null && reverseMap.get(split[i]) != currentChar) {
                return false;
            }
            map[currentChar] = split[i];
            reverseMap.put(split[i], currentChar);
        }
        return true;
    }
}
// @lc code=end

