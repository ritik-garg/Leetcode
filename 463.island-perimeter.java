/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

/*
5833/5833 cases passed (4 ms)
Your runtime beats 99.58 % of java submissions
Your memory usage beats 42.14 % of java submissions (45.7 MB)
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        int answer = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    int up = i == 0 ? 0 : grid[i - 1][j];
                    int down = i == m - 1 ? 0 : grid[i + 1][j];
                    int left = j == 0 ? 0 : grid[i][j - 1];
                    int right = j == n - 1 ? 0 : grid[i][j + 1];

                    answer += 4 - (up + down + right + left);
                }
            }
        }
        return answer;
    }
}
// @lc code=end
