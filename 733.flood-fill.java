/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

/*
278/278 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 83.16 % of java submissions (44.9 MB)
 */

// @lc code=start
class Solution {
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc = image[sr][sc];
        if (oc == color) return image;
        int m = image.length, n = image[0].length;
        fill(image, sr, sc, color, oc, m, n);
        return image;
    }

    private void fill(int[][] i, int r, int c, int nc, int oc, int m, int n) {
        if (valid(i, r, c, oc, m, n)) {
            i[r][c] = nc;
            for (int[] d : dir) {
                if (valid(i, r + d[0], c + d[1], oc, m, n))
                    fill(i, r + d[0], c + d[1], nc, oc, m, n);
            }
        }
    }

    private boolean valid(int[][] i, int r, int c, int oc, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n && i[r][c] == oc;
    }
}
// @lc code=end

