/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

/*
65/65 cases passed (249 ms)
Your runtime beats 56.63 % of java submissions
Your memory usage beats 69.24 % of java submissions (44.8 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    class Trie {
        Trie[] next = new Trie[26];
        String word = null;
    }

    private Trie buildTrie(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            Trie next = trie;
            for (char c : word.toCharArray()) {
                if (next.next[c - 'a'] == null) {
                    next.next[c - 'a'] = new Trie();
                }
                next = next.next[c - 'a'];
            }
            next.word = word;
        }
        return trie;
    }

    private boolean isValid(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    private void dfs(char[][] board, Trie trie, Set<String> answer, int i, int j) {
        if (!isValid(board, i, j) || board[i][j] == '.' || trie.next[board[i][j] - 'a'] == null) {
            return;
        }

        int trieIndex = board[i][j] - 'a';
        if (trie.next[trieIndex].word != null) {
            answer.add(trie.next[trieIndex].word);
        }

        trie = trie.next[trieIndex];
        char saveChar = board[i][j];
        board[i][j] = '.';
        dfs(board, trie, answer, i + 1, j);
        dfs(board, trie, answer, i, j + 1);
        dfs(board, trie, answer, i - 1, j);
        dfs(board, trie, answer, i, j - 1);
        board[i][j] = saveChar;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> answer = new HashSet<>();
        Trie trie = buildTrie(words);
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, trie, answer, i, j);
            }
        }
        return new ArrayList<>(answer);
    }
}
// @lc code=end

/*
 * Just Using DFS,
 * Time Limit Exceeded
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 * class Solution {
 * private boolean isValid(char[][] board, int i, int j) {
 * return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
 * }
 * 
 * private boolean findWords(char[][] board, int i, int j, String word, int t) {
 * if (t >= word.length()) return true;
 * if (isValid(board, i, j) && board[i][j] == word.charAt(t)) {
 * board[i][j] = '.';
 * boolean answer = findWords(board, i + 1, j, word, t + 1) || findWords(board,
 * i - 1, j, word, t + 1)
 * || findWords(board, i, j + 1, word, t + 1) || findWords(board, i, j - 1,
 * word, t + 1);
 * board[i][j] = word.charAt(t);
 * return answer;
 * }
 * return false;
 * }
 * 
 * public List<String> findWords(char[][] board, String[] words) {
 * List<String> answer = new ArrayList<>();
 * for(String word : words) {
 * boolean isWordAdded = false;
 * for(int i = 0; i < board.length; ++i) {
 * for(int j = 0; j < board[i].length; ++j) {
 * if (board[i][j] == word.charAt(0) && findWords(board, i, j, word, 0)) {
 * answer.add(word);
 * isWordAdded = true;
 * break;
 * }
 * }
 * if (isWordAdded) break;
 * }
 * }
 * return answer;
 * }
 * }
 */