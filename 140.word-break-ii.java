/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

/*
27/27 cases passed (1 ms)
Your runtime beats 94.13 % of java submissions
Your memory usage beats 99.32 % of java submissions (41 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        backtrack(s.toCharArray(), 0, new StringBuilder(), dict, result);
        return result;
    }

    private void backtrack(char[] s, int startIdx, StringBuilder currentString, Set<String> dict, List<String> result) {
        if (startIdx >= s.length) {
            result.add(currentString.toString());
            return;
        }

        StringBuilder currentWord = new StringBuilder();
        for (int i = startIdx; i < s.length; ++i) {
            currentWord.append(s[i]);
            if (dict.contains(currentWord.toString())) {
                if (currentString.length() != 0) currentString.append(" ");
                currentString.append(currentWord);
                backtrack(s, i + 1, currentString, dict, result);
                currentString.setLength(currentString.length() - currentWord.length());
                if (currentString.length() != 0) currentString.setLength(currentString.length() - 1);
            }
        }
    }
}
// @lc code=end

