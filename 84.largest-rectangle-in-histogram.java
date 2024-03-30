/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

/*
99/99 cases passed (12 ms)
Your runtime beats 92.36 % of java submissions
Your memory usage beats 93.52 % of java submissions (56.2 MB)
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
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
