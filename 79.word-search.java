/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

/*
87/87 cases passed (129 ms)
Your runtime beats 86.32 % of java submissions
Your memory usage beats 74.16 % of java submissions (41.3 MB)
 */

// @lc code=start
class Solution {
    private boolean backtrack(char[][] board, char[] word, int w, int i, int j) {
        if(w == word.length) return true;
        
        int m = board.length, n = board[0].length;
        boolean ans = false;
        if(i >= 0 && i < m && j >= 0 && j < n && word[w] == board[i][j]) {
            board[i][j] = '0';
            ans = backtrack(board, word, w + 1, i+1, j) || backtrack(board, word, w + 1, i-1, j) ||
                backtrack(board, word, w + 1, i, j+1) || backtrack(board, word, w + 1, i, j-1);
            board[i][j] = word[w];
        }
        return ans;
    }

    public boolean exist(char[][] board, String w) {
        int m = board.length, n = board[0].length;
        char[] word = w.toCharArray();
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(word[0] == board[i][j]) {
                    board[i][j] = '0';
                    boolean e = backtrack(board, word, 1, i+1, j) || backtrack(board, word, 1, i-1, j) ||
                backtrack(board, word, 1, i, j+1) || backtrack(board, word, 1, i, j-1);
                    board[i][j] = word[0];
                    if(e) return e;
                }
            }
        }
        return false;
    }
}
// @lc code=end

