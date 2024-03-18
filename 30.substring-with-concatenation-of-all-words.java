/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

/*
179/179 cases passed (1309 ms)
Your runtime beats 72 % of java submissions
Your memory usage beats 55.41 % of java submissions (45.9 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String,Integer> counts = new HashMap<>();
        for (String word : words) counts.put(word, counts.getOrDefault(word, 0) + 1);

        int nWords = words.length, size = words[0].length(), n = s.length();
        char[] str = s.toCharArray();
        for (int i = 0; i <= n - size * nWords; ++i) {
            if (isConcat(str, i, nWords, size, counts)) answer.add(i);
        }

        return answer;
    }

    private boolean isConcat(char[] s, int start, int nWords, int size, Map<String,Integer> counts) {
        Map<String,Integer> seen = new HashMap<>();
        for (int i = 0; i < nWords; ++i) {
            String currWord = new String(s, start + i * size, size);
            seen.put(currWord, seen.getOrDefault(currWord, 0) + 1);
        }
        return seen.equals(counts);
    }
}
// @lc code=end
