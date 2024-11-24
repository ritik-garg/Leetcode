/*
 * @lc app=leetcode id=1975 lang=java
 *
 * [1975] Maximum Matrix Sum
 */

/*
98/98 cases passed (6 ms)
Your runtime beats 91.07 % of java submissions
Your memory usage beats 47.33 % of java submissions (55.1 MB)
 */

// @lc code=start
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE, negative = 0;
        long sum = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                int abs = Math.abs(matrix[i][j]);
                sum += abs;
                min = Math.min(min, abs);
                negative += abs == matrix[i][j] ? 0 : 1;
            }
        }
        if (negative % 2 != 0) {
            sum -= (2 * min);
        }
        return sum;
    }
}
// @lc code=end

