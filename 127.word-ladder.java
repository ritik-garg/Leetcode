/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

/*
51/51 cases passed (115 ms)
Your runtime beats 34.6 % of java submissions
Your memory usage beats 29.92 % of java submissions (47.8 MB)
 */

// @lc code=start
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) return depth + 1;

                for (int j = 0; j < currentWord.length(); ++j) {
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        StringBuilder sb = new StringBuilder(currentWord);
                        sb.setCharAt(j, ch);
                        String word = sb.toString();
                        if (wordSet.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            } 
            depth++;  
        }
        return 0;
    }
}
// @lc code=end

