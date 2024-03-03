/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

/*
20/20 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 65.27 % of java submissions (41.3 MB)
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int left = -1, right = n - 1, top = 0, bottom = n - 1;
        while (num <= n * n) {
            for(int i = ++left; i <= right; ++i) {
                answer[top][i] = num++;
            }
            for(int i = ++top; i <= bottom; ++i) {
                answer[i][right] = num++;
            }
            for(int i = --right; i >= left; --i) {
                answer[bottom][i] = num++;
            }
            for (int i = --bottom; i >= top; --i) {
                answer[i][left] = num++;
            }
        }
        return answer;
    }
}
// @lc code=end

