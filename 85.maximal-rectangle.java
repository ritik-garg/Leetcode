/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

/*
74/74 cases passed (4 ms)
Your runtime beats 87.39 % of java submissions
Your memory usage beats 83.29 % of java submissions (45.4 MB)
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] intMatrix = new int[m][n];
        for (int j = 0; j < n; ++j) {
            int prev = 0;
            for (int i = 0; i < m; ++i) {
                intMatrix[i][j] = matrix[i][j] == '0' ? 0 : 1 + prev;
                prev = intMatrix[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < m; ++i) {
            max = Math.max(max, largestRectangleArea(intMatrix[i]));
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] lessFromLeft = getLeftMinHeightIndices(heights);
        int[] lessFromRight = getRightMinHeightIndices(heights);

        int max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, (lessFromRight[i] - lessFromLeft[i] - 1) * heights[i]);
        }
        return max;
    }

    private int[] getLeftMinHeightIndices(int[] heights) {
        int n = heights.length;
        int[] leftIndices = new int[n];
        leftIndices[0] = -1;
        for (int i = 1; i < n; ++i) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i]) {
                t = leftIndices[t];
            }
            leftIndices[i] = t;
        }
        return leftIndices;
    }

    private int[] getRightMinHeightIndices(int[] heights) {
        int n = heights.length;
        int[] rightIndices = new int[n];
        rightIndices[n - 1] = n;
        for (int i = n - 2; i >= 0; --i) {
            int t = i + 1;
            while (t < n && heights[t] >= heights[i]) {
                t = rightIndices[t];
            }
            rightIndices[i] = t;
        }
        return rightIndices;
    }
}
// @lc code=end

