/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

/*
202/202 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 18.47 % of java submissions (45.8 MB)
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    if (i != 0 && j != 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        for (int j = 1; j < n; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; ++i) matrix[i][j] = 0;
            }
        }
        for (int i = 1; i < m; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; ++j) matrix[i][j] = 0;
            }
        }
        if (firstRow) {
            for (int j = 0; j < n; ++j) matrix[0][j] = 0;
        }
        if (firstCol) {
            for (int i = 0; i < m; ++i) matrix[i][0] = 0;
        }
    }
}
// @lc code=end

