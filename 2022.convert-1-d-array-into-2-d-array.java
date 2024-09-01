/*
 * @lc app=leetcode id=2022 lang=java
 *
 * [2022] Convert 1D Array Into 2D Array
 */

/*
107/107 cases passed (3 ms)
Your runtime beats 97.73 % of java submissions
Your memory usage beats 57.13 % of java submissions (55.5 MB)
 */

// @lc code=start
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int l = original.length;
        if (m * n != l) return new int[0][0];
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer[i][j] = original[n * i + j];
            }
        }
        return answer;
    }
}
// @lc code=end

