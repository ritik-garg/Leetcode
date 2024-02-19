/*
 * @lc app=leetcode id=419 lang=java
 *
 * [419] Battleships in a Board
 */

/*
27/27 cases passed (1 ms)
Your runtime beats 95.77 % of java submissions
Your memory usage beats 96.18 % of java submissions (44.8 MB)
 */

// @lc code=start
class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int count = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if (board[i][j] == 'X') {
                    if ((i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
// @lc code=end

