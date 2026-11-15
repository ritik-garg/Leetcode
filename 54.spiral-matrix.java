/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

/*
27/27 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 95.45 % of java submissions (42.3 MB)
*/

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int t = 0, b = m - 1, l = 0, r = n - 1;

        while (t <= b && l <= r) {
            for (int i = l; i <= r && t <= b; ++i) {
                ans.add(matrix[t][i]);
            }
            t++;

            for (int i = t; i <= b && r >= l; ++i) {
                ans.add(matrix[i][r]);
            }
            r--;

            for (int i = r; i >= l && b >= t; --i) {
                ans.add(matrix[b][i]);
            }
            b--;

            for (int i = b; i >= t && l <= r; --i) {
                ans.add(matrix[i][l]);
            }
            l++;
        }
        return ans;
    }
}
// @lc code=end

