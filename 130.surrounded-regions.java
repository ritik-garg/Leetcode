/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

/*
58/58 cases passed (2 ms)
Your runtime beats 99.56 % of java submissions
Your memory usage beats 90.37 % of java submissions (44.9 MB)
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        if (m < 2 || n < 2)
            return;

        for (int i = 0; i < m; ++i) {
            solve(board, i, 0);
            solve(board, i, n - 1);
        }
        for (int i = 0; i < n; ++i) {
            solve(board, 0, i);
            solve(board, m - 1, i);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = board[i][j] == '*' ? 'O' : 'X';
            }
        }
    }

    private void solve(char[][] board, int x, int y) {
        if (!isValidIndex(board, x, y))
            return;
        board[x][y] = '*';
        solve(board, x + 1, y);
        solve(board, x - 1, y);
        solve(board, x, y + 1);
        solve(board, x, y - 1);
    }

    private boolean isValidIndex(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O';
    }
}
// @lc code=end
