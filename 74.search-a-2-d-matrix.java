/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

/*
133/133 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 81.57 % of java submissions (43.4 MB)
*/

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, h = m * n - 1;
        while (l <= h) {
            int mid = h - (h - l) / 2;
            int r = mid / n, c = mid % n;
            if (target == matrix[r][c]) return true;
            if (target > matrix[r][c]) l = mid + 1;
            else h = mid - 1;
        }
        return false;
    }
}
// @lc code=end

